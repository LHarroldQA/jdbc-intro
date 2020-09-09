package com.qa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.main.DatabaseConnector;


public class DatabaseConnectorTest {
    @BeforeClass
    public static void setup() {
        System.out.println("Before class");
    }
    @Before
    public void init() {
        System.out.println("Before test");
    }
    @Test
    public void test1() {
        System.out.println("Test 1");
    }
    @Test
    public void test2() {
        System.out.println("Test 2");
    }
    @After
    public void finalise() {
        System.out.println("After test");
    }
    @AfterClass
    public static void teardown() {
        System.out.println("After class");
    }
}
