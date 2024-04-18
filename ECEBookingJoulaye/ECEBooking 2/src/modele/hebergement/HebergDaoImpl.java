package modele.hebergement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HebergDaoImpl implements HebergDao {
    public boolean addHebergement(Hebergement hebergement) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String nameDatabase = "ecebooking";
        String loginDatabase = "root";
        String passwordDatabase="root";
        String urlDatabase = "jdbc:mysql://localhost:8889/" + nameDatabase;
        String sql = "insert into hébergements(Mailproprio, Photo1, Photo2, Titre, Categorie, Lieu, Prix, Capacite, nb_chambres, Piscine, Terrasse) values('"
                + hebergement.getMail() + "', '" + hebergement.getPhoto1() + "', '"+ hebergement.getPhoto2() + "', '"
                + hebergement.getTitre() + "', '" + hebergement.getCategorie() + "', '" + hebergement.getLieu() + "', "
                + hebergement.getPrix() + ", " + hebergement.getCapacite() +", " + hebergement.getNbChambres() + ", "
                + hebergement.isPiscine() + ", " + hebergement.isTerrasse() + ");";

        try(Connection conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            Statement statement = conn.createStatement();){
            int count = statement.executeUpdate(sql);
            System.out.println("number of rows affected by this query= " + count);
            if(count==0)
                return false;
            else return true;
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        return false;
    }

}
