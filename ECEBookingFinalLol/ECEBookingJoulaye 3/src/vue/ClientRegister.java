/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import modele.client.Client;
import modele.client.ClientDao;
import modele.client.ClientDaoImpl;
import modele.hebergement.Hebergement;
import modele.reservation.Reservation;
import modele.resultats.Resultats;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;


public class ClientRegister extends javax.swing.JFrame {

    private JPanel panneau;
    private JTextField nom;
    private JTextField email = new JTextField(20);
    private JTextField mdp = new JTextField(20);
    private JTextField tel;
    private JLabel ls = new JLabel();
    private JLabel le = new JLabel();
    //Création du spinner pour rentrer l'age
    private JSpinner age;
    private GridBagConstraints constraints;
    private Client C1;
    private JFrame pageD;
    private JFrame pageRech;
    private JFrame pageRes;
    private JFrame pageF;
    private Resultats result;
    private Hebergement hebergement;

    /**
     * Creates new form EmployeeRegister
     */
    public ClientRegister(Client client, JFrame lapage, int choix, Resultats resultats, Hebergement h) {
        setTitle("LogECE.fr");
        setSize(1000, 500);
        //pour fermer proprement la fenêtre en vliquant sur la croix
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        client = C1;
        switch (choix){
            case 1:
                pageRech = lapage;
                break;
            case 2:
                pageRes = lapage;
                result = resultats;
                break;
            case 3:
                pageD = lapage;
                hebergement = h;
                result = resultats;
                break;
            case 4:
                pageF = lapage;
                hebergement = h;
                result = resultats;
                break;
        }
        connexion();
    }
    public ClientRegister(Client client, Hebergement hebergement, Reservation reservation, JFrame frame)  {
        setTitle("LogECE.fr");
        setSize(1000, 500);
        //pour fermer proprement la fenêtre en vliquant sur la croix
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nomReservation(hebergement, reservation);
        pageD = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void inscription() {
        panneau = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        if(nom == null)
            nom = new JTextField(20);
        if(tel == null)
            tel = new JTextField(20);
        //Création du spinner pour rentrer l'age
        if(age == null)
            age = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.MONTH));

        age.setEditor(new JSpinner.DateEditor(age, "MM/YYYY"));
        age.setBounds(100, 100, 45, 30);
        //Création de l'affichage
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        //Ajouts des éléments dans le panneau
        constraints.gridx = 0;
        constraints.gridy = 0;
        panneau.add(new JLabel("Nom Prénom : "), constraints);

