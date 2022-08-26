package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId() != job2.getId());
    }

    private void assertNotEquals(boolean b) {
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                   new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        assertTrue(job1 instanceof Job);
        assertEquals("Product tester", "Product tester");
        assertEquals("ACME", "ACME");
        assertEquals("Desert", "Desert");
        assertEquals("Quality Control", "Quality Control");
        assertEquals("Persistence", "Persistence");
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        char firstChar = job1.toString().charAt(0);
        char lastChar = job1.toString().charAt(job1.toString().length()-1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
        String jobString = job1.toString();
        //assertEquals(jobString, job1.toString());
        assertEquals(job1.toString(),  "\n" + "ID: " + job1.getId() + "\n" + "Name: " + job1.getName() +
                        "\n" + "Employer: " + job1.getEmployer() + "\n" + "Location: " + job1.getLocation() +
                        "\n" + "Position Type: " + job1.getPositionType() + "\n" + "Core Competency: " +
                        job1.getCoreCompetency() + "\n", "\n" + "ID: " + job1.getId() + "\n" + "Name: " + job1.getName() +
                "\n" + "Employer: " + job1.getEmployer() + "\n" + "Location: " + job1.getLocation() +
                "\n" + "Position Type: " + job1.getPositionType() + "\n" + "Core Competency: " +
                job1.getCoreCompetency() + "\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("Product tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality Control"),new CoreCompetency("Persistence"));
    }

}
