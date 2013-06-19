// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.sdust.vcard_manager;

import edu.sdust.vcard_manager.Circle;
import edu.sdust.vcard_manager.CircleDataOnDemand;
import edu.sdust.vcard_manager.CircleIntegrationTest;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CircleIntegrationTest_Roo_IntegrationTest {
    
    declare @type: CircleIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: CircleIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    declare @type: CircleIntegrationTest: @Transactional;
    
    @Autowired
    CircleDataOnDemand CircleIntegrationTest.dod;
    
    @Test
    public void CircleIntegrationTest.testCountCircles() {
        Assert.assertNotNull("Data on demand for 'Circle' failed to initialize correctly", dod.getRandomCircle());
        long count = Circle.countCircles();
        Assert.assertTrue("Counter for 'Circle' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void CircleIntegrationTest.testFindCircle() {
        Circle obj = dod.getRandomCircle();
        Assert.assertNotNull("Data on demand for 'Circle' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Circle' failed to provide an identifier", id);
        obj = Circle.findCircle(id);
        Assert.assertNotNull("Find method for 'Circle' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Circle' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void CircleIntegrationTest.testFindAllCircles() {
        Assert.assertNotNull("Data on demand for 'Circle' failed to initialize correctly", dod.getRandomCircle());
        long count = Circle.countCircles();
        Assert.assertTrue("Too expensive to perform a find all test for 'Circle', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Circle> result = Circle.findAllCircles();
        Assert.assertNotNull("Find all method for 'Circle' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Circle' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void CircleIntegrationTest.testFindCircleEntries() {
        Assert.assertNotNull("Data on demand for 'Circle' failed to initialize correctly", dod.getRandomCircle());
        long count = Circle.countCircles();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Circle> result = Circle.findCircleEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Circle' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Circle' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void CircleIntegrationTest.testFlush() {
        Circle obj = dod.getRandomCircle();
        Assert.assertNotNull("Data on demand for 'Circle' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Circle' failed to provide an identifier", id);
        obj = Circle.findCircle(id);
        Assert.assertNotNull("Find method for 'Circle' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyCircle(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Circle' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void CircleIntegrationTest.testMergeUpdate() {
        Circle obj = dod.getRandomCircle();
        Assert.assertNotNull("Data on demand for 'Circle' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Circle' failed to provide an identifier", id);
        obj = Circle.findCircle(id);
        boolean modified =  dod.modifyCircle(obj);
        Integer currentVersion = obj.getVersion();
        Circle merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Circle' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void CircleIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Circle' failed to initialize correctly", dod.getRandomCircle());
        Circle obj = dod.getNewTransientCircle(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Circle' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Circle' identifier to be null", obj.getId());
        try {
            obj.persist();
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        obj.flush();
        Assert.assertNotNull("Expected 'Circle' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void CircleIntegrationTest.testRemove() {
        Circle obj = dod.getRandomCircle();
        Assert.assertNotNull("Data on demand for 'Circle' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Circle' failed to provide an identifier", id);
        obj = Circle.findCircle(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Circle' with identifier '" + id + "'", Circle.findCircle(id));
    }
    
}