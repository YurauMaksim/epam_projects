import java.util.ArrayList;
import java.util.List;

public class InfinityArrayListAdditionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        while(true){
            list.add(new String("SomeString").intern());
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
