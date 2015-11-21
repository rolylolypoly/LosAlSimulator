import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Will on 11/20/2015.
 */
public class MrSmiths {
    public static void talk() {
        while (true) {
            reponses();
        }
    }
    private static void reponses() {
        Map<Integer, String> matt = new HashMap<Integer, String>();
        matt.put(0, "Teenagers are stupid");
        matt.put(1, "Check your level of understanding");
        int responses = matt.size();
        int number = (int) (Math.random() * 10 * responses);
        System.out.println(matt.get(number));
    }
}
