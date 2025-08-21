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
        if(task.startsWith("todo ")){
            String description = task.substring(5);
        Task todoTask = new TodoTask(description);
        return todoTask;
        } else if(task.startsWith("deadline ")){
            String description = task.substring(9);
            Task deadlineTask = new DeadlineTask(description);
            return deadlineTask;
        } else if(task.startsWith("event ")){
            String description = task.substring(6);
            Task eventTask = new EventTask(description);
            return eventTask;
        } else {
            throw new RuntimeException("OOPS! Please enter a correct task start with proper task type(todo/deadline/event");
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
