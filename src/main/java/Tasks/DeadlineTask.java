package Tasks;

public class DeadlineTask extends Task{
        private String dueTime;
        private String description;

        public DeadlineTask(String description) {
            String test = description;
            if(description == null|| test.trim().isEmpty()){
                throw new IllegalArgumentException("Please enter the name of the task!");
            }
            if(!description.contains("/by")){
                throw new IllegalArgumentException("Please enter the deadline!");
            }
            String[] information = description.split("/by ");
            String taskDescription = information[0];
            this.description = taskDescription;
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

