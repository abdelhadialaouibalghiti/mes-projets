package vue;

import modele.client.Client;
import modele.hebergement.Hebergement;
import modele.reservation.ReservDao;
import modele.reservation.ReservDaoImpl;
import modele.reservation.Reservation;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static vue.SetBackGroundImage.setBackgroundImage;

public class PageReserv extends JFrame {
    public PageReserv(Hebergement hebergement, Client client, Reservation reservation) throws IOException, FontFormatException, ClassNotFoundException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(this.MAXIMIZED_BOTH);
        JPanel panneau = new JPanel(null);
        ReservDao reservDao = new ReservDaoImpl();
        panneau = setBackgroundImage(this, new File("images/Background.jpg"));

        // Creation des polices
        File file = new File("fonts/agaaler.ttf");
        Font fontTitre = Font.createFont(Font.TRUETYPE_FONT, file);
        fontTitre = fontTitre.deriveFont(Font.PLAIN, 24);
        Font font = new Font("Arial", Font.PLAIN, 16);

        ImageIcon logoIcon = new ImageIcon("images/logo.png");
        Image image = logoIcon.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH); // redimensionner l'image
        ImageIcon resizedLogo = new ImageIcon(image); // créer une nouvelle icône avec l'image redimensionnée
        JLabel logo = new JLabel(resizedLogo);
        logo.setBounds(645,5,150,80);

        JLabel co = new JLabel("Confirmation de votre reservation !");
        co.setBounds(200, 50, 500, 200); // position et taille du titre
        co.setForeground(new Color(159,201,212));
        co.setFont(fontTitre);

        JLabel texte = new JLabel("Nous vous avons envoyé un mail de confirmation !");
        texte.setBounds(150, 230, 1000, 100); // position et taille du titre
        texte.setFont(font);
        JLabel sejour = new JLabel("Bon séjour ! ");
        sejour.setBounds(150, 300, 1000, 100); // position et taille du titre
        sejour.setFont(font);

        if(reservDao.searchInfo(reservation, hebergement, client))
        {
                panneau.add(co);
                panneau.add(texte);
                panneau.add(sejour);
        }
        else {
            co.setText("Probleme avec l'etablissement de votre reservation");
            texte.setText("Nous n'arrivons pas à ajouter votre réservation");
            sejour.setText("Veuillez réessayer ultérieurement");

            panneau.add(co);
            panneau.add(texte);
            panneau.add(sejour);
        }

        JPanel rectangle = new JPanel();
        rectangle.setBounds(100, 200, 1340, 500); // Position et taille du rectangle
        rectangle.setBackground(Color.white); // Couleur du rectangle
        panneau.add(rectangle);

        setVisible(true);
    }

    public static void main(String[] args){
    }
}
