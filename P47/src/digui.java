import java.util.ArrayList;
import java.util.Arrays;

public class digui {
    public static int find(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }

    private static int f(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = i + j >> 1;
        if (target < a[m]) {
            return f(a, target, i, m - 1);
        } else if (a[m] < target) {
            return f(a, target, m + 1, j);
        } else {
            return m;
        }

    }

    public static void bubble(int[] a, int end) {
        f1(a, end);
    }

    private static void f1(int[] a, int end) {
        int x = 0;
        if (end == 0) {
            return;
        }
        for (int i = 0; i < end; i++) {
            if (a[i + 1] < a[i]) {
                int m = a[i];
                a[i] = a[i + 1];
                a[i + 1] = m;
                x = i;
            }
            f1(a, x);
        }
    }
    public static void insert(int[]a){
        f2(a,1);
    }
    private static void f2(int[] a, int low) {
        if(low==a.length){
            return;
        }
        int b = a[low];
        int i = low - 1;
        while (i>=0 &&b < a[i]) {
            a[i + 1] = a[i];
            i--;
        }
        a[i+1]=b;
        f2(a,low+1);
    }
    public static int array(int n){
       int[] b=new int[n+1];
        Arrays.fill(b,-1);
        b[0]=0;
        b[1]=1;
        return f3(n-1,b);

    }
    private static int f3(int n,int []b){
        if(b[n]!=-1)
        {
            return b[n];
        }

            int x = f3(n - 2, b);
            int y = f3(n - 1, b);
            b[n] = x + y;
            return b[n];

    }
// a origin   b assistance c target
    public static void hanoi(int n, ArrayList<Integer> a,ArrayList<Integer> b,ArrayList<Integer> c){
        f4(n-1,a,c,b);

    }
    private static void f4(int n, ArrayList<Integer> a,ArrayList<Integer> b,ArrayList<Integer> c){
        a.remove(n);
    }













}

