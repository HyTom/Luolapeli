package UI;

import Logiikka.Generointi.Kerros;
import Logiikka.Generointi.Luolageneraattori;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PeliSovellus extends JFrame {
    private Piirtaja piirtaja;
    static JFrame f;  
  

    public PeliSovellus() {
        this.piirtaja = new Piirtaja();
    }
    
    public void aloita() {
        //Kerros kerros = this.lg.luoKerros(30, 2);
        //this.piirtaja.annaKerros(kerros);
        // create a new frame to store text field and button 
        f = new JFrame("panel");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setMinimumSize(new Dimension(500, 500));
  
        // add panel to frame 
        f.add(this.piirtaja);
  
        // set the size of frame 
        f.setSize(600, 600); 
  
        f.pack();
        f.setVisible(true);
    }

    public void annaKerros(Kerros k) {
        piirtaja.annaKerros(k);
    }
    
    

}
