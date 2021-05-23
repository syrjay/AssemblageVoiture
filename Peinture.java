public class Peinture extends Thread {
  private int tempsPeinture = 1000;
  private Stock stock = new Stock();
  private String [] Couleur = {"Noir", "Blanc", "Gris", "Rouge"};

  public Peinture(int tempsPeinture, Stock stock) {
    this.tempsPeinture = tempsPeinture;
    this.stock = stock;
  }

  public void run() {
    try {
      int i = 0;
      while(i<500) {
        Voiture v = this.stock.Retirer();
        int nombreAleatoire = 0 + (int)(Math.random() * ((3 - 0) + 1));
        v.setCouleur(this.Couleur[nombreAleatoire]);
        System.out.println("La "+ v.getMarque()+"-"+v.getNumSerie()+ " a été peinturée en "+v.getCouleur());
        sleep(this.tempsPeinture);
        i++;
      }
    } catch (Exception e) {
      //TODO: handle exception
    }
  }
}
