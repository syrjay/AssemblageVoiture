import java.util.Scanner;
import java.io.*;

public class Assemblage {
  public static void main(String args[]) throws IOException {
    Stock stock = new Stock();
    Carrosserie carrosserie = new Carrosserie(1800, stock);
    Moteur ekipMoteur = new Moteur(2500, stock);
    // Peinture peinture = new Peinture(3000, stock);

    System.out.println("\n\t\t-------------------MENU--------------------\n");
      int choix;
    do {
      System.out.println("Appuyer sur '1' Lancer la production de voiture \n");
      System.out.println("Appuyer sur '2' pour afficher les infomations des voitures \n");
      System.out.println("Appuyer sur '3' pour quitter \n");
      Scanner sc = new Scanner(System.in);
      choix = sc.nextInt();

      if (choix == 1) {
        carrosserie.start();
        ekipMoteur.start();
        // peinture.start();
      } else if (choix == 2) {
        File f = new File("File_auto.txt");
        if(f.exists())
          Afficher("File_auto.txt");
        else {
          System.out.println("Le fichier n'est pas encore créer\n");
        }
      } 
      else {
        System.out.println("Vous avez quitté l'usine\n");
      }
    } while (choix!=3);
      
  }

  // afficher le contenu du fichier
  public static void Afficher(String f) throws IOException {
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    String line;
    while ((line= br.readLine()) != null) {
      System.out.println(line);
    }
    System.out.println("");
    br.close();
  }

}
