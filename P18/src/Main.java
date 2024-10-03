// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 9, 9, 9};
        int target = 9;
        int result = search(a,target);
        if(result==-1){
            System.out.println(new int[] {-1,-1}.toString());

        }
        else{
            System.out.println(new int[]{result,search2(a,target)}.toString());
        }


    }

    public static int search(int[] a, int target) {

        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;

            if (target < a[m]) {
                j = m - 1;

            } else if (a[m] < target) {
                i = m + 1;

            } else {
                j = m - 1;
                candidate = m;

            }


        }

        return candidate;
    }

    public static int search2(int[] a, int target) {

        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;

            if (target < a[m]) {
                j = m - 1;

            } else if (a[m] < target) {
                i = m + 1;

            } else {
                i = m + 1;
                candidate = m;

            }


        }

        return candidate;
    }
}
