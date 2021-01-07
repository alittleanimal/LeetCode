package HKU2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 830. Positions of Large Groups
 */
public class Large_Group {
    public List<List<Integer>> largeGroupPositions(String s) {
        LinkedList<Integer> recordList = new LinkedList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        char[] charArray = s.toCharArray();
        if (charArray.length < 3) return new LinkedList<>();

        recordList.addLast(0);
        recordList.addLast(0);
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[recordList.peekLast()] != charArray[i]) {
                if (recordList.peekLast() - recordList.peek() > 1) {
                    resultList.add(recordList);
                }
                recordList = new LinkedList<>();
                recordList.addLast(i);
                recordList.addLast(i);
            } else {
                recordList.addLast(recordList.removeLast() + 1);
            }
        }
        if (recordList.peekLast() - recordList.peek() > 1) {
            resultList.add(recordList);
        }
        return resultList;
    }

    /**
     * Add another char to handel the last group
     * Use charAt function in string
     * Create new List after added it
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositionsBetterSol(String s) {

        List<List<Integer>> resultList = new ArrayList<>();
        if (s.length() < 3) return new LinkedList<>();
        s = s + 'A';

        int leftIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                if (i - leftIndex > 2) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(leftIndex);
                    tempList.add(i-1);
                    resultList.add(tempList);
                }
                leftIndex = i;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Large_Group largeGroup = new Large_Group();
        List<List<Integer>> result = largeGroup.largeGroupPositionsBetterSol("abcdddeeeeaabbbcdddd");
        for (List item : result) {
            for (Object i : item) {
                System.out.println(i);
            }
        }
    }
}
