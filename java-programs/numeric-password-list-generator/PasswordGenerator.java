import java.io.*;
import java.util.Scanner;

public class PasswordGenerator
{
  public static void main(String [] args) throws IOException 
  {
    // Create a Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);
    
    //Introduction screen  
    System.out.println("Welcome to Password Generator 00000000-99999999");
    System.out.println("-----------------------------------------------------------------");
    System.out.print("Output file: ");
    String outputFileName = keyboard.nextLine();
    System.out.println("Results printed to: "+outputFileName);
    System.out.println("-----------------------------------------------------------------");

    //identifies where and how to save result
    PrintWriter output =  new PrintWriter(outputFileName);
   
    System.out.println("Enter Number to start from");
    int currentCount = keyboard.nextInt();
    int endingCount = 1000000;

    
    while (currentCount != endingCount){
      currentCount = currentCount + 1;
      String currentFormatted = String.format("%08d", currentCount);
      output.printf("%s\n",currentFormatted);
    }
    System.out.println("Done");
    
    
    //closes writer
    output.close();
  }
}