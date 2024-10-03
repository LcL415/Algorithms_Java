/*
* 卡特兰数原本是用来统计n个节点可以形成最多多少个不同的二叉树的
* */
public class Main {
    public static void main(String[] args) {

        System.out.println(cataland(5));
    }
    public static int cataland(int n){
        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int j = 2; j <n+1 ; j++) {
            for (int i = 0; i < j; i++) {
                dp[j]+=dp[i]*dp[j-i-1];
                System.out.printf("(%d)(%d)",i,j-i-1);
                System.out.println(dp[j]);
            }
        }

        return dp[n];
    }
}