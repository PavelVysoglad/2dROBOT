
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Hrac extends Entita{
    Herni_Panel herniPanel;
    KeyHandeler KeyH;


    public Hrac(Herni_Panel herniPanel, KeyHandeler KeyH){
        this.herniPanel = herniPanel;
        this.KeyH = KeyH;
        VychoziHodnoty();
        getplayerImage();
    }
    public void VychoziHodnoty (){
        x = 100;
        y = 100;
        rychlost = 4;
        smer = "nahoru";
    }
    public void getplayerImage(){
        try{

            pred1 = ImageIO.read(getClass().getResourceAsStream("/res/robot/Telobot_predek1.png"));
            pred2 = ImageIO.read(getClass().getResourceAsStream("/res/robot//Telobot_predek2.png"));
            leva1 = ImageIO.read(getClass().getResourceAsStream("/res/robot/Telobot_levy1.png"));
            leva2 = ImageIO.read(getClass().getResourceAsStream("/res/robot/Telobot_levy2.png"));
            prava1 = ImageIO.read(getClass().getResourceAsStream("/res/robot/Telobot_pravy1.png"));
            prava2= ImageIO.read(getClass().getResourceAsStream("/res/robot/Telobot_pravy2.png"));



        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public  void update (){
        if (KeyH.upPressed){
            y -= rychlost;
            smer = "nahoru";
        }
        else if (KeyH.downPressed){
            y += rychlost;
            smer = "dolu";
        }
        else if (KeyH.leftPressed){
            x -= rychlost;
            smer = "leva";
        }
        else if (KeyH.rightPressed){
            x += rychlost;
            smer = "prava";
        }
        spriteCounter++; //UPDATE PROBÍHÁ 60*SEKUNDU!,
        if (spriteCounter > 10){
            if (spriteNum==1){
                spriteNum = 2;
            } else if (spriteNum ==2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }


    }
    public void paintComponent(Graphics2D g2) {

        // g2.setColor(Color.WHITE);
        //g2.fillRect(x, y, herniPanel.tileSize, herniPanel.tileSize);
        BufferedImage image = null;
        switch (smer) {
            case "nahoru", "dolu":
                if (spriteNum == 1) {
                    image = pred1;
                }
                if (spriteNum == 2) {
                    image = pred2;
                }
                break;
            case "leva":
                if (spriteNum == 1){
                    image = leva1;
                }
                if (spriteNum == 2){
                    image = leva2;
                }
                break;
            case "prava":
                if (spriteNum == 1){
                    image = prava1;
                }
                if (spriteNum == 2 ){
                    image = prava2;
                }
                break;
        }

        g2.drawImage(image, x, y, herniPanel.tileSize, herniPanel.tileSize, null);

    }

}
