package template.demo.date;

import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by peishen on 2018/10/31
 **/
public class CalendarTest {

    public static void main(String[] args){
        Calendar instance = Calendar.getInstance();
        // 2018-11-1:Month value is 0-based. e.g., 0 for January
        instance.set(2018,10,1);
        instance.add(Calendar.DATE, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
        System.out.println(yesterday);
//        (yesterday.equals("2018-10-31"));

        instance.clear();
        instance.set(2018,9,30);
        instance.add(Calendar.DATE, -1);
        yesterday = new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
        System.out.println(yesterday);
    }
}
