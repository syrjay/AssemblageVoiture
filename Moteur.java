import java.io.*;
import java.util.Random;

public class Moteur extends Thread {

  private int tempsMontageMoteur = 2500;
  private Stock stock = new Stock();
  private String [] marqueVoiture = {"BMW", "Audi", "Mercedes", "Peugeot"};
  private String [] Couleur = {"Noir", "Blanc", "Gris", "Rouge"};

  public Moteur() {}
  public Moteur(int tempsMontageMoteur, Stock stock) {
    this.tempsMontageMoteur = tempsMontageMoteur;
    this.stock = stock;
  }

  public void run() {
    try {
        int i = 0;
      while (i<500) {
        Voiture v = this.stock.Retirer(); // récupération d'une voiture depuis le stock
        int nombreAleatoire = 0 + (int)(Math.random() * ((3 - 0) + 1)); // attribution de couleur et de marque de façon aléatoire
        v.setMarque(this.marqueVoiture[nombreAleatoire]);
        v.setMoteur("m-"+i); // attribution du moteur
        v.setNumSerie("44CDE");
        v.setCouleur(this.Couleur[nombreAleatoire]);
        System.out.println("Le moteur a bien été monté !");
        System.out.println("VOITURE : "+v.getMarque()+" - Numéro de série : "+v.getNumSerie()+"\n");
        Enregistrer(v); // enregistrement dans un fichier File_auto.txt
        sleep(this.tempsMontageMoteur);
        i++;
      }
      
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

   // methode pour l'enregistrement dans un fichier
   public static void Enregistrer(Voiture v) throws IOException {
    File fichier = new File("File_auto.txt");
    FileWriter fw = new FileWriter(fichier, true);
    BufferedWriter bw = new BufferedWriter(fw);

    String id = randomNumIdentification();
    String donneesVoiture = "id : "+id+" - Couleur : "+v.getCouleur();
    bw.write(donneesVoiture);
    bw.newLine();
    bw.close();
  }

  // génération d'identifiant aléatoire pour les voitures
  public static String randomNumIdentification() {
    int leftLimit = 48; // ascii numéro 0 '0'
    int rightLimit = 122; // ascii lettre 'z'
    int targetStringLength = 10;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
      .limit(targetStringLength)
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString();

    return generatedString;
  }
}
