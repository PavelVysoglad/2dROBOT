import java.io.InputStream;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;


public class TileManager extends Tile {
    Herni_Panel herniPanel;
    Tile [] tile;
    private Object Objects;

    public TileManager(Herni_Panel herniPanel){
        this.herniPanel = herniPanel;
        tile = new Tile[3];

    }
//    public void getTileImage () {
//
//        try{
//            tile [0] = new Tile();
//            tile [0] = ImageIO.read(java.util.Objects.requireNonNull(getClass().getResourceAsStream("/res/tiles/trava.png")));
////
////            tile [1] = new Tile();
////            tile [1] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/tiles/voda.png")));
////
////            tile [2] = new Tile();
////            tile [2] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/tiles/zed.png")));
////
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
    public void drawTile(Graphics2D g2){
        g2.drawImage(tile[0].image, 0, 0,herniPanel.tileSize, herniPanel.tileSize, null);

    }
}
