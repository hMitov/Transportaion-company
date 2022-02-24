package DAO;

import DTO.VehicleDTO;
import configuration.SessionFactoryUtil;
import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class VehicleDAO {
    public static void saveVehicle(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        }
    }

    public static void saveVehicles(Set<Vehicle> vehicles) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicles.stream().forEach(veh->  session.save(veh));
            transaction.commit();
        }
    }

    public static List<VehicleDTO> readAllVehicles() {
        List<VehicleDTO> vehicleDTOS;
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            vehicleDTOS = new ArrayList<VehicleDTO>(session.createQuery("SELECT new DTO.VehicleDTO(v.id, v.brand, v.model, v.regPlate, v.productionDate, v.typeOfVehicle, v.maxNumOfPassengers, v.vehicle_weight) FROM Vehicle v", VehicleDTO.class).getResultList());
            transaction.commit();
            return vehicleDTOS;
        }
    }

    public static Vehicle getVehicle(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
            Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
            Query<Vehicle> query = session.createQuery(criteriaQuery);
            return query.getSingleResult();
        }
    }

    public static Vehicle getVehicle(Vehicle vehicle) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT v FROM Vehicle v where v.regPlate=:regPlate", Vehicle.class)
                    .setParameter("regPlate", vehicle.getRegPlate()).getSingleResult();
        }
    }

    public static void createOrUpdate(Vehicle vehicle) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            transaction.commit();
        }
    }

    public static void deleteVehicle(Vehicle vehicle) throws NoResultException {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(vehicle);
            transaction.commit();
        }
    }

    public static boolean ifVehicleAttendsOtherTransAtSameTime(long id, LocalDateTime depart, LocalDateTime arr) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Transportation> transportations = null;
            try {
                transportations = new ArrayList<Transportation>(session.createQuery("Select v from Vehicle v join fetch v.allTransportationsMade where v.id=:id", Vehicle.class)
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
}
