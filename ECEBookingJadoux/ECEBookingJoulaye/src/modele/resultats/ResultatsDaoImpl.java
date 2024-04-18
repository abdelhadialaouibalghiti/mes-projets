package modele.resultats;

import modele.hebergement.Hebergement;

import java.sql.*;
import java.util.ArrayList;


public class ResultatsDaoImpl implements ResultatsDao{
    public ArrayList<Hebergement> resultats(String localisation) throws SQLException, ClassNotFoundException {
        ArrayList<Hebergement> maliste = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String nameDatabase = "ecebooking";
        String loginDatabase = "root";
        String passwordDatabase="";
        String urlDatabase = "jdbc:mysql://localhost/" + nameDatabase;
        // Requête SQL pour récupérer les appartements par localisation
        String requeteSQL = "SELECT * FROM hébergements WHERE Lieu = '" + localisation + "';";
        // Connexion à la base de données
        try (Connection conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
             // Préparation de la requête avec le paramètre de localisation recherchée
             Statement st = conn.createStatement()) {
            System.out.println("UI");

            // Exécution de la requête
            ResultSet resultSet = st.executeQuery(requeteSQL);

            // Parcours des résultats et affichage des appartements
            while (resultSet.next()) {
                Hebergement hebergement = new Hebergement();
                hebergement.setHebergId(resultSet.getInt("Id_H"));
                hebergement.setPhoto1(resultSet.getString("Photo1"));
                hebergement.setPhoto2(resultSet.getString("Photo2"));
                hebergement.setTitre(resultSet.getString("Titre"));
                hebergement.setCategorie(resultSet.getString("Categorie"));
                hebergement.setLieu(resultSet.getString("Lieu"));
                hebergement.setNote(resultSet.getInt("Note"));
                hebergement.setPrix(resultSet.getInt("Prix"));
                hebergement.setCapacite(resultSet.getInt("Capacite"));
                hebergement.setPiscine(resultSet.getBoolean("Piscine"));
                hebergement.setTerrasse(resultSet.getBoolean("Terrasse"));
                maliste.add(hebergement);
                System.out.println(hebergement.getTitre());
            }
            // Fermeture des ressources
            resultSet.close();
        } catch (SQLException e) {
//                System.out.println("Erreur : " + e.getMessage());
            e.printStackTrace();
        }
        return maliste;
    }
    public ArrayList<String> avis(Hebergement x) throws SQLException, ClassNotFoundException {
        ArrayList<String> listeAvis = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String nameDatabase = "ecebooking";
        String loginDatabase = "root";
        String passwordDatabase = "root";
        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
        // Requête SQL pour récupérer les appartements par localisation
        String requeteSQL = "SELECT * FROM avis WHERE Id_H = '" + x.getHebergId() + "';";
        // Connexion à la base de données
        try (Connection conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
             // Préparation de la requête avec le paramètre de localisation recherchée
             Statement st = conn.createStatement()) {

            // Exécution de la requête
            ResultSet resultSet = st.executeQuery(requeteSQL);

            // Parcours des résultats et affichage des appartements
            while (resultSet.next()) {
                listeAvis.add(resultSet.getString("Commentaire"));
                System.out.println(resultSet.getString("Commentaire"));
            }

        }
        return listeAvis;
    }

}
