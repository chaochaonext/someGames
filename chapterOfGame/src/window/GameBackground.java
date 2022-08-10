package window;

import java.awt.*;

/**
 * @Author: ChenHC
 * @Date: 2022/8/8 7:33
 */
public class GameBackground {
    String baseUrl = "imgs/chapterOfGame";
    Image bgOfSky = Toolkit.getDefaultToolkit().getImage(baseUrl + "/bgOfSky.jpg");
    Image bgOfGround = Toolkit.getDefaultToolkit().getImage(baseUrl + "/bgOfGround.jpg");
    Image person = Toolkit.getDefaultToolkit().getImage(baseUrl + "/person.png");

    void paintSelf(Graphics g){
        g.drawImage(bgOfSky,0,0,null);
        g.drawImage(bgOfGround,0,100,null);
        g.drawImage(person,260,40,null);
    }
}
