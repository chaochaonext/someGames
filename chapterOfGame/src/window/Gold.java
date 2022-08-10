package window;

import java.awt.*;

/**
 * @Author: ChenHC
 * @Date: 2022/8/8 9:11
 */
public class Gold extends AllObject{
    Gold(){
        this.x = (int)(Math.random() * 550);
        this.y = (int)(Math.random() * 450 + 100);
        this.width = 45;
        this.height = 45;
        this.quality = 0.6;
        this.img = Toolkit.getDefaultToolkit().getImage(this.baseUrl + "/100.png");
    }
}
class GoldMiNi extends Gold{
    GoldMiNi(){
        this.x = (int)(Math.random() * 550);
        this.y = (int)(Math.random() * 450 + 100);
        this.width = 20;
        this.height = 20;
        this.quality = 0.9;
        this.img = Toolkit.getDefaultToolkit().getImage(this.baseUrl + "/20.png");
    }
}
class Gold300 extends Gold{
    Gold300(){
        this.width = 60;
        this.height = 60;
        this.quality = 0.4;
        this.img = Toolkit.getDefaultToolkit().getImage(this.baseUrl + "/300.png");
    }
}
class Gold600 extends Gold{
    Gold600(){
        this.width = 80;
        this.height = 80;
        this.quality = 0.3;
        this.img = Toolkit.getDefaultToolkit().getImage(this.baseUrl + "/600.png");
    }
}
class Rock extends Gold{
    Rock(){
        this.width = 40;
        this.height = 40;
        this.quality = 0.1;
        this.img = Toolkit.getDefaultToolkit().getImage(this.baseUrl + "/rock.png");
    }
}