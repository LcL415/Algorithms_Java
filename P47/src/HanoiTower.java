import java.util.LinkedList;

public class HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    public static void init(int n) {
        for (int i = n; i > 0; i--) {
            a.addLast(i);
        }
    }

    static void move(int n, LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }
        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        show();
        move(n - 1, b, a, c);
    }

    private static void show() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("-----------");
    }
}
