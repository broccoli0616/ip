package Broccoli;

import Broccoli.Tasks.Task;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
  TaskList  taskList = new TaskList(new ArrayList<Task>());
  Storage storage = new Storage(taskList, "./data/broccoli.txt");
  Ui userInterface = new Ui();
  private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOutput = System.out;
    @Test
    public void isEcho_withByeCommand_success(){
        System.setOut(new PrintStream(outputStream));
        Scanner testScanner = new Scanner("bye\n");
        Parser testParser = new Parser(storage, userInterface, testScanner );
        testParser.echo("bye", taskList);
        System.setOut(originalOutput);
        String output = outputStream.toString();
       // System.out.println("captured:" + output);
        assertTrue(output.contains("Bye! Wish you come back with tasks done!"));

    }
}
