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
        Voiture v = this.stock.Retirer();
        int nombreAleatoire = 0 + (int)(Math.random() * ((3 - 0) + 1));
        v.setMarque(this.marqueVoiture[nombreAleatoire]);
        v.setMoteur("m-"+i);
        v.setNumSerie("44CDE");
        v.setCouleur(this.Couleur[nombreAleatoire]);
        System.out.println("Le moteur a bien été monté !");
        System.out.println("VOITURE : "+v.getMarque()+" - Numéro de série : "+v.getNumSerie()+"\n");
        Enregistrer(v);
        sleep(this.tempsMontageMoteur);
        i++;
      }
      
    } catch (Exception e) {
      //TODO: handle exception
    }
  }

   // methode pour l'enregistrement
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
  public static String randomNumIdentification() {
    int leftLimit = 48; // numeral '0'
    int rightLimit = 122; // letter 'z'
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
