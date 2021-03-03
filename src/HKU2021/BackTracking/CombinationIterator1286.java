package HKU2021.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationIterator1286 {
    private String characters;
    private int combinationLength;
    private LinkedList<Character[]> combinations;

    public CombinationIterator1286(String characters, int combinationLength) {
        this.characters = characters;
        this.combinationLength = combinationLength;
        combinations = new LinkedList<>();
        findCombination(new ArrayList<>(), 0);
    }

    public String next() {
        Character[] res = combinations.removeFirst();
        return Arrays.stream(res).map(String:: valueOf).collect(Collectors.joining());
    }

    public boolean hasNext() {
        return combinations.size() != 0;
    }

    private void findCombination(List<Character> record, int start) {
        if (record.size() == combinationLength) {
            combinations.add(record.toArray(new Character[combinationLength]));
            return;
        }

        for (int i = start; i < characters.length(); i++) {
            record.add(characters.charAt(i));
            findCombination(record, i + 1);
            record.remove(record.size() - 1);

        }
    }

    public static void main(String[] args) {
        CombinationIterator1286 ci = new CombinationIterator1286("abc", 2);
        System.out.println(ci.next());
    }
}
