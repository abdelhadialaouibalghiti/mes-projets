package vue;
import modele.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static vue.SetBackGroundImage.setBackgroundImage;

public class PageRecherche extends JFrame {

    private Client client;

    public PageRecherche() throws IOException, FontFormatException {
        JPanel panneau = new JPanel(null);
        JFrame frame =new JFrame();
        panneau = setBackgroundImage(frame, new File("images/prf5.jpg") );
        setTitle("TRAV'ECE");
        File file = new File("fonts/agaaler.ttf");
        Font fontTitre = Font.createFont(Font.TRUETYPE_FONT, file);
        fontTitre = fontTitre.deriveFont(Font.PLAIN, 24);
        Font font = new Font("Arial", Font.PLAIN, 16);

        // Placement logo et bouton connexion
        ImageIcon logoIcon = new ImageIcon("images/travece5.png");
        Image image = logoIcon.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH); // redimensionner l'image
        frame.setIconImage(image);
        ImageIcon resizedLogo = new ImageIcon(image); // créer une nouvelle icône avec l'image redimensionnée
        JLabel logo = new JLabel(resizedLogo);
        logo.setBounds(550,5,150,80);
        JButton loginButton = new JButton("Mon Compte");
        loginButton.setBounds(900,5,120,70);
        loginButton.setBackground(new Color(159,201,212));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClientRegister(client, (PageRecherche) frame);
            }
        });
        panneau.add(logo);
        panneau.add(loginButton);
        //panneau.add(image);

        //BANNER
        JLabel text = new JLabel("Welcome To TRAVE'ECE  ");
        text.setFont(new Font("Welcome To TRAVE'ECE", Font.ITALIC, 30));
        text.setBounds(450, 100, 400, 100);
        getContentPane().add(text);

        //Lieu
        JLabel lieu = new JLabel("Lieu : ");
        lieu.setFont(new Font("lieu", Font.BOLD, 16));
        lieu.setBounds(200, 260, 250, 50);
        getContentPane().add(lieu);
        JTextField searchField = new JTextField(20);
        searchField.setBounds(200,300,250,50);

        //Calender
        //date d'arrivée

        JSpinner dateArrive = new JSpinner(new SpinnerDateModel());
        SimpleDateFormat DatA = new SimpleDateFormat("dd/MM/yyyy");
        JSpinner.DateEditor editA = new JSpinner.DateEditor(dateArrive, DatA.toPattern());
        dateArrive.setEditor(editA);
        dateArrive.setBounds(450,300,150,50);
        JLabel DateA = new JLabel("Date d'arrivé : ");
        DateA.setFont(new Font("Date d'arrivé", Font.BOLD, 16));
        DateA.setBounds(450, 260, 150, 50);
        getContentPane().add(DateA);
        frame.add(dateArrive);

        //date de départ
        JSpinner dateDepart = new JSpinner(new SpinnerDateModel());
        SimpleDateFormat DatD = new SimpleDateFormat("dd/MM/yyyy");
        JSpinner.DateEditor editD = new JSpinner.DateEditor(dateDepart, DatD.toPattern());
        dateDepart.setEditor(editD);
        dateDepart.setBounds(600,300,150,50);
        frame.add(dateDepart);

        JLabel DateD = new JLabel("Date de départ : ");
        DateD.setFont(new Font("Date de départ ", Font.BOLD, 16));
        DateD.setBounds(600, 260, 150, 50);
        getContentPane().add(DateD);

        // nbr personne
        JSpinner nbrpersonne = new JSpinner();
        nbrpersonne.setBounds(750,300,120,50);

        JLabel nbrP = new JLabel("Personnes : ");
        nbrP.setFont(new Font("Personnes", Font.BOLD, 16));
        nbrP.setBounds(750, 260, 120, 50);
        getContentPane().add(nbrP);

        // searchButton
        JButton searchButton = new JButton("Rechercher");
        searchButton.setBounds(870,300,200,50);
        searchButton.setBackground(new Color(159,201,212));
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


        //Affichage
        panneau.add(lieu);
        panneau.add(searchField);
        panneau.add(dateArrive);
        panneau.add(dateDepart);
        panneau.add(nbrpersonne);
        panneau.add(searchButton);


        add(panneau);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
}
