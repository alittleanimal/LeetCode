package collection;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> {
    private transient E[] elementData;

    private int size;

    public MyArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);

        this.elementData = new E[initialCapacity];
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(Collection<Object> c) {
        elementData = (E[])c.toArray();
        size = elementData.length;
        if (elementData.getClass() != Object[].class)
            elementData = (E[])Arrays.copyOf(elementData, size, Object[].class);
    }


    public E set(int index, E element) {
        rangeCheck(index);

        E OldValue = (E) elementData[index];
        elementData[index] = element;
        return OldValue;
    }

    private void rangeCheck(int requestIndex) {
        if (requestIndex<0 || requestIndex > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
