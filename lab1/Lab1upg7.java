package lab1;
import java.util.Scanner;


public class Lab1upg7 {

  public static void main(String[] args){

    //pris
    System.out.print("Ange pris (0-10): ");
    Scanner input1 = new Scanner(System.in);
    int pris = input1.nextInt();

    /*betalat
    System.out.print("Ange vad du betalar: ");
    Scanner input2 = new Scanner(System.in);
    int betalat = input2.nextInt();
    */

    // Växel
    int v5 = (10-pris)/5;
    int v1 = (10-pris-v5*5)/1;

    System.out.println("Du får " + v5 + " femkronor");
    System.out.println("Du får " + v1 + " enkronor");





  }
}
