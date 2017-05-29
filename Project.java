import java.util.Vector;
import java.util.Set;
import java.util.HashSet;
/**
 * Write a description of class Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Project
{
    private String name;
    private Set<Task> tasks;
    
    public Project(){
        name = "";
        tasks = new HashSet<Task>();
    }
    
    public Project(String name){
        this.name = name;
        tasks = new HashSet<Task>();
    }
    
    public String getName(){
        return name;
    }
    
    public void addTask(Task task){
            tasks.add(task);
   }    
    
    public int calculateTimeToDelivery(){
        int maxTimeToComplete = 0;
        for(Task task: tasks){
            int time = task.calculateTimeToComplete();
            if(time > maxTimeToComplete){
                maxTimeToComplete = time;
            }
        }     
        return maxTimeToComplete;
    }
    
    public int countTasks(){
        return tasks.size();
    }
}
