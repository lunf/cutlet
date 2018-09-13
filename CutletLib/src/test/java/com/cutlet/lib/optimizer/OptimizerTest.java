/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cutlet.lib.optimizer;

import com.cutlet.lib.errors.EmptyProjectException;
import com.cutlet.lib.errors.OptimizationFailedException;
import com.cutlet.lib.model.Panel;
import com.cutlet.lib.model.Project;
import com.cutlet.lib.testing.Data1;
import com.cutlet.lib.testing.DataRegal;
import lombok.NonNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author rmuehlba
 */
public class OptimizerTest {
    
    public OptimizerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of optimize method, of class Optimizer.
     */
    @org.junit.Test
    public void testOptimize() throws EmptyProjectException, OptimizationFailedException {
        System.out.println("optimize");
        //Project project = (new DataRegal()).getData();
        Project project = (new Data1()).getData();

        long start = System.currentTimeMillis();
        OptimizationStrategy strategy = new GAOptimizationStrategy();
        Optimizer instance = new Optimizer();
        OptimizationResult result = instance.optimize(project, strategy);
        //("The test case is a prototype.");

        System.out.println("Complete with " + String.format("%d in millis seconds", (System.currentTimeMillis() - start)));
    }
    
}
