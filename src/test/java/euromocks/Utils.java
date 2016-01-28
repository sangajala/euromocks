package euromocks;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by sriramangajala on 25/01/16.
 */
public class Utils {

    public static String getCurrentDate()
    {

        return getDate(1,"dd/MM/yyyy");
    }


    public static String getDate(int diff,String format)
    {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, diff);
        String dateTravel = dateFormat.format(cal.getTime());
       // dateTravel = dateTravel.replace(dateTravel.split("-")[1],String.valueOf(Integer.parseInt(dateTravel.split("-")[1])-1));
        return dateTravel;
    }

    public static int randomNumberBetweenRange(int min,int max)
    {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
       return rand.nextInt((max - min) + 1) + min;

    }
}
