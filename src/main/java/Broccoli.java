public class Broccoli {
    public static void main(String[] args) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        System.out.println("Hello from\n" + logo);
        char line = '-';
        int count = 60;
        StringBuilder horizontalLine = new StringBuilder();
        while(count >= 0) {
            horizontalLine.append(line);
            count --;
        }
        System.out.println(horizontalLine.toString());
        System.out.println("Hello! I'm Broccoli\n" + "What can I do for you?\n" + horizontalLine.toString());
        System.out.println("Bye.Hope to see you again soon!\n" + horizontalLine.toString());
    }
}
