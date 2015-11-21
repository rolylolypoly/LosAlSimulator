import java.util.HashMap;
import java.util.Map;

/**
 * Created by Will on 11/20/2015.
 */
public class MrSmiths {
    public static void talk() {
        while (true) {
            responses();
        }
    }
    private static void responses() {
        Map<Integer, String> matt = new HashMap<>();
        matt.put(0, "Teenagers are stupid.");
        matt.put(1, "Check your level of understanding.");
        matt.put(2, "Pubbrric Boorean.");
        matt.put(3, "Al Gore rhythmns.");
        matt.put(4, "You're late.");
        matt.put(5, "This is a box.");
        matt.put(6, "Put your lids down.");
        matt.put(7, "This is a rant.");
        matt.put(8, "Please take out a piece of paper for the computer science test.");
        matt.put(9, "WHAT!");
        matt.put(10, "Internalize knowledge");
        int responses = 0;
        responses += matt.size() > 9 ? responses += (matt.size() - 9) : 0;
        int number = (int) ((Math.random() * 10) + responses);
        System.out.println(number);
    }
}
