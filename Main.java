import javax.swing.*;
public class Main {
    public static  void main (String[] args) {
        JFrame okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // po zmáčknutí křížku by bez tohohle příkazu hra pořád běžela
        okno.setResizable(false); //
        okno.setTitle("Testovací hra");

        Herni_Panel herniPanel = new Herni_Panel();

        okno.add(herniPanel);

        okno.pack();// Z působí že toto okno bude mít preferovanou velikost svého subKomponentu, což je Herni_panel

        okno.setLocationRelativeTo(null);
        okno.setVisible(true);

        herniPanel.startGameThread();


    }
}
