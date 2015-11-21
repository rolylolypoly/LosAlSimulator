import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Will on 11/20/2015.
 */
public class EngineeringRoom {

    private static Calendar cal = Calendar.getInstance();
    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    public static void howLoudIsItRightNow() {
        System.out.println("Enginnering Room Forecast:");
        System.out.println( "It is currently " + sdf.format(cal.getTime()) + "." );
        System.out.println("The forecasted noise level is " + noiseLevel() + ".");
    }

    private static String noiseLevel() {
        if ((sdf.format(cal.getTime()).matches("(12:[0-2][0-9]:[0-9][0-9])"))) return "300 Dbi";
        else return "50 Dbi";
    }
}
