

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;


/**
 * The test class ProjectTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProjectTest
{
    private Project project;
    
    @Before
    public void setUp(){
        project = new Project("sample");
    }
    
    /**
     * US 0
     */
    @Test
    public void createAnEmptyProject(){
        assertTrue(project instanceof Project);
        assertEquals("sample", project.getName());
    }
    
     /**
     * US 1
     */
    @Test
    public void calculateTimeToDeliverOfASingleTask(){
        Task singleTask = new Task();
        singleTask.setTimeToComplete(5);
        project.addTask(singleTask);
        
        assertEquals(5, project.calculateTimeToDelivery());
    }
    
    /**
     * US 1
     */
    @Test
    public void calculateTimeToDeliveryOfATwoNonDependentTask(){
        Task singleTask1 = new Task("t1", 5);
        Task singleTask2 = new Task("t2", 3);
        project.addTask(singleTask1);
        project.addTask(singleTask2);   
                
        assertEquals(5, project.calculateTimeToDelivery());
    }

     /**
     * US 1
     */
    @Test
    public void calculateTimeToDeliveryOfATwoDependentTask(){
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 3);
        secondTask.dependsOn(firstTask);
        project.addTask(firstTask);
        project.addTask(secondTask);   
                
        assertEquals(8, project.calculateTimeToDelivery());
    }
    
     /**
     * US 1
     */
    @Test
    public void calculateTimeToDeliveryOneTaskDependendsOnOtherTwo(){
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 4);
        Task thirdTask = new Task("t3", 3);
        
        thirdTask.dependsOn(firstTask);
        thirdTask.dependsOn(secondTask);        
        
        project.addTask(firstTask);
        project.addTask(secondTask);   
        project.addTask(thirdTask);
                
        assertEquals(8, project.calculateTimeToDelivery());
    }
    
    /**
     * US 1, US5
     */
    @Test
    public void calculateTimeToCompelteForADiamondShapedDependency(){
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 2);
        Task thirdTask = new Task("t3", 6);
        Task forthTask = new Task("t4", 1);
        
        secondTask.dependsOn(firstTask);
        thirdTask.dependsOn(firstTask);
        forthTask.dependsOn(secondTask);
        forthTask.dependsOn(thirdTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);   
        project.addTask(thirdTask);
        project.addTask(forthTask);
                
        assertEquals(12, project.calculateTimeToDelivery());
    }
    
    /**
     * US 1, US5
     */
    @Test
    public void calculateTimeToCompelteForACP(){
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 2);
        Task thirdTask = new Task("t3", 6);
        Task forthTask = new Task("t4", 1);
        Task zeroTask = new Task("t0", 10);
        Task fifthTask = new Task("t5", 35);
        
        firstTask.dependsOn(zeroTask);
        secondTask.dependsOn(firstTask);
        thirdTask.dependsOn(firstTask);
        forthTask.dependsOn(secondTask);
        forthTask.dependsOn(thirdTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);   
        project.addTask(thirdTask);
        project.addTask(forthTask);
        project.addTask(zeroTask);
        project.addTask(fifthTask);
                
        assertEquals(35, project.calculateTimeToDelivery());
    }
    
    //US3
    @Test
    public void modifyTaskTimeToCompleteShouldChangeTheProjectTimeToDelivery(){
        Task firstTask = new Task("t1", 5);
        Task secondTask = new Task("t2", 2);
        Task thirdTask = new Task("t3", 6);
        Task forthTask = new Task("t4", 1);
        
        secondTask.dependsOn(firstTask);
        thirdTask.dependsOn(firstTask);
        forthTask.dependsOn(secondTask);
        forthTask.dependsOn(thirdTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);   
        project.addTask(thirdTask);
        project.addTask(forthTask);
                
        assertEquals(12, project.calculateTimeToDelivery());
        
        secondTask.setTimeToComplete(10);
        
        assertEquals(16, project.calculateTimeToDelivery());
    }
    
    @Test
    public void projectCannotHaveDuplicateTasks(){
        Task firstTask = new Task("t1", 5);
        
        project.addTask(firstTask);
        project.addTask(firstTask);
        
        assertEquals(1, project.countTasks());
    }
    
    @Test
    public void projectWith7TasksReturn15(){
        Task firstTask = new Task("t1", 1);
        Task secondTask = new Task("t2", 5);
        Task thirdTask = new Task("t3", 3);
        Task forthTask = new Task("t4", 2);
        Task fifthTask = new Task("t2", 3);
        Task sixthTask = new Task("t3", 4);
        Task seventhTask = new Task("t4", 3);
        
        secondTask.dependsOn(firstTask);
        forthTask.dependsOn(secondTask);
        thirdTask.dependsOn(firstTask);
        fifthTask.dependsOn(thirdTask);
        sixthTask.dependsOn(forthTask);
        sixthTask.dependsOn(fifthTask);
        seventhTask.dependsOn(sixthTask);
        
        project.addTask(firstTask);
        project.addTask(secondTask);
        project.addTask(thirdTask);
        project.addTask(forthTask);
        project.addTask(fifthTask);
        project.addTask(sixthTask);
        project.addTask(seventhTask);
        
        assertEquals(15, project.calculateTimeToDelivery());
        
        //List<Task> criticalPath = project.calculateCriticalPath();
        //assertEquals(5, criticalPath.size());
        
    }
    
    @Test
    public void criticalPathListOfAProjectWithOneTaskHasOnlyOneElement(){
        
        Task t1 = new Task("t1", 1);
        project.addTask(t1);
        
        List<Task> Expected = project.calculateCriticalPath();
        
        List<Task> criticalPath = project.calculateCriticalPath();
        assertEquals(1, criticalPath.size());
    }
}
