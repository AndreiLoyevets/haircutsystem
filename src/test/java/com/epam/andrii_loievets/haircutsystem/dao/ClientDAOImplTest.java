///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.epam.andrii_loievets.haircutsystem.dao;
//
//import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
//import com.epam.andrii_loievets.haircutsystem.entity.Client;
//import java.util.List;
//import javax.persistence.Persistence;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Andrii_Loievets
// */
//public class ClientDAOImplTest extends DAOTest {
//
//    protected static ClientDAOImpl clientDAO;
//    protected static final int EXISTING_USER_ID = 3;
//    protected static final int NO_CLIENT_USER_ID = 2;
//    protected static final String NO_CLIENT_NAME = "Sam";
//    protected static final String NO_CLIENT_SURNAME = "Winchester";
//    protected static final String NO_CLIENT_EMAIL = "sam@gmail.com";
//    protected static final String EMAIL = "aloyevets@gmail.com";
//
//    @BeforeClass
//    public static void setUpClass() {
//        emf = Persistence.createEntityManagerFactory(UNIT_NAME);
//        em = emf.createEntityManager();
//
//        clientDAO = new ClientDAOImpl();
//        clientDAO.setEm(em);
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//        em.close();
//        emf.close();
//    }
//
//    /**
//     * Test of findById method, of class ClientDAOImpl.
//     */
//    @Test
//    public void findById_ValidId_ClientFound() {
//        Client client = clientDAO.findById(EXISTING_USER_ID);
//
//        assertNotNull(client);
//    }
//
//    /**
//     * Test of findById method, of class ClientDAOImpl.
//     */
//    @Test
//    public void findById_ValidId_UserNotNull() {
//        Client client = clientDAO.findById(EXISTING_USER_ID);
//
//        assertNotNull("Client not found", client);
//
//        BasicUser user = client.getBasicUser();
//        assertNotNull("User not found", user);
//        assertEquals("Wrong user", user.getUserId(), client.getUserId());
//    }
//
//    /**
//     * Test of findById method, of class ClientDAOImpl.
//     */
//    @Test
//    public void findById_InvalidId_ClientNotFound() {
//        Client client = clientDAO.findById(-EXISTING_USER_ID);
//
//        assertNull(client);
//    }
//
//    @Test
//    public void findByEmail_ValidEmail_ClientFound() {
//        Client client = clientDAO.findByEmail(EMAIL);
//
//        assertNotNull(client);
//    }
//
//    @Test
//    public void findByEmail_InvalidEmail_ClientNotFound() {
//        Client client = clientDAO.findByEmail(EMAIL + "o");
//
//        assertNull(client);
//    }
//
//    @Test
//    public void findAll_NotEmptyList() {
//        List<Client> clients = clientDAO.findAll();
//        assertNotNull(clients);
//        assertFalse(clients.isEmpty());
//    }
//
////    @Test
////    public void insert_ExistingUser_Persisted() {
////        BasicUserDAOImpl userDAO = new BasicUserDAOImpl();
////        userDAO.setEm(em);
////
////        BasicUser user = userDAO.findById(NO_CLIENT_USER_ID);
////
////        assertNotNull("Cannot find user", user);
////
////        Client client = new Client();
////        client.setBasicUser(user);
////        client.setName(NO_CLIENT_NAME);
////        client.setSurname(NO_CLIENT_SURNAME);
////        client.setEmail(NO_CLIENT_EMAIL);
////
////        try {
////            em.getTransaction().begin();
////            clientDAO.insert(client);
////            em.getTransaction().commit();
////        } finally {
////            if (em.getTransaction().isActive()) {
////                em.getTransaction().rollback();
////                fail("Transaction rollback");
////            }
////        }
////
////        client = clientDAO.findById(client.getUserId());
////        assertNotNull("Client not found", client);
////        assertNotNull("User is null", client.getBasicUser());
////    }
////
////    @Test
////    public void deleteById_ExistingClient_Deleted() {
////        try {
////            em.getTransaction().begin();
////            clientDAO.deleteById(NO_CLIENT_USER_ID);
////            em.getTransaction().commit();
////        } finally {
////            if (em.getTransaction().isActive()) {
////                em.getTransaction().rollback();
////                fail("Transaction rollback");
////            }
////        }
////        
////        assertNull(clientDAO.findById(NO_CLIENT_USER_ID));
////    }
//}
