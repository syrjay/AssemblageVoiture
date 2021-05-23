import java.io.*;
public class test {
  public static void main(String[] args) throws IOException {

    // création et ecriture
    // File fichier = new File("File_auto.txt");
    /* FileWriter fw = new FileWriter(fichier, true);
    // fw.write("Hello\n");
    // fw.close();

    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("Hello fiss");
    bw.newLine();
    bw.close(); */

    // lecture

    // FileReader fr = new FileReader(fichier);
    // pour lire un caractère
    /* int str = fr.read();
    while ((str = fr.read()) != -1) {
      System.out.println((char) str);
    } */

    // pour lire ligne par ligne
    /* BufferedReader br = new BufferedReader(fr);
    String ligne;
    while((ligne=br.readLine()) != null)
      System.out.println(ligne); */
     
  String [] Couleur = {"Noir", "Blanc", "Gris", "Rouge"};
    System.out.println(Couleur[0]);
  }

}
