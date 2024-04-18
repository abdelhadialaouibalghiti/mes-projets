package vue;
import modele.client.Client;
import modele.hebergement.Hebergement;
import modele.reservation.ReservDao;
import modele.reservation.ReservDaoImpl;
import modele.reservation.Reservation;
import modele.resultats.ResultatsDao;
import modele.resultats.ResultatsDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static vue.SetBackGroundImage.setBackgroundImage;

public class PageDescription extends JFrame{

    private static Hebergement x;

    public PageDescription (Hebergement x, Client client) throws IOException, FontFormatException, SQLException, ClassNotFoundException {
        ArrayList<String> listeAvis = new ArrayList<>();
        this.x = x;
        JPanel panneau = new JPanel(null);
        JFrame frame = new JFrame();
        panneau = setBackgroundImage(frame, new File("images/fond_d'ecran.jpg"));

        // Titre de la fenêtre
        setTitle("TRAV'ECE");

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
                new ClientRegister(client);
            }
        });
        panneau.add(logo);
        panneau.add(loginButton);


        // Recuperation photo 1 et photo 2
        String photo1 = "images/"+x.getPhoto1();
        ImageIcon icon1 = new ImageIcon(photo1);
        Image img1 = icon1.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH); // redimensionner l'image
        ImageIcon resizedIcon1 = new ImageIcon(img1); // créer une nouvelle icône avec l'image redimensionnée
        JLabel label1 = new JLabel(resizedIcon1);

        String photo2 = "images/"+x.getPhoto2();
        ImageIcon icon2 = new ImageIcon(photo2);
        Image img = icon2.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH); // redimensionner l'image
        ImageIcon resizedIcon2 = new ImageIcon(img); // créer une nouvelle icône avec l'image redimensionnée
        JLabel label2 = new JLabel(resizedIcon2);

        // Recuperation des avis
        ResultatsDao resultat = new ResultatsDaoImpl();
        listeAvis = resultat.avis(x);

        for(int i=0;i<listeAvis.size();i++){
            JLabel avis = new JLabel(listeAvis.get(i));
            avis.setBounds(150,i*100 +600, 200,200);
            avis.setFont(font);
            panneau.add(avis);
        }
        if (listeAvis.size()==0){
            JLabel avis = new JLabel("Pas encore d'avis");
            avis.setBounds(400,600, 200,200);
            avis.setFont(font);
            panneau.add(avis);
        }

        //Bouton reserver
        JButton reserver = new JButton("Réserver");
        reserver.setBounds(850, 450 , 100, 50);
        reserver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReservDao reservDao = new ReservDaoImpl();
                Reservation reservation = new Reservation();
                reservation.setHebergId(x.getHebergId());
                if(client == null) {

                }
                else{
                    reservation.setClientId(client.getClientId());
                    reservation.setMailClient(client.getMail());
                    reservation.setNomClient(client.getName());
                }
                try {
                    if(reservDao.searchInfo(reservation, x, client))
                        reservDao.addReservation(reservation, client, x);
                } catch (ClassNotFoundException classNotFoundException) {
                    throw new RuntimeException(classNotFoundException);
                }
            }
        });
        panneau.add(reserver);

        JLabel titre = new JLabel(x.getTitre());
        JLabel note = new JLabel(String.valueOf(x.getNote())+ " / 5.0");
        JLabel lieu = new JLabel(x.getLieu());
        JLabel prix = new JLabel("A partir de "+String.valueOf(x.getPrix())+ "€ / nuit");
        JLabel categorie = new JLabel("Catégorie : " + x.getCategorie());
        JLabel lesAvis = new JLabel("Avis");

        label1.setBounds(100,  100, 500, 300);
        label2.setBounds(500,  100, 500, 300);
        titre.setBounds(150, 300, 300, 200);
        titre.setFont(fontTitre);
        note.setBounds(850, 300, 300, 200);
        note.setFont(fontTitre);
        lieu.setBounds(150,  360, 300, 200);
        lieu.setForeground(new Color(159,201,212));
        lieu.setFont(font);
        prix.setBounds(840,  450 , 300, 200);
        prix.setFont(font);
        categorie.setBounds(150, 330,300,200);
        categorie.setFont(font);
        lesAvis.setBounds(150,500,300,200);
        lesAvis.setFont(fontTitre);

        panneau.add(label1);
        panneau.add(label2);
        panneau.add(titre);
        panneau.add(note);
        panneau.add(lieu);
        panneau.add(reserver);
        panneau.add(prix);
        panneau.add(categorie);
        panneau.add(lesAvis);

        if (x.isPiscine()){
            JLabel piscine = new JLabel("Piscine");
            piscine.setBounds(440, 360 , 300, 200);
            piscine.setFont(font);
            panneau.add(piscine);
        }
        if (x.isTerrasse() && x.isPiscine()){
            JLabel terrasse = new JLabel("Terrasse");
            terrasse.setBounds(540, 360  , 300, 200);
            terrasse.setFont(font);
            panneau.add(terrasse);
        }
        else if (x.isTerrasse()){
            JLabel terrasse = new JLabel("Terrasse");
            terrasse.setBounds(440, 360 , 300, 200);
            terrasse.setFont(font);
            panneau.add(terrasse);
        }
        JPanel rectangle = new JPanel();
        rectangle.setBounds(90, 100, 1000, 700); // Position et taille du rectangle
        rectangle.setBackground(Color.white); // Couleur du rectangle
        panneau.add(rectangle);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Ajouter le label à la fenêtre
        add(panneau);

        // Définir la taille de la fenêtre
        setSize(300, 200);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Rendre la fenêtre visible à l'écran
        setVisible(true);

    }

    public static void main(String[] args){
        Hebergement x = new Hebergement();
        try {
            new PageDescription(x, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}