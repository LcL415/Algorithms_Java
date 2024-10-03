import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayLists = new ArrayList<>();
        String[] huase = {"♥", "♠", "♦", "♣"};
        String[] shuzi = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String h : shuzi) {
            for (String s : huase) {
                String newString = s + h;
                arrayLists.add(newString);
            }
        }
        arrayLists.add("小王");
        arrayLists.add("大王");
        System.out.println(arrayLists);
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        ArrayList<Integer> bh = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            hm.put(i, arrayLists.get(i));
            bh.add(i);
        }
        Collections.shuffle(bh);
        TreeSet<Integer> xiaohong = new TreeSet<>();
        TreeSet<Integer> xiaohuang = new TreeSet<>();
        TreeSet<Integer> xiaolv = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet();
        for (int i = 0; i < bh.size(); i++) {

            if (i >= bh.size() - 3) {
                dipai.add(bh.get(i));
            } else if (i % 3 == 0) {

                xiaohong.add(bh.get(i));
            } else if (i % 3 == 1) {
                xiaohuang.add(bh.get(i));
            } else {
                xiaolv.add(bh.get(i));
            }
        }
        System.out.println("小黄的牌是：");
        kanpai(xiaohuang, hm);
        System.out.println();
        System.out.println("小红的牌是：");
        kanpai(xiaohong, hm);
        System.out.println();
        System.out.println("小绿的牌是：");
        kanpai(xiaolv, hm);
        System.out.println();
        System.out.println("底牌是：");
        kanpai(dipai, hm);


    }

    public static void kanpai(TreeSet<Integer> t, HashMap<Integer, String> s) {
        for (int i : t) {
            System.out.print(s.get(i));
        }
    }

}