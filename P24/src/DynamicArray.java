import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {
    private int size = 0;
    private int capacity = 8;
    private int[] array = {};

    public void addLast(int element) {

        check();

        array[size] = element;
        size++;

    }

    public void add(int index, int element) {

        check();

        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1,
                    size - index);
            array[index] = element;
            size++;
        }

    }

    private void check() {
        if (size == 0) {
            array = new int[capacity];
        } else {
            capacity += capacity >>> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;

        }
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }

    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];

            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    public int removed(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array,
                    index, size - index - 1);
        }
        size--;
        return array[index];
    }
}
