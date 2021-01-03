package Collection.MyHashSet;

import java.util.Iterator;

public interface MySet<E> {

    boolean add(E e);
    boolean remove(E e);
    boolean contains(Object o);
    int size();
    boolean isEmpty();
    Iterator<E> iterator();
}
