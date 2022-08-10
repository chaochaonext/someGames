import java.awt.*;

public class Point extends BodyOfSnake{
    Point(){
        this.x = (int)(Math.random() * 580);
        this.y = (int)(Math.random() * 550 + 30);
        this.image = image = Toolkit.getDefaultToolkit().getImage(baseUrl + "point.png");
    }
    
    //碰撞检测
    void paintSelf(Graphics g,SnakeWindow snakeWindow){
        BodyOfSnake body = snakeWindow.snake.list.get(0);
        if(body.x >= x - width && body.x <= x + width && body.y >= y - height && body.y <= y + height){
            this.x = (int)(Math.random() * 580);
            this.y = (int)(Math.random() * 550 + 30);
            BodyOfSnake bodyOfSnake = snakeWindow.snake.list.get(snakeWindow.snake.list.size() - 1);
            switch (snakeWindow.snake.list.get(snakeWindow.snake.list.size() - 1).direction){
                case 0:
                    snakeWindow.snake.list.add(new BodyOfSnake(bodyOfSnake.x,bodyOfSnake.y+20,bodyOfSnake.direction));
                    break;
                case 1:
                    snakeWindow.snake.list.add(new BodyOfSnake(bodyOfSnake.x,bodyOfSnake.y-20,bodyOfSnake.direction));
                    break;
                case 2:
                    snakeWindow.snake.list.add(new BodyOfSnake(bodyOfSnake.x+20,bodyOfSnake.y,bodyOfSnake.direction));
                    break;
                case 3:
                    snakeWindow.snake.list.add(new BodyOfSnake(bodyOfSnake.x-20,bodyOfSnake.y,bodyOfSnake.direction));
                    break;
            }
        }
        g.drawImage(image,x,y,null);
    }
}