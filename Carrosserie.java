public class Carrosserie extends Thread {
  
  private final int productionMax = 20; // production maximum 
  private int nbVoiture = 0;
  private int tempsProduction = 1800; // durée de la production de voiture
  private Stock stock = new Stock();


  // constructor
  public Carrosserie() {}
  public Carrosserie(int tempsProduction, Stock stock) {
    this.tempsProduction = tempsProduction;
    this.stock = stock;
  }
  
  // méthode run du thread
  public void run() {
    try {

      while (this.nbVoiture<500) {
        Voiture v = new Voiture(); // creation d'une nouvelle voiture
        this.stock.Ajouter(v); // ajout dans le stock
        System.out.println("une nouvelle voiture a été ajoutée !");
        sleep(this.tempsProduction); // attente de la durée de prod
        this.nbVoiture++;
        if(this.nbVoiture%this.productionMax==0 && this.stock.Getter_nb_voiture_car()!=500){
          // affichage du nombre de voiture produit après chaque 20 productions
          System.out.println(this.nbVoiture +" voitures ont été produit");
        }
        if(this.nbVoiture == 500) {
          // fin production
          System.out.println("Production terminée");
        }
      }
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}
