import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
  /*      int[]a={1,2,3,4,5,6,7,8};
        System.out.println(digui.find(a,4));
        int[]b={2,1,3,4,5,6,7,8};
        digui.bubble(b,b.length-1);
        System.out.println(Arrays.toString(b));
        int[]c={2,1,3,4,5,10,7,8,0};
        digui.insert(c);
        System.out.println(Arrays.toString(c));
        System.out.println(digui.array(5));*/

        HanoiTower.init(20);
        HanoiTower.move(20,HanoiTower.a,HanoiTower.b,HanoiTower.c);
    }


}