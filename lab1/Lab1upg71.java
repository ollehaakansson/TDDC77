package lab1;

import java.util.Scanner;

public class Lab1upg71 {

  public static void main(String[] args){

    //pris
    System.out.print("Ange pris (0-500): ");
    Scanner input1 = new Scanner(System.in);
    int pris = input1.nextInt();

    //betalat
    /* System.out.print("Ange vad du betalar: ");
    Scanner input2 = new Scanner(System.in);
    int betalat = input2.nextInt();
*/
    int betalat = 500;

    // Växel
    int v100 = (betalat - pris)/100;
    int v50 = (betalat - pris - (v100*100))/50;
    int v20 = (betalat - pris - (v100*100) - (v50*50))/20;
    int v10 = (betalat - pris - (v100*100) - (v50*50) - (v20*20))/10;
    int v5 = (betalat - pris - (v100*100) - (v50*50) - (v20*20) - (v10*10))/5;
    int v1 = (betalat - pris - (v100*100) - (v50*50) - (v20*20) - (v10*10) - (v5*5));

    System.out.println("Du får " + v100 + " hundralappar");
    System.out.println("Du får " + v50 + " femtiolappar");
    System.out.println("Du får " + v20 + " tjugolappar");
    System.out.println("Du får " + v10 + " tior");
    System.out.println("Du får " + v5 + " femkronor");
    System.out.println("Du får " + v1 + " enkronor");






  }
}
