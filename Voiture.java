public class Voiture {
  private String marque;
  private String moteur;
  private String numSerie;
  private String couleur;
  private String idVoiture;

  public Voiture() {}
  public Voiture(String marque, String moteur, String numSerie, String couleur, String idVoiture) {
    this.marque = marque;
    this.moteur = moteur;
    this.numSerie = numSerie;
    this.couleur = couleur;
    this.idVoiture = idVoiture;
  }

  // getters
  public String getMarque() {return this.marque;}
  public String getMoteur() {return this.moteur;}
  public String getNumSerie() {return this.numSerie;}
  public String getCouleur() {return this.couleur;}
  public String getIdVoiture() {return this.idVoiture;}

  // setters

  public void setMarque(String marque) {this.marque = marque;}
  public void setMoteur(String moteur) {this.moteur = moteur;}
  public void setNumSerie(String numSerie) {this.numSerie = numSerie;}
  public void setCouleur(String couleur) {this.couleur = couleur;}
  public void setIdVoiture(String idVoiture) {this.idVoiture = idVoiture;}

  @Override
  public String toString() {
    return "------------Voiture:------------\nidentifiant: "+this.idVoiture+"\nMarque: "+this.marque+"\nNuméro de série : "+this.numSerie+"\nCouleur : "+this.couleur;
  }
}
