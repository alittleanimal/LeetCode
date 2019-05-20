package collection.MyHashSet;

import java.util.Iterator;

public class MySetTest {
    public static void main(String[] args) {
        MySet mySet = new MyHashSet();
        mySet.add(1);
        mySet.add(2);
        mySet.add(5);
        mySet.add(null);

        System.out.println(mySet.size());
        mySet.add(2);
        Iterator iterator = mySet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
