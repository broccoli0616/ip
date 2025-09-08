package Broccoli.Tasks;

/**
 * Represents a basic task with completion status and description.
 */
public class Task {
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task() {
    }

   public String getDescription(){
        return this.description;
   }

    public boolean getDone() {

        return isDone;
    }
    /**
     * Returns the formatted text representation for file storage.
     *
     * @return The task formatted as a string for storage.
     */
    public String taskText() {
        String isComplete = this.isDone ? "1" : "0";
        String taskText = "todo " + isComplete + " " + this.description;
        return taskText;
    }

    /**
     * Parses a task from stored text format and creates the appropriate task type.
     *
     * @param task The stored task string to parse.
     * @return The parsed Task object of the appropriate subtype.
     */
    public static Task parseTask(String task){
        if(task.startsWith("T")){
            String[] description = task.split(" \\| ");
            String taskDescription = description[2];
            boolean isDone = description[1].equals("0") ? false : true;
            Task taskToAdd = new TodoTask(taskDescription, isDone);
            return taskToAdd;
        } else if(task.startsWith("D")){
            String[] description = task.split(" \\| ");
            String taskDescription = description[2];
            boolean isDone =description[1].equals("0")? false : true;
            String deadlineTime = description[3];
            Task taskToAdd = new DeadlineTask(taskDescription,deadlineTime, isDone);
            return taskToAdd;
        } else if(task.startsWith("E")){
            String[] description = task.split(" \\| ");
            String taskDescription = description[2];
            boolean isDone =description[1].equals("0")? false : true;
            String eventTime = description[3];
            String[] eventTime2 = eventTime.split("to");
            Task taskToAdd = new EventTask(taskDescription, eventTime2[0], eventTime2[1],isDone);
            return taskToAdd;
        } else {
            throw new IllegalArgumentException("OOPS! Please enter a correct task start with proper task type(todo/deadline/event)");
        }
    }

/**
 * Creates a task from user input command and returns the appropriate task type.
 */
    public static Task checkTask(String task) {
        if(task.startsWith("todo")){
            String description = task.substring(4);
            Task todoTask = null;
            try{
           todoTask = new TodoTask(description);
            } catch (Exception e) {
              throw new IllegalArgumentException(e.getMessage());
            }
            return todoTask;
        } else if(task.startsWith("deadline")){
            String description = task.substring(8);
            Task deadlineTask = null;
            try{
                deadlineTask = new DeadlineTask(description);
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
            return deadlineTask;
        } else if(task.startsWith("event")){
            String description = task.substring(5);
            Task eventTask = null;
            try{
                eventTask = new EventTask(description);
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
            return eventTask;
        } else {
            throw new IllegalArgumentException("OOPS! Please enter a correct task start with proper task type(todo/deadline/event)");
        }
    }

    public String getStatusIcon() {
        return (isDone ? "[X] " : "[ ] "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }


    public String toString() {
        return getStatusIcon() + this.description;
    }
//    public static void main(String[] args){
//        Broccoli.Broccoli.Tasks.Broccoli.Broccoli.Tasks.Task task = new Broccoli.Broccoli.Tasks.Broccoli.Broccoli.Tasks.Task("do homework");
//        System.out.println(task.toString());
//    }
}
