package lab1;
import java.util.Scanner;

public class Lab1upg72 {

  public static void main(String[] args){

    //Deklarerar:
    boolean felPris = true;
    boolean felBetalat = true;
    double[] sedlar = {100,50,20,10,5,1,0.5};
    double[] antalSedlar = new double[7];

    //vad det kostar aka pris
    System.out.print("Ange pris: ");
    Scanner input1 = new Scanner(System.in);
    double pris = input1.nextDouble();

// ifall man försöker mata in ett negativt pris eller 0kr
while(felPris){
    if(pris <= 0 || pris <= -1){
      System.out.println("inget i livet är gratis");
      System.out.print("Ange pris: ");
      pris = input1.nextDouble();
    }else{
    felPris = false;
  }
    }

      // vad man betalar
      System.out.print("Ange vad du betalar: ");
      Scanner input2 = new Scanner(System.in);
      double betalat = input2.nextDouble();

// ifall man försöker betala för lite
while(felBetalat){
        if(pris>betalat){
          System.out.println("FÖR LITE PARRA!");
          System.out.print("Ange vad du betalar: ");
          betalat = input2.nextDouble();
        }else{
        felBetalat = false;
        }
      }
        double kvar = betalat - pris; // hur mycket växel man ska få tot

    //Räkna ut växeln i enskilda valörer
    for(int i = 0; i < 7; i++){
      antalSedlar[i] = (kvar-kvar%sedlar[i])/sedlar[i];
      kvar -= antalSedlar[i]*sedlar[i];
    }

    // utmatning
    System.out.println("Du får " + antalSedlar[0] + " hundralappar");
    System.out.println("Du får " + antalSedlar[1] + " femtiolappar");
    System.out.println("Du får " + antalSedlar[2] + " tjugolappar");
    System.out.println("Du får " + antalSedlar[3] + " tiokronor");
    System.out.println("Du får " + antalSedlar[4] + " femkronor");
    System.out.println("Du får " + antalSedlar[5] + " enkronor");
    System.out.println("Du får " + antalSedlar[6] + " femtioören");
  }
}
