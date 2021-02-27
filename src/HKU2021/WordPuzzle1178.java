package HKU2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1178. Number of Valid Words for Each Puzzle
 */
public class WordPuzzle1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> returnList = new ArrayList<>();
        for (String puzzle : puzzles) {
            int count = 0;
            for (String word : words) {
                if (checkPuzzle(word, puzzle))
                    count++;
            }
            returnList.add(count);
        }
        return returnList;
    }

    private boolean checkPuzzle(String words, String puzzle) {
        if (!words.contains(String.valueOf(puzzle.charAt(0)))) {
            return false;
        }

        String[] split = words.split("");
        for (String s : split) {
            if (!puzzle.contains(s))
                return false;
        }
        return true;
    }

    @Test
    public void test1178() {
//        System.out.println(findNumOfValidWords(new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
//                new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}));
        System.out.println(1 << 6);
    }

    public List<Integer> findNumOfValidWordsBetterSol(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (String word: words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                mask |= (1 << (word.charAt(i) - 'a'));
            }

            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (String puzzle: puzzles) {
            int total = 0;

            for (int choose = 0; choose < (1 << 6); choose++) {
                int mask = 0;
                for (int i = 0; i < 6; i++) {
                    if ((choose & (1 << i)) != 0){
                        mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
                    }
                }
                mask |= (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(mask)) {
                    total += frequency.get(mask);
                }
            }

            ans.add(total);
        }
        return ans;
    }
}
