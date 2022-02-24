package DAO;
import DTO.TransportationDTO;
import configuration.SessionFactoryUtil;
import entity.Status;
import entity.Transportation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TransportationDAO {
    public static void saveTransportation(Transportation transportation) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(transportation);
            transaction.commit();
        }
    }

    public static void saveTransportations(Set<Transportation> transportations) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transportations.stream().forEach(transport->  session.save(transport));
            transaction.commit();
        }
    }

    public static List<TransportationDTO> readAllTransportations() {
        List<TransportationDTO> transportationDTOS;
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transportationDTOS = new ArrayList<TransportationDTO>(session.createQuery("SELECT new DTO.TransportationDTO(t.id, t.departPoint, t.arrivalPoint, t.departTime, t.arrivalTime, t.typeOfLoad," +
                    " t.weight_in_truck, t.weight_in_trailer, t.numberOfPassengers, t.price, t.status) FROM Transportation t", TransportationDTO.class).getResultList());
            transaction.commit();
            return transportationDTOS;
        }
    }

    public static List<Transportation> readAllTransportationsEntity() {
        List<Transportation> transportations;
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            transportations = new ArrayList<Transportation>(session.createQuery("SELECT t FROM Transportation t", Transportation.class).getResultList());
            transaction.commit();
            return transportations;
        }
    }

    public static Transportation getTransportation(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Transportation> criteriaQuery = criteriaBuilder.createQuery(Transportation.class);
            Root<Transportation> root = criteriaQuery.from(Transportation.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
            Query<Transportation> query = session.createQuery(criteriaQuery);
            return query.getSingleResult();
        }
    }


    public static Transportation getTransportation(Transportation transportation) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT t FROM Transportation t where t.departTime=:departTime and t.vehicle=:vehicle", Transportation.class)
                    .setParameter("departTime", transportation.getDepartTime()).setParameter("vehicle", transportation.getVehicle()).getSingleResult();
        }
    }

    public static void createOrUpdate(Transportation transportation) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(transportation);
            transaction.commit();
        }
    }

    public static void deleteTransportation(Transportation transportation) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(transportation);
            transaction.commit();
        }
    }

    public static List<TransportationDTO> filterTransportationsByStartingPoint() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<TransportationDTO> criteriaQuery = criteriaBuilder.createQuery(TransportationDTO.class);
            Root<Transportation> root = criteriaQuery.from(Transportation.class);
            criteriaQuery.multiselect(root.get("id"), root.get("departPoint"), root.get("arrivalPoint"), root.get("departTime"),
                    root.get("arrivalTime"), root.get("typeOfLoad"), root.get("weight_in_truck") ,root.get("weight_in_trailer"),
                    root.get("numberOfPassengers"), root.get("price"), root.get("status")).orderBy(criteriaBuilder.asc(root.get("departPoint")));
            Query<TransportationDTO> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public static List<TransportationDTO> filterTransportationsByEndingPoint() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<TransportationDTO> criteriaQuery = criteriaBuilder.createQuery(TransportationDTO.class);
            Root<Transportation> root = criteriaQuery.from(Transportation.class);
            criteriaQuery.multiselect(root.get("id"), root.get("departPoint"), root.get("arrivalPoint"), root.get("departTime"),
                    root.get("arrivalTime"), root.get("typeOfLoad"), root.get("weight_in_truck") ,root.get("weight_in_trailer"),
                    root.get("numberOfPassengers"), root.get("price"), root.get("status")).orderBy(criteriaBuilder.asc(root.get("arrivalPoint")));

            Query<TransportationDTO> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public static List<TransportationDTO> filterTransportationsByStartingDate() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<TransportationDTO> criteriaQuery = criteriaBuilder.createQuery(TransportationDTO.class);
            Root<Transportation> root = criteriaQuery.from(Transportation.class);
            criteriaQuery.multiselect(root.get("id"), root.get("departPoint"), root.get("arrivalPoint"), root.get("departTime"),
                    root.get("arrivalTime"), root.get("typeOfLoad"), root.get("weight_in_truck") ,root.get("weight_in_trailer"),
                    root.get("numberOfPassengers"), root.get("price"), root.get("status")).orderBy(criteriaBuilder.desc(root.get("departTime")));

            Query<TransportationDTO> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public static List<TransportationDTO> filterTransportationsByStatusThenDepartTime() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<TransportationDTO> criteriaQuery = criteriaBuilder.createQuery(TransportationDTO.class);
            Root<Transportation> root = criteriaQuery.from(Transportation.class);
            criteriaQuery.multiselect(root.get("id"), root.get("departPoint"), root.get("arrivalPoint"), root.get("departTime"),
                    root.get("arrivalTime"), root.get("typeOfLoad"), root.get("weight_in_truck") ,root.get("weight_in_trailer"),
                    root.get("numberOfPassengers"), root.get("price"), root.get("status")).orderBy(criteriaBuilder.desc(root.get("status")), criteriaBuilder.desc(root.get("departTime")));

            Query<TransportationDTO> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public static List<TransportationDTO> transportationsWithFinishedStatus() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<TransportationDTO> criteriaQuery = criteriaBuilder.createQuery(TransportationDTO.class);
            Root<Transportation> root = criteriaQuery.from(Transportation.class);
            criteriaQuery.multiselect(root.get("id"), root.get("departPoint"), root.get("arrivalPoint"), root.get("departTime"),
                    root.get("arrivalTime"), root.get("typeOfLoad"), root.get("weight_in_truck") ,root.get("weight_in_trailer"),
                    root.get("numberOfPassengers"), root.get("price"), root.get("status")).where(criteriaBuilder.equal(root.get("status"), Status.FINISHED));

            Query<TransportationDTO> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public static BigDecimal moneyFromAllFinishedTransportations() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<TransportationDTO> criteriaQuery = criteriaBuilder.createQuery(TransportationDTO.class);
            Root<Transportation> root = criteriaQuery.from(Transportation.class);
            criteriaQuery.multiselect(root.get("id"), root.get("departPoint"), root.get("arrivalPoint"), root.get("departTime"),
                    root.get("arrivalTime"), root.get("typeOfLoad"), root.get("weight_in_truck") ,root.get("weight_in_trailer"),
                    root.get("numberOfPassengers"), root.get("price"), root.get("status")).where(criteriaBuilder.equal(root.get("status"), Status.FINISHED));

            Query<TransportationDTO> query = session.createQuery(criteriaQuery);
            BigDecimal allMoney = BigDecimal.valueOf(0);
            for(TransportationDTO transportation : query.getResultList()) {
                allMoney = allMoney.add(transportation.getPrice());
            }
            return allMoney;
        }
    }

    public static void incomeFromTransportationsForAPeriod(LocalDateTime start, LocalDateTime finish) {
        BigDecimal moneyFromTransportations = BigDecimal.valueOf(0);
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<TransportationDTO> criteriaQuery = criteriaBuilder.createQuery(TransportationDTO.class);
            Root<Transportation> root = criteriaQuery.from(Transportation.class);
            criteriaQuery.multiselect(root.get("id"), root.get("departPoint"), root.get("arrivalPoint"), root.get("departTime"),
                    root.get("arrivalTime"), root.get("typeOfLoad"), root.get("weight_in_truck") ,root.get("weight_in_trailer"),
                    root.get("numberOfPassengers"), root.get("price"), root.get("status")).where(criteriaBuilder.and(criteriaBuilder.equal(root.get("status"), Status.FINISHED), criteriaBuilder.between(root.get("arrivalTime"), start, finish)));

            Query<TransportationDTO> query = session.createQuery(criteriaQuery);

            for(TransportationDTO transportation : query.getResultList()) {
                moneyFromTransportations = moneyFromTransportations.add(transportation.getPrice());
            }
            query.getResultList().stream().forEach(System.out::println);
            System.out.println("Total income is: " + moneyFromTransportations);
            transaction.commit();
        }
    }

    public static void putAllTransportationsInFile() {
        String filename = "files/TransportationReport.txt";
            try (FileWriter fout = new FileWriter(filename)) {
                fout.write(TransportationDAO.readAllTransportationsEntity().toString());
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found!" + e);
            } catch (IOException e) {
                System.out.println("IO Exception!" + e);
            }
    }

    public static List<String> readAllTransportationsFromFile() {
        List<String> string = new ArrayList<>();
        try(FileReader fin = new FileReader(new File("files/TransportationReport.txt"))) {
            BufferedReader bufferedReader = new BufferedReader(fin);
            String line = "";
            while((line = bufferedReader.readLine()) != null)
                string.add(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
}
