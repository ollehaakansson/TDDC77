package lab1;
import java.util.Scanner;

public class Lab1upg4 {

  public static void main(String[] args){

    String age;

    System.out.print("Ange din ålder: ");
    Scanner in = new Scanner(System.in);
    age = in.nextLine();

      System.out.println("Tack! Du är " + age + " år gammal.");

    }
}
