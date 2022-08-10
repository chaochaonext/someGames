import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @Author: ChenHC
 * @Date: 2022/8/8 14:41
 */
public class BodyOfSnake {
    String baseUrl = "imgs/snake/";
    int x;
    int y;
    int width;
    int height;
    //方向 0上 1下 2左 3右
    int direction = 3;
    Image image;

    BodyOfSnake(){
        this.x = 10;
        this.y = 40;
        this.width = 20;
        this.height = 20;
        image = Toolkit.getDefaultToolkit().getImage(baseUrl + "body.png");
    }
    BodyOfSnake(int x,int y,int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.width = 20;
        this.height = 20;
        image = Toolkit.getDefaultToolkit().getImage(baseUrl + "body.png");
    }



    void paintSelf(Graphics g,int direction){
        int n = 20;
        switch(direction){
            case 0:
                y -= n;
                break;
            case 1:
                y += n;
                break;
            case 2:
                x -= n;
                break;
            case 3:
                x += n;
                break;
            default:

        }
        if(x < 0 || y < 0 || x > 600 - width || y > 600 - height){
            JOptionPane.showMessageDialog(null, "超出边界", "错误提示", JOptionPane.PLAIN_MESSAGE);
            System.exit(-1);
        }
        g.drawImage(image,x,y,null);
    }
}

