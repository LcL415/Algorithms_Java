// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static void element(int[] a, int i) {
        if (i == 0) {
            a[i] = 1;

        }
        for (int j = i; j > 0; j--) {
            a[j] = a[j - 1] + a[j];
        }
    }
    private static void space(int n, int i) {
        int number = (n - i - 1) * 2;
        for (int j = 0; j < number; j++) {
            System.out.print(" ");
        }

    }
    private static void print(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            element(a, i);
            space(n, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-4d", a[j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        print(5);
    }
}