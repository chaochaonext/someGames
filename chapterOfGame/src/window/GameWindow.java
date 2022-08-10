package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ChenHC
 * @Date: 2022/8/8 7:26
 */
public class GameWindow extends JFrame {
    List<AllObject> objList = new ArrayList<AllObject>();

    GameBackground gb = new GameBackground();
    Line line = new Line(this);
    Image offImage;

    {
        Gold gold;
        for (int i = 0; i < 10; i++) {
            if(Math.random() < 0.2){
                gold = new GoldMiNi();
            }else if(Math.random() < 0.6){
                gold = new Gold();
            }else if(Math.random() < 0.8){
                gold = new Gold300();
            }else{
                gold = new Gold600();
            }
            objList.add(gold);
        }
        for (int i = 0; i < 3; i++) {
            objList.add(new Rock());
        }
    }

    void launch(){
        this.setVisible(true);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //定义鼠标点击事件
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton() == 1){
                    if(line.state == 0){
                        line.state = 1;
                    }
                }
            }
        });
        //使用循环重复绘制刷新
        while(true){
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //绘制方法
    @Override
    public void paint(Graphics g){
        offImage = this.createImage(600,600);
        Graphics gImage = offImage.getGraphics();
        gb.paintSelf(gImage);
        line.printSelf(gImage);

        for(AllObject object: objList){
            object.paintSelf(gImage);
        }

        g.drawImage(offImage,0,0,null);
    }

    public static void main(String[] args){
        GameWindow gameWindow = new GameWindow();
        gameWindow.launch();
    }
}
