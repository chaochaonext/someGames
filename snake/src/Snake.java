import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ChenHC
 * @Date: 2022/8/8 14:40
 */
public class Snake {
    int len = 1;
    List<BodyOfSnake> list = new ArrayList<>();
    private static Snake instance = new Snake();
    private Snake(){
        list.add(new BodyOfSnake());
    }
    public static Snake getInstance(){
        return instance;
    }

}
