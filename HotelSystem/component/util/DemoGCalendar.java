package component.util;

import java.util.GregorianCalendar;
import java.util.Calendar;


/**
 * Write a description of class DemoGCalendar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemoGCalendar
{
    public void demo(){
        GregorianCalendar gCal = new GregorianCalendar();
        GregorianCalendar gCal2 = new GregorianCalendar(13, 5, 7);
        
        if(gCal.before(gCal2)){
            System.out.println("menatap ke depan");
        } else {
            System.out.println("masa lalu biarlah masa lalu");
        }
        
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int year;
        System.out.print("Date: ");
        System.out.print(months[gCal.get(Calendar.MONTH)]);
        System.out.print(" " + gCal.get(Calendar.DATE) + " ");
        System.out.println(year = gCal.get(Calendar.YEAR));
        
        if(gCal.isLeapYear(year)) 
        { System.out.println("The current year is a leap year"); } 
        else 
        { System.out.println("The current year is not a leap year"); }

    }
}
