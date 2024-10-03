// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.add(2, 7);
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        /* System.out.println(dynamicArray);*/
        //1. 通过consumer接口来实现遍历
        // dynamicArray.foreach(s-> System.out.println(s));

      /*
     2. 通过Iterator 重写内部类 来实现遍历
            for(Integer element:dynamicArray)
            {
                 System.out.println(element);
                }
*/
        /* 3.通过流里面自带的forEach来遍历数组

        dynamicArray.stream().forEach(s -> System.out.println(s));

         */
        //System.out.println("-------");
       int removed = dynamicArray.removed(2);
        dynamicArray.stream().forEach(s-> System.out.println(s));
    }
}