

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaskTest.
 *
 * @author  Mauricio Z.
 * @version 0.1
 */
public class TaskTest
{
    
    /**
    * US 1
    */
    @Test
    public void createInstanceOfTask(){
        Task emptyTask = new Task();
        assertTrue(emptyTask instanceof Task);
        assertTrue(emptyTask instanceof Object);
    }
    
    /**
    * US 1
    */
    @Test
    public void createInstanceOfTaskWithNameAndTimeToComplete(){
        Task emptyTask = new Task("t1", 1);
        assertTrue(emptyTask instanceof Task);
        assertEquals("t1", emptyTask.getName());
        assertEquals(1, emptyTask.getTimeToComplete());
    }
    
    /**
    * US 1
    */
    @Test
    public void readDescriptionProperty(){
        Task emptyTask = new Task();
        assertEquals("", emptyTask.getDescription());
    }
    
    /**
    * US 1
    */
    @Test
    public void writeDescriptionProperty(){
        Task task = new Task();
        task.setDescription("this is a task");
        assertEquals("this is a task", task.getDescription());
    }
    
    /**
    * US 1
    */
    @Test
    public void readNameProperty(){
        Task emptyTask = new Task();
        assertEquals("", emptyTask.getName());
    }
    
    /**
    * US 1
    */
    @Test
    public void writeNameProperty(){
        Task task = new Task();
        task.setName("this is a task Name");
        assertEquals("this is a task Name", task.getName());
    }
    
    /**
    * US 1
    */
    @Test
    public void readOwnerProperty(){
        Task emptyTask = new Task();
        assertEquals("", emptyTask.getOwner());
    }
    
    /**
    * US 1
    */
    @Test
    public void writeOwnerProperty(){
        Task task = new Task();
        task.setOwner("this is a task Owner");
        assertEquals("this is a task Owner", task.getOwner());
    }
    
    /**
    * US 1
    */
    @Test
    public void readTimeToCompleteProperty(){
        Task emptyTask = new Task();
        assertEquals(0, emptyTask.getTimeToComplete());
    }
    
    /**
    * US 1
    */
    @Test
    public void writeTimeToCompleteProperty(){
        Task task = new Task();
        task.setTimeToComplete(5);
        assertEquals(5, task.getTimeToComplete());
    }
    
    @Test
    public void tasksAreEqualIfTheyHaveTheSameNameAndTimeToComplete(){
        Task task = new Task("t1", 5);
        Task expected = new Task("t1", 5);
        assertTrue(task.equals(expected));
    }
    
    @Test
    public void tasksAreDifferentIfTherHaveADifferentName(){
        Task task = new Task("t1", 5);
        Task expected = new Task("t2", 5);
        assertFalse(task.equals(expected));
    }
    
    @Test
    public void tasksAreDifferentIfTherHaveADifferentTimeToComplete(){
        Task task = new Task("t1", 5);
        Task expected = new Task("t1", 6);
        assertFalse(task.equals(expected));
    }
}
