/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.client;

/**
 *
 * @author maithili
 */
public class Client {
    private int clientId;
    private String Name;
    private String Mail;
    private String Password;
    private String NumTel;
    private String CarteBleue;
    private int NbVoyages;
    private int Age;
    
    public void setClientID(int eID){
        clientId=eID;
    }
    public int getClientId(){
        return clientId;
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
    public void setCarteBleue(String carteBleue) {
        CarteBleue = carteBleue;
    }
    public String getCarteBleue() {
        return CarteBleue;
    }
    public void setNbVoyages(int nbVoyages) {
        NbVoyages = nbVoyages;
    }
    public int getNbVoyages() {
        return NbVoyages;
    }
    public void setAge(int eAge){
        Age=eAge;
    }
    public int getAge(){
        return Age;
    }

}
