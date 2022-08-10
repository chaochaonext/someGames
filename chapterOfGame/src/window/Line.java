package window;



import lombok.Data;

import java.awt.*;

/**
 * @Author: ChenHC
 * @Date: 2022/8/8 8:00
 */
@Data
public class Line {
    //起点坐标
    private int startx = 300;
    private int starty = 100;
    //终点坐标
    private int endx = 300;
    private int endy = 500;
    //设置线的长度
    private double len = 50;
    //设置延长速度
    private double lengthen = 15;
    //表示线的角度/PI
    private double n = 1;
    //方向
    private int dir = 1;
    //表示红线的状态 0:旋转 1：延长 2：收缩 3：抓取
    int state = 0;

    GameWindow frame;

    Line(GameWindow frame){
        this.frame = frame;
    }

    //碰撞检测
    AllObject isCollision(){
        AllObject obj = null;
        for(AllObject object: frame.objList){
            if(endx >= object.x && endx <= object.x + object.width
                    && endy >= object.y && endy <= object.y + object.height){
                obj = object;
                break;
            }
        }
        return obj;
    }

    void paintLine(Graphics g){
        endx = (int) (startx + Math.cos(n * Math.PI) * len);
        endy = (int) (starty + Math.sin(n * Math.PI) * len);
        g.setColor(Color.red);
        g.drawLine(startx,starty,endx,endy);
    }

    void printSelf(Graphics g){
        AllObject obj = isCollision();
        if(obj != null){
            state = 3;
        }
        switch (state){
            case 0:
                if(n >= 1 || n <= 0){
                    dir = -1 * dir;
                }
                n = n + dir * 0.01;
                paintLine(g);
                break;
            case 1:
                if(len <= 500){
                    len += lengthen;
                    paintLine(g);
                }else{
                    state = 2;
                }
                break;
            case 2:
                if(len >= 50){
                    len -= lengthen;
                    paintLine(g);
                }else{
                    state = 0;
                }
                break;
            case 3:
                if(len >= 50){
                    len -= lengthen * obj.quality;
                    paintLine(g);
                    obj.x = endx - (int)lengthen;
                    obj.y = endy;

                }else{

                    obj.x = -150;
                    obj.y = -150;

                    state = 0;
                }

        }


    }

}
