package DAO;

import DTO.ClientDTO;
import configuration.SessionFactoryUtil;
import entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClientDAO {
    public static void saveClient(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    public static void saveClients(Set<Client> clients) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clients.stream().forEach(cl->  session.save(cl));
            transaction.commit();
        }
    }

    public static List<ClientDTO> readAllClients() {
        List<ClientDTO> clientDTOS;
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            clientDTOS = new ArrayList<ClientDTO>(session.createQuery("SELECT new DTO.ClientDTO(c.id, c.name, c.address, c.contractDate, c.owedMoney, c.allPaidMoney) FROM Client c", ClientDTO.class).getResultList());
            transaction.commit();
            return clientDTOS;
        }
    }

    public static Client getClient(Client client) throws NoResultException {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT c FROM Client c where c.name=:name and c.address=:address", Client.class)
                    .setParameter("name", client.getName()).setParameter("address", client.getAddress()).getSingleResult();
        }
    }

    public static Client getClient(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root<Client> root = criteriaQuery.from(Client.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
            Query<Client> query = session.createQuery(criteriaQuery);
            return query.getSingleResult();
        }
    }

    public static void createOrUpdate(Client client) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(client);
            transaction.commit();
        }
    }

    public static void deleteClient(Client client) {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("Update Client set contractDate=:contractDate where id=:id")
                    .setParameter("contractDate", null)
                    .setParameter("id", client.getId()).executeUpdate();
            transaction.commit();
        }
    }


    public static List<Client> filterClientsOwedMoney() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root<Client> root = criteriaQuery.from(Client.class);
            criteriaQuery.select(root).where(criteriaBuilder.greaterThan(root.get("owedMoney"), BigDecimal.valueOf(0))).orderBy(criteriaBuilder.asc(root.get("owedMoney")));

            Query<Client> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }

    public static List<Client> filterClientsPaidMoney() {
        try(Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root<Client> root = criteriaQuery.from(Client.class);
            criteriaQuery.select(root).where(criteriaBuilder.greaterThan(root.get("allPaidMoney"), BigDecimal.valueOf(0))).orderBy(criteriaBuilder.asc(root.get("allPaidMoney")));

            Query<Client> query = session.createQuery(criteriaQuery);
            return query.getResultList();
        }
    }
}