        constraints.gridx = 1;
        panneau.add(nom, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panneau.add(new JLabel("E-Mail : "), constraints);

        constraints.gridx = 1;
        panneau.add(email, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panneau.add(new JLabel("Mot de passe : "), constraints);

        constraints.gridx = 1;
        panneau.add(mdp, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panneau.add(new JLabel("Téléphone (ex:+33123456789) : "), constraints);

        constraints.gridx = 1;
        panneau.add(tel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panneau.add(new JLabel("Date de naissance (MM/YYYY) : "), constraints);

        constraints.gridx = 1;
        panneau.add(age, constraints);

        //Création du bouton de validation
        JButton bouton = new JButton("S'Inscrire");
        //Evenementiel du bouton de validation
        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boutonActionPerformed(e);
            }
        });
        // Ajout du bouton à la fenêtre
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        panneau.add(bouton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        panneau.add(new JLabel("Vous avez déjà un compte ?"), constraints);
        //Création du bouton de connexion
        JButton conn = new JButton("Connectez-vous");
        conn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connActionPerformed(e);
            }
        });
        //Ajout du bouton de connexion au panneau
        constraints.gridx = 1;
        constraints.gridy = 8;
        panneau.add(conn, constraints);

        //Ajout de bordures au panneau
        panneau.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Inscription"));

        this.getContentPane().add(panneau);
        pack();

        setLocationRelativeTo(null);
        // Affichage de la fenêtre
        setVisible(true);
    }
    private void connexion(){
    //Création du panneau pour les éléments
    panneau = new JPanel(new GridBagLayout());
    //Création de l'affichage
    constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.LINE_END;
    constraints.insets = new Insets(10, 10, 10, 10);
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = 0;
    constraints.gridy = 0;
    //Ajouts des éléments dans le panneau
    panneau.add(new JLabel("E-Mail : "), constraints);

    constraints.gridx = 1;
    panneau.add(email, constraints);

    constraints.gridx = 0;
    constraints.gridy = 1;
    panneau.add(new JLabel("Mot de passe : "), constraints);

    constraints.gridx = 1;
    panneau.add(mdp, constraints);

    constraints.anchor = GridBagConstraints.CENTER;
    //Création du bouton de validation
    JButton bouton2 = new JButton("Se Connecter");
    bouton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            bouton2ActionPerformed(e);
        }
    });
    //Ajout du bouton de validation au panneau
    constraints.gridx = 1;
    constraints.gridy = 2;
    constraints.gridwidth = 2;
    panneau.add(bouton2, constraints);

    constraints.gridx = 1;
    constraints.gridy = 5;
    panneau.add(new JLabel("Pas encore de compte ? Rejoignez-nous !"), constraints);
    //Création du bouton de validation
    JButton insc = new JButton("Inscrivez-vous");
    insc.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            inscActionPerformed(e);
        }
    });
    //Ajout du bouton d'inscription au panneau
    constraints.gridx = 1;
    constraints.gridy = 6;
    constraints.gridwidth = 2;
    panneau.add(insc, constraints);
    //Ajout de bordures au panneau
    panneau.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Connexion"));
    //Ajout du panneau sur la fenetre
    this.getContentPane().add(panneau);
    pack();
    //Centrer la fenetre sur l'ecran
    setLocationRelativeTo(null);
    // Affichage de la fenêtre
    setVisible(true);

}// </editor-fold>//GEN-END:initComponents
    public void connexionReserv(Hebergement hebergement, Reservation reservation){
    //Création du panneau pour les éléments
    panneau = new JPanel(new GridBagLayout());
    //Création de l'affichage
    constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.LINE_END;
    constraints.insets = new Insets(10, 10, 10, 10);
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = 0;
    constraints.gridy = 0;
    //Ajouts des éléments dans le panneau
    panneau.add(new JLabel("E-Mail : "), constraints);

    constraints.gridx = 1;
    panneau.add(email, constraints);

    constraints.gridx = 0;
    constraints.gridy = 1;
    panneau.add(new JLabel("Mot de passe : "), constraints);

    constraints.gridx = 1;
    panneau.add(mdp, constraints);

    constraints.anchor = GridBagConstraints.CENTER;
    //Création du bouton de validation
    JButton bouton2 = new JButton("Se Connecter");
    bouton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            le.setText("Mot de passe ou Identifiant incorrect");
            ClientDao cliDao = new ClientDaoImpl();
            C1 = new Client();
            C1.setMail(email.getText());
            C1.setPassword(mdp.getText());
            reservation.setMailClient(C1.getMail());
            try {
                constraints.gridx = 1;
                constraints.gridy = 3;
                if (cliDao.searchClient(C1)) {
                    panneau.remove(le);
                    panneau.add(ls, constraints);
                    pageD.removeAll();
                    new PageReserv(hebergement, C1, reservation, pageD);
                    dispose();
                } else {
                    panneau.remove(ls);
                    panneau.add(le, constraints);
                }
                panneau.revalidate();
                panneau.repaint();
                pack();
            } catch (ClassNotFoundException | IOException | FontFormatException classNotFoundException) {
                throw new RuntimeException(classNotFoundException);
            }
        }
    });
    //Ajout du bouton de validation au panneau
    constraints.gridx = 1;
    constraints.gridy = 2;
    constraints.gridwidth = 2;
    panneau.add(bouton2, constraints);

    constraints.gridx = 1;
    constraints.gridy = 5;
    panneau.add(new JLabel("Utiliser Trav'ECE sans compte ?"), constraints);
    //Création du bouton de validation
    JButton insc = new JButton("Retour");
    insc.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            constraints = null;
            remove(panneau);
            nomReservation(hebergement, reservation);
        }
    });
    //Ajout du bouton d'inscription au panneau
    constraints.gridx = 1;
    constraints.gridy = 6;
    constraints.gridwidth = 2;
    panneau.add(insc, constraints);
    //Ajout de bordures au panneau
    panneau.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Connexion"));
    //Ajout du panneau sur la fenetre
    this.getContentPane().add(panneau);
    pack();
    //Centrer la fenetre sur l'ecran
    setLocationRelativeTo(null);
    // Affichage de la fenêtre
    setVisible(true);
}
    public void nomReservation(Hebergement hebergement, Reservation reservation){
        JTextField nom = new JTextField(20);
    //Création du panneau pour les éléments
    panneau = new JPanel(new GridBagLayout());
    //Création de l'affichage
    constraints = new GridBagConstraints();
    constraints.anchor = GridBagConstraints.LINE_END;
    constraints.insets = new Insets(10, 10, 10, 10);
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = 0;
    constraints.gridy = 0;
    //Ajouts des éléments dans le panneau
    panneau.add(new JLabel("Nom Prénom : "), constraints);

    constraints.gridx = 1;
    panneau.add(nom, constraints);

    constraints.gridx = 0;
    constraints.gridy = 1;
    panneau.add(new JLabel("E-Mail : "), constraints);

    constraints.gridx = 1;
    panneau.add(email, constraints);

    constraints.anchor = GridBagConstraints.CENTER;
    //Création du bouton de validation
    JButton bouton2 = new JButton("Continuer");
    bouton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ls.setText("Connexion réussie");
            C1 = new Client();
            C1.setMail(email.getText());
            C1.setName(nom.getText());
            reservation.setMailClient(C1.getMail());
            reservation.setNomClient(C1.getName());
            try {
                pageD.removeAll();
                new PageReserv(hebergement, C1, reservation, pageD);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        }
    });
    //Ajout du bouton de validation au panneau
    constraints.gridx = 1;
    constraints.gridy = 2;
    constraints.gridwidth = 2;
    panneau.add(bouton2, constraints);

    constraints.gridx = 1;
    constraints.gridy = 5;
    panneau.add(new JLabel("Pas encore de compte ? Rejoignez-nous !"), constraints);
    //Création du bouton de connexion
    JButton insc = new JButton("Connectez-vous");
    insc.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            constraints = null;
            remove(panneau);
            connexionReserv(hebergement, reservation);
        }
    });
    //Ajout du bouton d'inscription au panneau
    constraints.gridx = 1;
    constraints.gridy = 6;
    constraints.gridwidth = 2;
    panneau.add(insc, constraints);
    //Ajout de bordures au panneau
    panneau.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), ""));
    //Ajout du panneau sur la fenetre
    this.getContentPane().add(panneau);
    pack();
    //Centrer la fenetre sur l'ecran
    setLocationRelativeTo(null);
    // Affichage de la fenêtre
    setVisible(true);
}
    private void connActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connActionPerformed
        constraints = null;
        remove(panneau);
        connexion();
    }//GEN-LAST:event_connActionPerformed
    private void inscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connActionPerformed
        constraints = null;
        remove(panneau);
        inscription();
    }//GEN-LAST:event_connActionPerformed

    private void boutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonActionPerformed
        ls.setText("Compte créé Bienvenue chakal ;)");
        le.setText("Gros naze t'as déjà utilisé cet email");
        Period agee = Period.between(new java.sql.Date(((Date) age.getValue()).getTime()).toLocalDate(), LocalDate.now());
        ClientDao cliDao = new ClientDaoImpl();
        C1 = new Client();
        C1.setName(nom.getText());
        C1.setMail(email.getText());
        C1.setPassword(mdp.getText());
        C1.setNumTel(tel.getText());
        C1.setAge(agee.getYears());
        try {
            constraints.gridx = 1;
            constraints.gridy = 5;
            if (cliDao.addClient(C1)) {
                panneau.remove(le);
                panneau.add(ls, constraints);
                if(pageRech != null) {
                    pageRech.dispose();
                    new PageRecherche().setClient(C1);
                }
                if(pageRes != null) {
                    pageRes.dispose();
                    new PageResultats(result,C1, new JFrame()).setC1(C1);
                }
                if(pageD != null) {
                    pageD.dispose();
                    new PageDescription(hebergement, C1, result, new JFrame()).setC1(C1);
                }
                if(pageF != null) {
                    pageF.dispose();
                    new PageDescription(hebergement, C1, result, new JFrame()).setC1(C1);
                }
                dispose();
            } else {
                panneau.remove(ls);
                panneau.add(le, constraints);
            }
            panneau.revalidate();
            panneau.repaint();
            pack();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_boutonActionPerformed
    private void bouton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton2ActionPerformed
        ls.setText("Connexion réussie");
        le.setText("Mot de passe ou Identifiant incorrect");
        ClientDao cliDao = new ClientDaoImpl();
        C1 = new Client();
        C1.setMail(email.getText());
        C1.setPassword(mdp.getText());
        try {
            constraints.gridx = 1;
            constraints.gridy = 3;
            if (cliDao.searchClient(C1)) {
                panneau.remove(le);
                panneau.add(ls, constraints);
                if(pageRech != null) {
                    pageRech.dispose();
                    new PageRecherche().setClient(C1);
                }
                if(pageRes != null) {
                    new PageResultats(result,C1, pageRes).setC1(C1);
                }
                if(pageD != null) {
                    new PageDescription(hebergement, C1, result, pageD).setC1(C1);
                }
                dispose();
            } else {
                panneau.remove(ls);
                panneau.add(le, constraints);
            }
            panneau.revalidate();
            panneau.repaint();
            pack();
        } catch (ClassNotFoundException | IOException | FontFormatException | SQLException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_bouton2ActionPerformed

    public Client getC1() {
        return C1;
    }
}
