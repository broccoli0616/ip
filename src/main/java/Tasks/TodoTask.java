package Tasks;

public class TodoTask extends Task {
    private String description;
    public TodoTask(String description){
        String test = description;
        if(description == null || test.trim().isEmpty()){ //trim() removes white space
            throw new IllegalArgumentException("Please enter the name of the task!");
        }
        this.description = description;
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
