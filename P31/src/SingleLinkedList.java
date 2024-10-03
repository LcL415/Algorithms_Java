import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SingleLinkedList implements Iterable<Integer>{
    private Node head=null;

    private class Node{
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        /*public void addFirst(int value){
           head=new Node(value,null);
        }*/

    }
    public void add(int value){
        head= new Node(value,head);
    }

    public void loop(Consumer<Integer>consumer){
        Node p=head;
        while(p!=null){
            consumer.accept(p.value);
            p=p.next;
        }
    }
    public void loop2(Consumer<Integer>consumer){
        for(Node p=head;p!=null;p=p.next){
            consumer.accept(p.value);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p=head;
            @Override

            public boolean hasNext() {
                return p!=null;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p=p.next;
                return value;
            }
        };
    }
    public Node findIndex(int index){
        int i=0;
        for(Node p=head;p!=null; p=p.next,i++){
            if(i==index){
                return p;
            }

        }
        System.out.println(String.format("Invalide Index[%d]",index));
        return null;
    }
    public void insert(Node a,int value){
        if (a==null){
            add(value);
        }
        a.next=new Node(value,a.next);
    }
    public static int find(int[]a,int value){
        return f(a,value,0,a.length-1);
    }
    private static int f(int []a, int value,int x,int y){
        if(x>y)
        {
            return -1;
        }
        int m=(x+y)>>>1;
        if(a[m]<value){
            return f(a,value,m+1,y);
        }
        else if(value<a[m]){
           return f(a,value,x,m-1);
        }
        else{
            return m;
        }

    }//IntStream stream=IntStream.of(this.value);

}
