package controleur;
import vue.ClientRegister;
import vue.ProprioRegister;

/**
 *
 * @author palasi
 */
public class Test {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new ClientRegister(null);
                    new ProprioRegister();
            }
        });
    }
}
