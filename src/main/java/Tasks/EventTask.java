package Tasks;

public class EventTask extends Task {
   private String startTime;
   private String endTime;
   private String description;


public EventTask(String description) {
    String test = description;
    if(test == null|| description.trim().isEmpty()){
        throw new IllegalArgumentException("Please enter the name of the task!");
    }
    if(!description.contains("/from")){
        throw new IllegalArgumentException("Please enter the starting time!");
    }
      String[] information = description.split("/from");
      String taskDescription = information[0];
      this.description = taskDescription;
    if(!description.contains("/to")){
        throw new IllegalArgumentException("Please enter the ending time!");
    }
      String[] timing = information[1].split("/to ");
      this.startTime = timing[0];
      this.endTime = timing[1];
    }
 @Override
 public String toString(){
     return "[E] " + getStatusIcon() + this.description + "(from: " + startTime + "to: " + endTime+")";
 }

    public static void main(String[] args){
    Task test = new EventTask("meeting /from Mon 2pm /to 4pm");
    System.out.println(test.toString());
    }

}
