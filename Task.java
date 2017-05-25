import java.util.Vector;
/**
 * Write a description of class Task here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Task
{
    private String name;
    private String description;
    private String owner;
    private int timeToComplete;
    private Vector<Task> preRequisites;
    
    public Task(){
        name = "";
        description = "";
        owner = "";
        timeToComplete = 0;
        preRequisites = new Vector<Task>();
    }
    
    public Task(String name, int timeToComplete){
        this.name = name;
        description = "";
        owner = "";
        this.timeToComplete = timeToComplete;
        preRequisites = new Vector<Task>();
    }
    
    public String getName(){
       return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getDescription(){
       return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getOwner(){
       return owner;
    }
    
    public void setOwner(String owner){
        this.owner = owner;
    }
    
    public int getTimeToComplete(){
       return timeToComplete;
    }
    
    public void setTimeToComplete(int timeToComplete){
        this.timeToComplete = timeToComplete;
    }
    
    public void dependsOn(Task otherTask){
        preRequisites.add(otherTask);
    }
    
    public int calculateTimeToComplete(){
        int maxPreRequisiteTime = 0;
        for(Task preReq: preRequisites){
            if(preReq.calculateTimeToComplete() > maxPreRequisiteTime){
                maxPreRequisiteTime = preReq.calculateTimeToComplete();
            }
        }        
        return getTimeToComplete() + maxPreRequisiteTime;
    }
    /*
    @Override
    public boolean equals(Object otherObject){
        Task otherTask = (Task) otherObject;
        
        return name.equals(otherTask.name) && timeToComplete == otherTask.timeToComplete;
    }
    */
}
