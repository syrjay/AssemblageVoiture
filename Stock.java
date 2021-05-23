public class Stock {
  private Voiture[] stockage = new Voiture[500];
  private int nb_voiture_car = 0;
  private int nb_voiture_mot = 0;

  public Stock(){}

  public void Ajouter(Voiture v) {
    // add a car to stockage by the body team
    this.stockage[this.nb_voiture_car] = v;
    this.nb_voiture_car++;
  }

  public Voiture Retirer() {
    // return a car from stockage by the motor team
    Voiture v = this.stockage[this.nb_voiture_mot];
    this.nb_voiture_mot++;
    return v;

  }

  // getters
  public int Getter_nb_voiture_car() {
    return this.nb_voiture_car;
  }
  public int Getter_nb_voiture_mot() {
    return this.nb_voiture_mot;
  }
  public Voiture[] Getter_stockage() {
    return this.stockage;
  }

}