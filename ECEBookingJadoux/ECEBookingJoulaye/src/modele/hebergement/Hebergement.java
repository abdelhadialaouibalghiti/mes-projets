package modele.hebergement;
public class Hebergement {
    private int hebergId;
    private String mail;
    private String photo1;
    private String photo2;
    private String titre;
    private String categorie;
    private String lieu;
    private float note;
    private float prix;
    private int capacite;
    private int nbChambres;
    private boolean piscine;
    private boolean terrasse;

    public void setHebergId(int hebergId) {
        this.hebergId = hebergId;
    }
    public int getHebergId() {
        return hebergId;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getMail() {
        return mail;
    }
    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }
    public String getPhoto1() {
        return photo1;
    }
    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }
    public String getPhoto2() {
        return photo2;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getTitre() {
        return titre;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public String getLieu() {
        return lieu;
    }
    public void setNote(float note) {
        this.note = note;
    }
    public float getNote() {
        return note;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public float getPrix() {
        return prix;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setNbChambres(int nbChambres) {
        this.nbChambres = nbChambres;
    }
    public int getNbChambres() {
        return nbChambres;
    }
    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }
    public boolean isPiscine() {
        return piscine;
    }
    public void setTerrasse(boolean terrasse) {
        this.terrasse = terrasse;
    }
    public boolean isTerrasse() {
        return terrasse;
    }
}
