package modele.proprio;

public class Proprio {
    private int propioId;
    private String Name;
    private String Mail;
    private String Password;
    private String NumTel;
    private int NbHeberg;
    private int Age;

    //Setters
    public void setName(String eName){
        Name=eName;
    }
    public void setMail(String mail) {
        Mail = mail;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setNumTel(String numTel) {
        NumTel = numTel;
    }
    public void setNbHeberg(int nbHeberg) {
        NbHeberg = nbHeberg;
    }
    public void setAge(int eAge){
        Age=eAge;
    }

    //Getters
    public int getPropioId() {
        return propioId;
    }
    public String getName(){
        return Name;
    }
    public String getMail() {
        return Mail;
    }
    public String getPassword() {
        return Password;
    }
    public String getNumTel() {
        return NumTel;
    }
    public int getNbHeberg() {
        return NbHeberg;
    }
    public int getAge(){
        return Age;
    }
}
