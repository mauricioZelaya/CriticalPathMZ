import java.util.Vector;
/**
 * Write a description of class Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Project
{
    private String name;
    private Vector<Task> tasks;
    
    public Project(){
        name = "";
        tasks = new Vector<Task>();
    }
    
    public Project(String name){
        this.name = name;
        tasks = new Vector<Task>();
    }
    
    public String getName(){
        return name;
    }
    
    public void addTask(Task task){
        if(!tasks.contains(task)){
            tasks.add(task);
        }
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
