package vue;
import modele.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PageRecherche extends JFrame {

    private Client client;

    public PageRecherche() {
        super("TRAV'ECE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("images/ID1PHOTO1.jpg").getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        };
        panel.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        JTextField searchField = new JTextField(20);

        JButton searchButton = new JButton("Rechercher");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                try {
                    new PageResultats(searchText, client);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton loginButton = new JButton("Se connecter");
        loginButton.setForeground(new Color(159,201,212));
        loginButton.setPreferredSize(new Dimension(100, 100));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ouvrir la page de connexion
                ClientRegister pageConnexion = new ClientRegister(client);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        loginPanel.add(loginButton, BorderLayout.EAST);

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(loginPanel);

        add(searchPanel);
        pack();
        //setContentPane(panel);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PageRecherche();
    }
}
