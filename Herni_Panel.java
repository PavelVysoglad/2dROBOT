import javax.swing.JPanel;
import java.awt.*;


public class Herni_Panel extends JPanel implements Runnable {
    // Nastavení obrazovky
    final int originalTileSize = 16;//16x16
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48*48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize*maxScreenCol; //768 pxl
    final int screenHight = tileSize*maxScreenRow; //576 pxl
    //FPS
    int FPS = 60;

    //TileManager tilem = new TileManager(this);

    KeyHandeler KeyH = new KeyHandeler();
    Thread gameThread;
    // určit startovní pozici hráče
    Hrac hrac = new Hrac(this, KeyH);
    int hracX = 100;
    int hracY = 100;
    int hracRychlost = 4;


    public Herni_Panel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHight));
        this.setBackground(Color.BLUE);
        this.setDoubleBuffered(true); // všechno vykreslování z tohoto komponentu bude probíhat mimo obrazovku
        // pomáhá hře lépe rendrovat
        this.addKeyListener(KeyH);
        this.setFocusable(true);// Herní panel


    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

    }
    @Override
    public void run() {
        /** GAMELOOP - základ celé hry
         * Hra jako taková neustále provádí kód
         * k tomu je potřeba vytvořit gameloop.
         */
        double intervalVykreslovani = 1000000000/FPS;
        double nasledujiciVykresleni = System.nanoTime() + intervalVykreslovani;

        while (gameThread != null){ // Dokud je hra spuštěná -existuje GameThread- bude se opakovat
            //System.out.println("THE_GAME_LOOP_IS_RUNNING");

            //Update : aktualizovat informace jako je poloha hráče, objektů, etc
            //Draw: Vykreslovat entity v závyslosti na jejich pozici
            update();
            repaint();


            long currentTime = System.nanoTime();
            try {
                double zbyvajiiciCas = nasledujiciVykresleni - System.nanoTime();
                zbyvajiiciCas = zbyvajiiciCas/1000000;

                if (zbyvajiiciCas < 0){
                    zbyvajiiciCas = 0;
                }

                Thread.sleep((long)zbyvajiiciCas); // na požadovaný čas, uspí thread
                nasledujiciVykresleni += intervalVykreslovani;
            } catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }
    public void update(){
        hrac.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

//        tilem.drawTile(g2);//je potřeba aby hra vykreslila tiles před hráčem, jinak by hráč byl schovaný za pozadím a nebylby vidět

        hrac.paintComponent(g2);

        g2.dispose();


    }

}
