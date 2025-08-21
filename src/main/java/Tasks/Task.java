package Tasks;

public class Task {
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task() {
    }

    public boolean getDone() {
        return isDone;
    }
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
            throw new RuntimeException("OOPS! Please enter a correct task start with proper task type(todo/deadline/event)");
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
//        Tasks.Tasks.Task task = new Tasks.Tasks.Task("do homework");
//        System.out.println(task.toString());
//    }
}
