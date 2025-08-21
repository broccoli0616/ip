package Tasks;

public class DeadlineTask extends Task{
        private String dueTime;

        public DeadlineTask(String description) {
            String[] information = description.split("/by ");
            String taskDescription = information[0];
            super(taskDescription);
            this.dueTime = information[1];
        }
        @Override
        public String toString(){
            return "[D] " + getStatusIcon() + this.description + "(by: " + dueTime+")";
        }

        public static void main(String[] args){
            Task test = new Tasks.DeadlineTask("return book /by Sunday");
            System.out.println(test.toString());
        }

    }

