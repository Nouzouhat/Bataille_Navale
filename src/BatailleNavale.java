import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BatailleNavale extends JFrame implements ActionListener {
    private JButton[][] grilleJoueur;
    private JButton[][] grilleAdversaire;

    public BatailleNavale() {
        this.setTitle("Bataille Navale");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(200, 200, 500, 300);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(173, 216, 230));

        // Initialisation des grilles
        grilleJoueur = new JButton[10][10];
        grilleAdversaire = new JButton[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grilleJoueur[i][j] = new JButton();
                grilleJoueur[i][j].setBounds(20 + j * 25, 20 + i * 25, 25, 25);
                grilleJoueur[i][j].setBackground(Color.BLUE);
                grilleJoueur[i][j].setOpaque(true);
                grilleJoueur[i][j].addActionListener(this);
                this.add(grilleJoueur[i][j]);

                grilleAdversaire[i][j] = new JButton();
                grilleAdversaire[i][j].setBounds(250 + j * 25, 20 + i * 25, 25, 25);
                grilleAdversaire[i][j].setBackground(Color.BLUE);
                grilleAdversaire[i][j].setOpaque(true);
                grilleAdversaire[i][j].addActionListener(this);
                this.add(grilleAdversaire[i][j]);
            }
        }

        this.setVisible(true);
    }

    public static void main(String[] args) {
        BatailleNavale jeu = new BatailleNavale();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        // Vérifier sur quelle grille le clic a été effectué
        boolean clicGrilleJoueur = false;
        int ligne = -1, colonne = -1;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (source == grilleJoueur[i][j]) {
                    clicGrilleJoueur = true;
                    ligne = i;
                    colonne = j;
                    break;
                } else if (source == grilleAdversaire[i][j]) {
                    clicGrilleJoueur = false;
                    ligne = i;
                    colonne = j;
                    break;
                }
            }
        }

        if (clicGrilleJoueur) {
            JOptionPane.showMessageDialog(this, "Clic sur la grille du joueur à la position : " + ligne + ", " + colonne);
            // Ajouter la logique du jeu ici
        } else {
            JOptionPane.showMessageDialog(this, "Clic sur la grille adverse à la position : " + ligne + ", " + colonne);
            // Ajouter la logique du jeu ici
        }
    }
}
