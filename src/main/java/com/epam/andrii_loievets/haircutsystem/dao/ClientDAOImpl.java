package com.epam.andrii_loievets.haircutsystem.dao;

import com.epam.andrii_loievets.haircutsystem.entity.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andrii_Loievets
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ClientDAOImpl implements ClientDAO {

    @PersistenceContext(unitName = "mainunit")
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Client findById(int id) {
        return em.find(Client.class, id);
    }

    @Override
    public Client findByEmail(String email) {
        TypedQuery<Client> query = em.createNamedQuery("Client.findByEmail",
                Client.class);
        query.setParameter("email", email);

        List<Client> users = query.getResultList();

        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }
    
    @Override
    public Client findByPhone(String phone) {
        TypedQuery<Client> query = em.createNamedQuery("Client.findByPhone",
                Client.class);
        query.setParameter("phone", phone);

        List<Client> users = query.getResultList();

        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    @Override
    public List<Client> findAll() {
        TypedQuery<Client> query = em.createNamedQuery("Client.findAll",
                Client.class);

        return query.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Client insert(Client client) {
        client.setUserId(client.getBasicUser().getUserId());
        em.persist(client);

        return client;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public boolean deleteById(int id) {
        Client client = em.find(Client.class, id);

        if (client != null) {
            em.remove(client);
            return true;
        }

        return false;
    }
}
