public class Carrosserie extends Thread {
  
  private final int productionMax = 5;
  private int nbVoiture = 0;
  private int tempsProduction = 1800; 
  private Stock stock = new Stock();


  // constructor
  public Carrosserie() {}
  public Carrosserie(int tempsProduction, Stock stock) {
    this.tempsProduction = tempsProduction;
    this.stock = stock;
  }
  
  // 
  public void run() {
    try {

      while (this.nbVoiture<500) {
        Voiture v = new Voiture();
        this.stock.Ajouter(v);
        System.out.println("une nouvelle voiture a été ajoutée !");
        sleep(this.tempsProduction);
        this.nbVoiture++;
        if(this.nbVoiture%this.productionMax==0 && this.stock.Getter_nb_voiture_car()!=500){
          System.out.println(this.nbVoiture +" voitures ont été produit");
        }
        if(this.nbVoiture == 500) {
          System.out.println("Production terminée");
        }
      }
    } catch (Exception e) {
      //TODO: handle exception
    }
  }
}
