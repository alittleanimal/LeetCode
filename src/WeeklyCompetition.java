import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WeeklyCompetition {

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> resultList = new ArrayList<>();
        StringBuilder tempBuilder = new StringBuilder();
        String pattern = "(0|1(10)*(0|11)(01*01|01*00(10)*(0|11))*1)*";
        for (int a : A) {
            tempBuilder.append(a);
            if (Pattern.matches(pattern, tempBuilder)) {
                resultList.add(true);
            } else {
                resultList.add(false);
            }
        }
        return resultList;
    }


    public int[] nextLargerNodes(ListNode head) {
        List<Integer> resultList = new ArrayList<>();
        int max = -1;
        while (head.next != null) {
            max = findMax(head.val, head.next);
            resultList.add(max);
        }
        int[] result = new int[resultList.size()];

        for (int i=0; i<resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public int findMax(int now, ListNode nextNode) {
        if (nextNode.val > now) {
            return nextNode.val;
        } else {
            if (nextNode.next != null) {
                findMax(now, nextNode.next);
            } else return 0;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] test = {0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(prefixesDivBy5(test));
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

