// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    //方法1：每次创建一个新节点 从原来的节点中取出复制到新节点
    public static ListNode reverse(ListNode o1) {
        ListNode n1 = null;
        // ListNode p = o1;
        while (o1 != null) {

            n1 = new ListNode(o1.val, n1);
            o1 = o1.next;

        }
        return n1;
    }

    //方法2：利用list容器，这样不用创建新的节点，直接用原来的节点
    public static ListNode reverse2(ListNode a) {
        list o = new list(a);
        list n = new list(null);
        while (true) {
            if (o.head != null) {
                n.addfirst(o.removeFirst());
            } else {
                break;
            }
        }
        return n.head;
    }

    //方法3：利用递归反转*先找最后一个节点
    public static ListNode reverse3(ListNode a) {
        if (a.next == null || a == null) {
            return a;
        }
        ListNode last = reverse3(a.next);
        a.next.next = a;
        a.next = null;
        return last;

    }

    //方法4： 从旧的链表中每次拿第二个元素并且把他插入到头部，需要用两个指针
    public static ListNode reverse4(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = o1;
        ListNode o2 = o1.next;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    //方法5， 和方法2 原理相同，只是相当于面向过程，方法2是面向对象
    public static ListNode reverse5(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }


    //按照列表的值去删除节点
    public static ListNode Delete1(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s.next;
        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }

    //方法2： 用递归的方法按照节点值来删除节点
    public static ListNode Delete2(ListNode p, int val) {
        if (p == null) {
            return null;
        }
        if (p.val == val) {
            return Delete2(p.next, val);
        } else {
            p.next = Delete2(p.next, val);
            return p;
        }
    }


    //根据顺序从链表尾部删除节点
    // 方法一： 递归
    public static ListNode Removefromlast(ListNode p, int val) {
        ListNode s = new ListNode(-1, p);
        recursion(s, val);
        return s.next;
    }

    private static int recursion(ListNode p, int val) {

        if (p == null) {
            return 0;
        }
        int num = recursion(p.next, val);
        if (num == val) {
            p.next = p.next.next;
        }
        return num + 1;

    }

    // 方法2， 用两个指针
    public static ListNode Removefromlast2(ListNode p, int n) {
        ListNode s = new ListNode(-1, p);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }


    //有序链表去重复 但始终保留一个
    //方法1： 用两个指针
    public static ListNode Removeduplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return head;
    }

    // 方法2： 递归
    public static ListNode Removeduplicates2(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            return Removeduplicates2(p.next);
        } else {
            p.next = Removeduplicates2(p.next);
            return p;
        }
    }


    //有序链表去重复 一个都不留
    //方法1： 递归
    public static ListNode deleteduplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            return deleteduplicates(x);
        } else {
            p.next = deleteduplicates(p.next);
            return p;
        }


    }

    //方法2：用三个指针
    public static ListNode deleteduplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        ListNode p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 != null && p2.val == p3.val)) {
                    p3 = p3.next;
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }



    //有序链表的拼接
    //方法1： 用一个指针p 通过比较
    public static ListNode mergeList(ListNode L1,ListNode L2){
        ListNode s=new ListNode(-1,null);
        ListNode p=s;
        while(L1!=null&&L2!=null){
            if(L1.val<L2.val){
                p.next=L1;
                L1=L1.next;
            }
            else{
                p.next=L2;
                L2=L2.next;
            }
            p=p.next;
        }
        if(L1!=null){
            p.next=L1;
        }
        else{
            p.next=L2;
        }
        return s.next;
    }
    //方法2：递归
    public static ListNode mergeList2(ListNode L1,ListNode L2){
        if(L1==null){
            return L2;
        }
        if(L2==null){
            return L1;
        }
        if(L1.val<L2.val){
            L1.next=mergeList2(L1.next,L2);
            return L1;
        }
        else {
            L2.next=mergeList2(L1,L2.next);
            return L2;
        }
    }




    // 多个有序链表的拼接
    public static ListNode mergeMultipleLists(ListNode[]Lists){
        if(Lists.length==0){
            return null;
        }
        return split2(Lists,0,Lists.length-1);
    }
    public  static ListNode split2(ListNode[] Lists, int i, int j){
        if(i==j)
        {
            return Lists[i];
        }
        int m=(i+j)>>>1;
        ListNode left = split2(Lists, i, m);
        ListNode right = split2(Lists, m + 1, j);
        return mergeList(left,right);    //利用之前的两两合并
    }


    // 查找链表的中间节点
    public static ListNode middleNode(ListNode head){
        ListNode p1=head;
        ListNode p2=head;
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        return p1;
    }

    // 判断链表是否是回纹链表
    public static boolean ifhuiwen (ListNode head){
            ListNode p1=head;
            ListNode p2=head;
            ListNode n1=null;
            ListNode o2;
            while(p2!=null&&p2.next!=null){
                p1=p1.next;
                p2=p2.next.next;
            }
        System.out.println(p1);
      while(p1!=null) {
          o2 = p1.next;
          p1.next = n1;

          n1 = p1;
          p1 = o2;
      }
        System.out.println(n1);
      while(n1!=null){
          if(n1.val!=head.val){
              return false;
          }
          n1=n1.next;
          head=head.next;
      }
      return true;

    }
    public static boolean ifhuiwen2youhua (ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode n1 = null;
        ListNode o1=head;
        while (p2 != null && p2.next != null) {
            p1=p1.next;
            p2 = p2.next.next;


            o1.next = n1;
            n1 = o1;
            o1 = p1;

        }
        //这里如果是奇数个会有问题
        if(p2!=null)
        {
            p1=p1.next;
        }
        while (n1 != null) {

            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }



    /*判断链表是否有环(弗洛伊德龟兔算法） 如果有就返回环的入口
    核心思想：1. 从head出发，龟每次走一步，兔子每次走两步，如果相遇了就是有环
            2.从相遇的点出发，将龟放回head，龟兔每次都走一步，再次相遇就是环的起点（注意首位相连的情况）*/
    public static ListNode ifhuan(ListNode head){
        ListNode gui=head;
        ListNode tu=head;
        while(tu!=null&&tu.next!=null){
            gui=gui.next;
            tu=tu.next.next;
            if(gui==tu){
                gui=head;
                while(gui!=tu){
                    gui=gui.next;
                    tu=tu.next;
                }
                return gui;
            }

        }

        return null;
    }
    public static void main(String[] args) {


        ListNode o11=new ListNode(100,null);
        ListNode o10 = new ListNode(10, o11);
        ListNode o9 = new ListNode(5, o10);
        ListNode o8 = new ListNode(3, o9);
        ListNode o7 = new ListNode(2, o8);
        ListNode o6 = new ListNode(1, o7);
        ListNode o5 = new ListNode(1, o6);
        ListNode o4 = new ListNode(2, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        o11.next=o1;



        //System.out.println(o1);
        //ListNode[]lists={o1,o6,o11};
        System.out.println(ifhuan(o1).val);

    }
}