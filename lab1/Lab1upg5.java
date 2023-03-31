package lab1;
import java.util.Scanner;

public class Lab1upg5 {

  public static void main(String[] args){

    //Första talet
    System.out.print("Mata in ett heltal: ");
    Scanner input1 = new Scanner(System.in);
    double x = input1.nextDouble();

    //Andra talet
    System.out.print("Mata in ett andra heltal: ");
    Scanner input2 = new Scanner(System.in);
    double y = input2.nextDouble();

    // uträkningen
    double plus,ganger,division,minus;
    plus = x+y;
    ganger = x*y;
    division = x/y;
    minus = x-y;

    System.out.println("Tackar!");
    System.out.println(x + " plus " + y + " blir: " + plus + "!");
    System.out.println(x + " minus " + y + " blir: " + minus + "!");
    System.out.println(x + " gånger " + y + " blir: " + ganger + "!");
    System.out.println(x + " dividerat på " + y + " blir: " + division + "!");

    }
}
