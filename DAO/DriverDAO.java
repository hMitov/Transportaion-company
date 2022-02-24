package DAO;

import DTO.DriverDTO;
import DTO.TransportationDTO;
import configuration.SessionFactoryUtil;

import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DriverDAO {
    public static void saveDriver(Driver driver) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(driver);
            transaction.commit();
        }
    }

    public static void saveDrivers(Set<Driver> drivers) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            drivers.stream().forEach(dr->  session.save(dr));
            transaction.commit();
        }
    }


    public static List<DriverDTO> readAllDrivers() {
        List<DriverDTO> driverDTOS;
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            driverDTOS = new ArrayList<DriverDTO>(session.createQuery("SELECT new DTO.DriverDTO(d.id, d.name, d.egn, d.salary, d.employeePosition, d.contractDate, d.drivingLicenseCategory) FROM Driver d", DriverDTO.class).getResultList());
            transaction.commit();
            return driverDTOS;
        }
    }

    public static Driver getDriver(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Driver> criteriaQuery = criteriaBuilder.createQuery(Driver.class);
            Root<Driver> root = criteriaQuery.from(Driver.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
            Query<Driver> query = session.createQuery(criteriaQuery);
            return query.getSingleResult();
        }
    }

    public static Driver getDriver(Driver driver) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT d FROM Driver d where d.egn=:egn", Driver.class)
                    .setParameter("egn", driver.getEgn()).getSingleResult();
        }
    }


    public static void createOrUpdate(Driver driver) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(driver);
            transaction.commit();
        }
    }

    public static void deleteDriver(long id) throws NullPointerException{
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("Update Driver set employeePosition=:pos, salary=:sal where id=:id")
                    .setParameter("pos", null)
                    .setParameter("sal", null)
                    .setParameter("id", id).executeUpdate();
            System.out.println("second");
            List<Transportation> transportations = null;
            List<Transportation> needChange = new ArrayList<Transportation>();
            try {
               transportations = new ArrayList<Transportation>(session.createQuery("Select d from Driver d join fetch d.allTransportationsMade where d.id=:id", Driver.class)
                        .setParameter("id", id).getSingleResult().getAllTransportationsMade());
            } catch (NoResultException nre){ }

            for(Transportation transportation : transportations) {
                if(transportation.getStatus().equals(Status.NOT_FINISHED))
                    needChange.add(transportation);
            }
            if(needChange.size() != 0) {
                System.out.println("These transportations need change of driver!");
                needChange.stream().forEach(System.out::println);
            }
            transaction.commit();
        }
    }

    public static boolean ifDriverAttendsOtherTransAtSameTime(long id, LocalDateTime depart, LocalDateTime arr) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Transportation> transportations = null;
            try {
                transportations = new ArrayList<Transportation>(session.createQuery("Select d from Driver d join fetch d.allTransportationsMade where d.id=:id", Driver.class)
                        .setParameter("id", id).getSingleResult().getAllTransportationsMade());
            } catch (NoResultException nre){ }

            if(transportations == null)
                return true;
            for(Transportation transportation : transportations) {
                if(!(depart.isBefore(transportation.getDepartTime()) && arr.isBefore(transportation.getArrivalTime()) ||
                        depart.isAfter(transportation.getDepartTime()) && arr.isAfter(transportation.getArrivalTime()))) {
                    return false;
                }
            }
            transaction.commit();
            return true;
        }
    }

    public static List<Driver> filterDriversBySalary() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Driver> criteriaQuery = criteriaBuilder.createQuery(Driver.class);
            Root<Driver> root = criteriaQuery.from(Driver.class);
            criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("salary")));

            Query<Driver> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public static void getDriversTransportations(long id) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            BigDecimal moneyFromDriver = BigDecimal.valueOf(0);
            List<TransportationDTO> transportationDTOS = new ArrayList<TransportationDTO>(session.createQuery("Select new DTO.TransportationDTO(t.id, t.departPoint, t.arrivalPoint, t.departTime," +
                            "t.arrivalTime, t.typeOfLoad, t.weight_in_truck, t.weight_in_trailer, t.numberOfPassengers, " +
                            "t.price, t.status) from Transportation t " +
                            "Join t.driver d " +
                            "where d.id=:id and t.status=:status", TransportationDTO.class)
                    .setParameter("id", id).setParameter("status", Status.FINISHED).getResultList());
            for(TransportationDTO transportation : transportationDTOS) {
                moneyFromDriver = moneyFromDriver.add(transportation.getPrice());
            }
            System.out.println("Driver " + id);
            transportationDTOS.stream().forEach(System.out::println);
            System.out.println(moneyFromDriver);
            transaction.commit();
        }
    }

}
