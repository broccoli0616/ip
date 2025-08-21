package Tasks;

public class TodoTask extends Task {
    public TodoTask(String description){
        super(description);
    }

    @Override
    public String toString(){
        return "[T] " + super.toString();
    }
    public static void main(String[] args){
        Task test = new TodoTask("borrow book");
        System.out.println(test.toString());
    }
}
