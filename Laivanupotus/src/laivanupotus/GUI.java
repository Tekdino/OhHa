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
    public static JTextArea peliruutu;
    
    public GUI() {
        ilmoitus = new JLabel("Tervetuloa");
        
        peliruutu = new JTextArea("[?]");
        peliruutu.setEditable(false);
        
        JPanel ylakerta = new JPanel(new GridLayout());
        ylakerta.add(ilmoitus);
        
        JPanel alakerta = new JPanel(new GridLayout());
        alakerta.add(peliruutu);
        
        this.setLayout(new BorderLayout());
        this.add("North", ylakerta);
        this.add("Center", alakerta);
        
        laivanupotus = new Laivanupotus();
    }
    
    public static void main(String[] args) {
        GUI ikkuna = new GUI(); 
        ikkuna.setTitle("Laivanupotus");
        ikkuna.pack();
        ikkuna.setSize(600,600);
        ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ikkuna.setVisible(true);
        
        laivanupotus.pelaa();
    }
}


