///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.epam.andrii_loievets.haircutsystem.dao;
//
//import static com.epam.andrii_loievets.haircutsystem.dao.DAOTest.em;
//import com.epam.andrii_loievets.haircutsystem.entity.BasicUser;
//import com.epam.andrii_loievets.haircutsystem.entity.Role;
//import com.epam.andrii_loievets.haircutsystem.entity.RoleEnum;
//import java.util.List;
//import javax.persistence.Persistence;
//import org.junit.AfterClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.BeforeClass;
//
///**
// *
// * @author Andrii_Loievets
// */
//public class BasicUserDAOImplTest extends DAOTest {
//
//    protected static BasicUserDAOImpl userDAO;
//    protected static final String EXISTING_USER_LOGIN = "admin";
//    protected static final int EXISTING_USER_ID = 1;
//    protected static final String NEW_USER_LOGIN = "testuser";
//    protected static final String NEW_USER_PASSWORD = "123";
//    private int newUserId;
//    
//    @BeforeClass
//    public static void setUpClass() {
//        emf = Persistence.createEntityManagerFactory(UNIT_NAME);
//        em = emf.createEntityManager();
//        
//        userDAO = new BasicUserDAOImpl();
//        userDAO.setEm(em);
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//        em.close();
//        emf.close();
//    }
//
//    /**
//     * Test of findById method, of class BasicUserDAOImpl.
//     */
//    @Test
//    public void findById_ValidId_ValidUser() {     
//        BasicUser user = userDAO.findById(EXISTING_USER_ID);
//        assertNotNull(user);
//    }
//
//    /**
//     * Test of findById method, of class BasicUserDAOImpl.
//     */
//    @Test
//    public void findById_InvalidId_Null() {
//        BasicUser user = userDAO.findById(-EXISTING_USER_ID);
//        assertNull(user);
//    }
//
//    /**
//     * Test of findByLogin method, of class BasicUserDAOImpl.
//     */
//    @Test
//    public void findByLogin_ValidParams_ValidUser() {
//        BasicUser user = userDAO.findByLogin(EXISTING_USER_LOGIN);
//        assertNotNull(user);
//    }
//
//    /**
//     * Test of findByLogin method, of class BasicUserDAOImpl.
//     */
//    @Test
//    public void findByLogin_InvalidParams_Null() {
//        BasicUser user = userDAO.findByLogin(EXISTING_USER_LOGIN + "1");
//        assertNull(user);
//    }
//
//    @Test
//    public void findById_ValidId_RolesNotEmpty() {
//        BasicUser user = userDAO.findById(EXISTING_USER_ID);
//        List<Role> roles = user.getRoles();
//        assertNotNull(roles);
//        assertFalse(roles.isEmpty());
//    }
//
//    @Test
//    public void findAll_NotEmptyList() {
//        List<BasicUser> users = userDAO.findAll();
//        assertNotNull(users);
//        assertFalse(users.isEmpty());
//    }
//
////    @Test
////    public void createUser_NoRoles_Persisted() {
////        BasicUser user = new BasicUser();
////        user.setLogin(NEW_USER_LOGIN);
////        user.setPassword(NEW_USER_PASSWORD);
////        
////        try {
////            em.getTransaction().begin();
////            userDAO.insert(user);
////            em.getTransaction().commit();
////        } finally {
////            if (em.getTransaction().isActive()){
////                em.getTransaction().rollback();
////            }
////        }
////        
////        user = userDAO.findByLogin(NEW_USER_LOGIN);
////        assertNotNull(user);
////        newUserId = user.getUserId();
////    }
//    
////    @Test
////    public void addRole_NewRole_Persisted() {
////        BasicUser user = userDAO.findByLogin(NEW_USER_LOGIN);
////        
////        try {
////            em.getTransaction().begin();
////            user.addRole(RoleEnum.CLIENT);
////            em.getTransaction().commit();
////        } finally {
////            if (em.getTransaction().isActive()){
////                em.getTransaction().rollback();
////                fail("Transaction rollback");
////            }
////        }
////        
////        RoleDAOImpl roleDAO = new RoleDAOImpl();
////        roleDAO.setEm(em);
////        
////        List<Role> userRoles = roleDAO.findRolesByUserId(user.getUserId());
////        
////        assertNotNull("Roles is null", userRoles);
////        assertFalse("Roles is empty", userRoles.isEmpty());
////        assertEquals("Wrong role", "CLIENT", userRoles.get(0).getRolePK().getUserRole().toString());
////    }
////    
////    @Test
////    public void deleteById_ExistingUser_DeletedWithRoles() {
////        try {
////            em.getTransaction().begin();
////            userDAO.deleteById(newUserId);
////            em.getTransaction().commit();
////        } finally {
////            if (em.getTransaction().isActive()) {
////                em.getTransaction().rollback();
////                fail("Transaction rollback");
////            }
////        }
////        
////        RoleDAOImpl roleDAO = new RoleDAOImpl();
////        roleDAO.setEm(em);
////       
////        List<Role> userRoles = roleDAO.findRolesByUserId(newUserId);
////        
////        assertTrue("Roles not deleted", userRoles.isEmpty());
////    }
//}