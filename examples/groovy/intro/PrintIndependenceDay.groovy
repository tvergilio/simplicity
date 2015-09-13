import java.util.Calendar;
import java.util.Date;

public class PrintIndependenceDay {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DATE, 4);
        calendar.set(Calendar.YEAR, 1776);
        Date time = calendar.getTime();
        System.out.println(time);
    }
}
