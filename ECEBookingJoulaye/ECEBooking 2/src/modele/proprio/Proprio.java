package modele.proprio;

public class Proprio {
    private int propioId;
    private String Name;
    private String Mail;
    private String Password;
    private String NumTel;
    private int NbHeberg;
    private int Age;

    public int getPropioId() {
        return propioId;
    }
    public void setName(String eName){
        Name=eName;
    }
    public String getName(){
        return Name;
    }
    public void setMail(String mail) {
        Mail = mail;
    }
    public String getMail() {
        return Mail;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getPassword() {
        return Password;
    }
    public void setNumTel(String numTel) {
        NumTel = numTel;
    }
    public String getNumTel() {
        return NumTel;
    }
    public void setNbHeberg(int nbHeberg) {
        NbHeberg = nbHeberg;
    }
    public int getNbHeberg() {
        return NbHeberg;
    }
    public void setAge(int eAge){
        Age=eAge;
    }
    public int getAge(){
        return Age;
    }

}
