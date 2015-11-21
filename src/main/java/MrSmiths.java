import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        matt.put(0, "Teenagers are stupid");
        matt.put(1, "Check your level of understanding");
        matt.put(2, "Pubbrric Boorean");
        matt.put(3, "Al Gore rhythmns");
        matt.put(4, "You're late");
        matt.put(5, "This is a box");
        matt.put(6, "Put your lids down");
        matt.put(7, "This is a rant");
        matt.put(8, "Please take out a piece of paper for the computer science test");
        matt.put(9, "WHAT!");
        int responses = matt.size();
        int number = (int) (Math.random() * responses);
        System.out.println(matt.get(number));
    }
}
