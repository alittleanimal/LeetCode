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

        this.elementData = (E[]) new Object[initialCapacity];
        this.size = 0;
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

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    public void add(int index, E element) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index+1, size - index);
        elementData[index] = element;
        size++;
    }

    public void addAll(int index, Collection<? extends E> c) {
        rangeCheck(index);

        E[] newEs = (E[])c.toArray();
        int newLength = newEs.length;
        
        ensureCapacity(size + newLength + 1);
        int move = size - index;

        if (move > 0) {
            System.arraycopy(elementData, index, elementData, index+newLength, move);
        }

        System.arraycopy(newEs, 0, elementData, index, newLength);
        size+=newLength;
    }

    public void addAll (Collection<? extends E> c) {
        this.addAll(size, c);
    }

    private void rangeCheck(int requestIndex) {
        if (requestIndex<0 || requestIndex > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity (int newCapacity) {
        int curr = elementData.length;
        if (newCapacity > curr) {
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }
}
