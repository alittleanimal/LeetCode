package Collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
        elementData = (E[]) c.toArray();
        size = elementData.length;
        if (elementData.getClass() != Object[].class)
            elementData = (E[]) Arrays.copyOf(elementData, size, Object[].class);
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
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    public void addAll(int index, Collection<? extends E> c) {
        rangeCheck(index);

        E[] newEs = (E[]) c.toArray();
        int newLength = newEs.length;

        ensureCapacity(size + newLength + 1);
        int move = size - index;

        if (move > 0) {
            System.arraycopy(elementData, index, elementData, index + newLength, move);
        }

        System.arraycopy(newEs, 0, elementData, index, newLength);
        size += newLength;
    }

    public void addAll(Collection<? extends E> c) {
        this.addAll(size, c);
    }

    public E remove(int index) {
        rangeCheck(index);
        E oldElement = elementData[index];

        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size] = null;
        --size;
        return oldElement;
    }

    public boolean remove(E element) {
        boolean index = false;
        for (int i = 0; i < size; i++) {
            if (element.equals(elementData[i])) {
                index = true;
                this.remove(i);
            }
        }
        return index;
    }

    public void removeRange(int start, int end) {
        int move = size - end;
        System.arraycopy(elementData, end, elementData, start, move);

        for (int i = size - 1; i > (size - (end - start) - 1); i--) {
            elementData[i] = null;
        }

        size -= end - start;
    }

    public E get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        System.arraycopy(elementData, 0, array, 0, size);
        return array;
    }

    private void rangeCheck(int requestIndex) {
        if (requestIndex < 0 || requestIndex > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int newCapacity) {
        int curr = elementData.length;
        if (newCapacity > curr) {
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> testMyArrayList = new MyArrayList<Integer>();

        System.out.println(testMyArrayList.size);

        testMyArrayList.add(1);
        testMyArrayList.add(2);
        testMyArrayList.add(3);
        testMyArrayList.add(4);
        testMyArrayList.add(5);

        System.out.println(testMyArrayList.size);
        System.out.println(testMyArrayList.get(2));

        testMyArrayList.removeRange(1, 3);

        System.out.println(testMyArrayList.size);
        System.out.println(testMyArrayList.get(2));
        Set<Integer> newSet = new HashSet<>();

    }
}
