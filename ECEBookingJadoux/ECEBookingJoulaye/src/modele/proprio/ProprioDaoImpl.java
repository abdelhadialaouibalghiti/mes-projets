package modele.proprio;

import modele.proprio.Proprio;
import modele.proprio.ProprioDao;

import java.sql.*;

public class ProprioDaoImpl implements ProprioDao {
    public boolean addPropio(Proprio proprio) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String nameDatabase = "ecebooking";
        String loginDatabase = "root";
        String passwordDatabase="";
        String urlDatabase = "jdbc:mysql://localhost/" + nameDatabase;
        String sql = "insert into compteh(Name, Mail, password, age, num_tel) values('" + proprio.getName() + "', '" + proprio.getMail()
                + "', '" + proprio.getPassword() + "', "+ proprio.getAge() + ", '" + proprio.getNumTel() + "');";

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

    public boolean searchPropio(Proprio proprio) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String nameDatabase = "ecebooking";
        String loginDatabase = "root";
        String passwordDatabase="";
        String urlDatabase = "jdbc:mysql://localhost/" + nameDatabase;
        String sql = "select * from compteh where Mail = '" + proprio.getMail() + "' and password = '" + proprio.getPassword() + "';";

        try(Connection conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            Statement statement = conn.createStatement();){
            ResultSet resultSet = statement.executeQuery(sql);
            int count = 0;
            while(resultSet.next())
                count++;
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
