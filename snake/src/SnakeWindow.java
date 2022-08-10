import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @Author: ChenHC
 * @Date: 2022/8/8 14:32
 */
public class SnakeWindow extends JFrame {
    Image offImage;
    Snake snake = Snake.getInstance();
    Point point = new Point();


    void launch(){
        this.setVisible(true);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setTitle("贪吃蛇");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //定义键盘事件
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W:
                        snake.list.get(0).direction = 0;
                        break;
                    case KeyEvent.VK_UP:
                        snake.list.get(0).direction = 0;
                        break;
                    case KeyEvent.VK_S:
                        snake.list.get(0).direction = 1;
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.list.get(0).direction = 1;
                        break;
                    case KeyEvent.VK_A:
                        snake.list.get(0).direction = 2;
                        break;
                    case KeyEvent.VK_LEFT:
                        snake.list.get(0).direction = 2;
                        break;
                    case KeyEvent.VK_D:
                        snake.list.get(0).direction = 3;
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.list.get(0).direction = 3;
                        break;
                    default:
                        break;
                }
            }
        });
        //使用循环重复绘制刷新
        while(true){
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //绘制方法
    @Override
    public void paint(Graphics g){
        //表格左边有10，上边有40
        offImage = this.createImage(600,600);
        //使用双缓存，先将一个画布画出来，再将其覆盖在窗口画布上，避免闪烁问题
        Graphics gImage = offImage.getGraphics();

        for (BodyOfSnake body : snake.list) {
            body.paintSelf(gImage,snake.list.get(0).direction);
        }
        point.paintSelf(gImage,this);
        g.drawImage(offImage,0,0,null);
    }
    public static void main(String[] args) {
        SnakeWindow snakeWindow = new SnakeWindow();
        snakeWindow.launch();
    }
}
