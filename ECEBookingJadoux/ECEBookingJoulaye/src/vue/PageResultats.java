package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

import modele.client.Client;
import modele.hebergement.Hebergement;
import modele.resultats.ResultatsDaoImpl;

import java.sql.SQLException;

import static vue.SetBackGroundImage.setBackgroundImage;

public class PageResultats extends JFrame {

    private static String searchText;
    private Client C1;

    public PageResultats(String searchText, Client client) throws IOException, FontFormatException {
        this.searchText= searchText;
        ArrayList<Hebergement> maliste;

        JPanel panneau = new JPanel(null);
        JFrame frame = new JFrame();
        panneau = setBackgroundImage(frame, new File("images/Background.jpg"));

        // Titre de la fenêtre
        setTitle("TRAV'ECE");
        ResultatsDaoImpl essai = new ResultatsDaoImpl();
        try {
            maliste = essai.resultats(searchText);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Creation des polices
        File file = new File("fonts/agaaler.ttf");
        Font fontTitre = Font.createFont(Font.TRUETYPE_FONT, file);
        fontTitre = fontTitre.deriveFont(Font.PLAIN, 24);
        Font font = new Font("Arial", Font.PLAIN, 16);

        // Placement logo et bouton connexion
        ImageIcon logoIcon = new ImageIcon("images/logo.png");
        Image image = logoIcon.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH); // redimensionner l'image
        ImageIcon resizedLogo = new ImageIcon(image); // créer une nouvelle icône avec l'image redimensionnée
        JLabel logo = new JLabel(resizedLogo);
        logo.setBounds(645,5,150,80);
        JButton loginButton = new JButton("Mon Compte");
        loginButton.setBounds(1250,5,150,80);
        loginButton.setBackground(new Color(159,201,212));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClientRegister(client, (PageResultats) frame);
            }
        });
        panneau.add(logo);
        panneau.add(loginButton);

        // Messages resultats de recherche
        if (maliste.size()==0){
            JLabel label = new JLabel("Aucun resultat pour la recherche");
            label.setBounds(100,70,500,100);
            label.setFont(fontTitre);
            label.setForeground(new Color(159,201,212));
            panneau.add(label);
        }
        else {
            JLabel label = new JLabel(searchText + " : " + maliste.size() + " hebergements");
            label.setBounds(100,70,500,100);
            label.setFont(fontTitre);
            label.setForeground(new Color(159,201,212));
            panneau.add(label);
        }

        // affichage des hebergements
        int i=1;
        for (Hebergement x : maliste) {
            //Titre Lieu Note Prix
            JLabel titre = new JLabel(x.getTitre());
            JLabel note = new JLabel(String.valueOf(x.getNote())+ " / 5.0");
            JLabel lieu = new JLabel(x.getLieu());
            JLabel prix = new JLabel("A partir de "+String.valueOf(x.getPrix())+ "€ / nuit");

            //Photo
            String photo = "images/"+x.getPhoto1();
            ImageIcon icon = new ImageIcon(photo);
            Image img = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH); // redimensionner l'image
            ImageIcon resizedIcon = new ImageIcon(img); // créer une nouvelle icône avec l'image redimensionnée
            JLabel label = new JLabel(resizedIcon);

            //Bouton reserver
            JButton reserver = new JButton("Voir plus");
            reserver.setBounds(900, i * 230 + 30, 100, 50);
            reserver.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        new PageDescription(x, client);
                    } catch (IOException | SQLException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (FontFormatException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            //Setbounds et font
            label.setBounds(100, i * 230 - 80, 300, 200); // position et taille du label
            titre.setBounds(420, i * 230 - 130, 300, 200); // position et taille du titre
            titre.setForeground(new Color(159,201,212));
            titre.setFont(fontTitre);
            note.setBounds(900, i * 230 - 130, 300, 200);
            note.setFont(fontTitre);
            lieu.setBounds(420, i * 230 -100 , 300, 200);
            lieu.setFont(font);
            prix.setBounds(890, i * 230 , 300, 200);
            prix.setFont(font);


            //Ajout au panneau
            panneau.add(label);
            panneau.add(titre);
            panneau.add(note);
            panneau.add(lieu);
            panneau.add(reserver);
            panneau.add(prix);
            if (x.isPiscine()){
                JLabel piscine = new JLabel("Piscine");
                piscine.setBounds(440, i * 230 -50 , 300, 200);
                piscine.setFont(font);
                panneau.add(piscine);
            }
            if (x.isTerrasse() && x.isPiscine()){
                JLabel terrasse = new JLabel("Terrasse");
                terrasse.setBounds(540, i * 230 -50  , 300, 200);
                terrasse.setFont(font);
                panneau.add(terrasse);
            }
            else if (x.isTerrasse()){
                JLabel terrasse = new JLabel("Terrasse");
                terrasse.setBounds(440, i * 230 -50  , 300, 200);
                terrasse.setFont(font);
                panneau.add(terrasse);
            }
            JPanel rectangle = new JPanel();
            rectangle.setBounds(90, i*230 -85, 1000, 210); // Position et taille du rectangle
            rectangle.setBackground(Color.white); // Couleur du rectangle
            panneau.add(rectangle);

            i++;
        }

        // Fermer la fenêtre lorsque l'utilisateur clique sur le bouton de fermeture
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Ajouter le label à la fenêtre
        add(panneau);

        // Définir la taille de la fenêtre
        setSize(300, 200);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Rendre la fenêtre visible à l'écran
        setVisible(true);
    }

    public Client getC1() {
        return C1;
    }
    public void setC1(Client c1) {
        C1 = c1;
    }

    public static void main(String[] args) {
        // Créer une instance de la classe MaFenetre
        try {
            new PageResultats(searchText, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
