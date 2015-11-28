package io.github.rollylollypolly;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Will on 11/20/2015.
 */
public class EngineeringRoom {

    private static Calendar cal = Calendar.getInstance();
    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    public static String howLoudIsItRightNow() {
        return "Enginnering Room Forecast:" + "\n" +
        "It is currently " + sdf.format(cal.getTime()) + "."  + "\n" +
        "The forecasted noise level is " + noiseLevel() + "." + "\n";
    }

    private static String noiseLevel() {
        if ((sdf.format(cal.getTime()).matches("(12:[0-2][0-9]:[0-9][0-9])"))) return "300 Dbi";
        else return "50 Dbi";
    }
}
