package laivanupotus;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Graafinen versio
 */
public class GUI extends JFrame {
    public static Laivanupotus laivanupotus;
    
    public static JLabel ilmoitus;
    public static JTextArea inputteri;
    public static JButton entteri;
    public static JTextField peliruutu;
    
    public GUI() {
        ilmoitus = new JLabel("Tervetuloa");
        inputteri = new JTextArea(1,2);
        entteri = new JButton("OK");
        
        peliruutu = new JTextField("[?]");
        peliruutu.setEditable(false);
        
        JPanel ylakerta = new JPanel(new GridLayout());
        ylakerta.add(ilmoitus);
        ylakerta.add(inputteri);
        ylakerta.add(entteri);
        
        JPanel alakerta = new JPanel(new GridLayout());
        alakerta.add(peliruutu);
        
        this.setLayout(new BorderLayout());
        this.add("North", ylakerta);
        this.add("Center", alakerta);
        
       //tapahtumakuuntelija
        
        entteri.addActionListener(
        new ActionListener () {
         public void actionPerformed(ActionEvent tapahtuma) {
          //jotai tapahtuu
        }
      }
    );
                    
        
        laivanupotus = new Laivanupotus();
    }
    
    public static void main(String[] args) {
        GUI ikkuna = new GUI(); 
        ikkuna.setTitle("Laivanupotus");
        ikkuna.pack();
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.setVisible(true);
        
        laivanupotus.pelaa();
    }
}


