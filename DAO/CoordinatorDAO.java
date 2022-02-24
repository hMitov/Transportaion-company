package DAO;
import DTO.CoordinatorDTO;
import configuration.SessionFactoryUtil;
import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CoordinatorDAO {
    public static void saveCoordiantor(Coordinator coordinator) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(coordinator);
            transaction.commit();
        }
    }

    public static void saveCoordinators(Set<Coordinator> coordinators) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            coordinators.stream().forEach(coor->  session.save(coor));
            transaction.commit();
        }
    }

    public static List<CoordinatorDTO> readAllCoordinators() {
        List<CoordinatorDTO> coordinatorDTOS;
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            coordinatorDTOS = new ArrayList<CoordinatorDTO>(session.createQuery("SELECT new DTO.CoordinatorDTO(c.id, c.name, c.egn, c.salary, c.employeePosition, c.contractDate, c.agentPassword) FROM Coordinator c", CoordinatorDTO.class).getResultList());
            transaction.commit();
            return coordinatorDTOS;
        }
    }

    public static Coordinator getCoordinator(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Coordinator> criteriaQuery = criteriaBuilder.createQuery(Coordinator.class);
            Root<Coordinator> root = criteriaQuery.from(Coordinator.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
            Query<Coordinator> query = session.createQuery(criteriaQuery);
            return query.getSingleResult();
        }
    }

    public static Coordinator getCoordinator(Coordinator coordinator) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT c FROM Coordinator c where c.egn=:egn", Coordinator.class)
                    .setParameter("egn", coordinator.getEgn()).getSingleResult();
        }
    }


    public static void createOrUpdate(Coordinator coordinator) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(coordinator);
            transaction.commit();
        }
    }

    public static void deleteCoordinator(long id) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("Update Coordinator set agentPassword=:agentPassword, salary=:sal where id=:id")
                    .setParameter("agentPassword", null)
                    .setParameter("sal", null)
                    .setParameter("id", id).executeUpdate();
            transaction.commit();
        }
    }

    public static List<Coordinator> filterCoordinatorsBySalary() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Coordinator> criteriaQuery = criteriaBuilder.createQuery(Coordinator.class);
            Root<Coordinator> root = criteriaQuery.from(Coordinator.class);
            criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("salary")));

            Query<Coordinator> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public static List<Coordinator> filterCoordinatorsByPosition() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Coordinator> criteriaQuery = criteriaBuilder.createQuery(Coordinator.class);
            Root<Coordinator> root = criteriaQuery.from(Coordinator.class);
            criteriaQuery.select(root).orderBy(criteriaBuilder.asc(root.get("employeePosition")));

            Query<Coordinator> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

}
