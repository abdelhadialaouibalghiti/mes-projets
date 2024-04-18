package modele.resultats;

import modele.hebergement.Hebergement;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ResultatsDao {
    public ArrayList<Hebergement> resultats(String localisation) throws SQLException, ClassNotFoundException;

    public ArrayList<String> avis(Hebergement x) throws SQLException, ClassNotFoundException;
}
