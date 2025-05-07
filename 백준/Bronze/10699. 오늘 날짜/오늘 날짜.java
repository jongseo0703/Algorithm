import java.util.*;
import java.text.*;

public class Main {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String today = sdf.format(cal.getTime());

        System.out.print(today);

    }

}