package modele.reservation;
import java.util.Date;

public class Reservation {
    private int reservId;
    private String mailClient;
    private String nomClient;
    private Date dateDebut;
    private Date dateFin;
    private int hebergId;
    private int clientId;

    public void setReservId(int reservId) {
        this.reservId = reservId;
    }
    public int getReservId() {
        return reservId;
    }
    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }
    public String getMailClient() {
        return mailClient;
    }
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
    public String getNomClient() {
        return nomClient;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public Date getDateDebut() {
        return dateDebut;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public Date getDateFin() {
        return dateFin;
    }
    public void setHebergId(int hebergId) {
        this.hebergId = hebergId;
    }
    public int getHebergId() {
        return hebergId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public int getClientId() {
        return clientId;
    }
}
