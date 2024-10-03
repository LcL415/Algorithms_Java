import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要找的年份");
        String year = sc.nextLine();
        int y=Integer.parseInt(year);
        Calendar c= Calendar.getInstance();*/
       /* c.set(y,2,1);
        c.add(Calendar.DATE,-1);
       int d= c.get(Calendar.DATE);
        System.out.println(d);*/
        System.out.println();
student s1= new student("liu");
student s2=new student("li");
        System.out.println(s1.getName().compareTo(s2.getName()));

    }
}