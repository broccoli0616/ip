package Broccoli.Tasks;

public class TodoTask extends Task {
    private String description;
    public TodoTask(String description){
        String test = description;
        if(description == null || test.trim().isEmpty()){ //trim() removes white space
            throw new IllegalArgumentException("Please enter the name of the task!");
        }
        this.description = description;
    }

    public TodoTask(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    @Override
    public String taskText() {
        String isComplete = this.isDone ? "1" : "0";
        String taskText = "T" + " | " + isComplete + " | " + this.description;
        return taskText;
    }

    @Override
    public String toString(){
        return "[T] " + getStatusIcon() + description;
    }
    public static void main(String[] args){
        Task test = new TodoTask("borrow book");
        System.out.println(test.toString());
    }
}
