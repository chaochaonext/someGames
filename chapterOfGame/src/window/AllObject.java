package window;

import java.awt.*;

/**
 * @Author: ChenHC
 * @Date: 2022/8/8 9:06
 */
public class AllObject {
    //设置坐标
    int x;
    int y;
    //设置宽高
    int width;
    int height;
    //设置速度比
    double quality;
    //设置初始地址
    String baseUrl = "imgs/chapterOfGame";
    //图片
    Image img;

    //判段是否重叠
    boolean isOverlap(int x,int y,int width,int height){

        return false;
    }

    void paintSelf(Graphics g){
        g.drawImage(img,x,y,null);
    }
}
