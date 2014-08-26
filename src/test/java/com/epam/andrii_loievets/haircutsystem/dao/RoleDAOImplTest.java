///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.epam.andrii_loievets.haircutsystem.dao;
//
//import static com.epam.andrii_loievets.haircutsystem.dao.DAOTest.em;
//import com.epam.andrii_loievets.haircutsystem.entity.Role;
//import java.util.List;
//import javax.persistence.Persistence;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Andrii_Loievets
// */
//public class RoleDAOImplTest extends DAOTest {
//
//    protected static RoleDAOImpl roleDAO;
//    protected static final int USER_ID = 1;
//
//    @BeforeClass
//    public static void setUpClass() {
//        emf = Persistence.createEntityManagerFactory(UNIT_NAME);
//        em = emf.createEntityManager();
//        
//        roleDAO = new RoleDAOImpl();
//        roleDAO.setEm(em);
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//        em.close();
//        emf.close();
//    }
//
//    /**
//     * Test of findRolesByUserId method, of class RoleDAOImpl.
//     */
//    @Test
//    public void findRolesByUserId_ValidId_NotEmptyList() {
//        List<Role> roles = roleDAO.findRolesByUserId(USER_ID);
//
//        assertNotNull(roles);
//        assertFalse(roles.isEmpty());
//    }
//}