
public class Main {
    public static void main(String[] args) {
        SingleLinkedList s = new SingleLinkedList();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        //s.loop2(value -> System.out.println(value));
        s.insert(s.findIndex(1),10);
        for (Integer i : s) {
            System.out.println(i);
        }


        System.out.println("-----------");

        int a[]={1,2,3,4,5};
        System.out.println(s.find(a,1));
        //s.stream.forEach(value-> System.out.println(value));
    }
}
