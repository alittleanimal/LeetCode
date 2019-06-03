package Preparation;

import java.util.ArrayList;
import java.util.List;

public class LongestSubString {
//    public int longestSubstring(String s, int k) {
//        int count = 1;
//        char[] charArray = s.toCharArray();
//        char recordChar = charArray[0];
//        for (int i = 1; i<charArray.length; i++) {
//            if (charArray[i] == recordChar) {
//                count++;
//            } else {
//                count--;
//                if (count < 0) {
//                    count = 0;
//
//                }
//            }
//        }
//    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        if (!wordList.contains(endWord)) {
            return 0;
        }
        return findWords(beginWord,endWord,wordList,count);
    }

    public int findWords(String beginWord, String endWord, List<String> wordList, int count) {
        List<String> copyList = new ArrayList<>(wordList);
        for (String word: wordList) {
            if (isOneCharChange(beginWord, word)) {
                count++;
                if (word.equals(endWord)) {
                    return count;
                }
                copyList.remove(word);
                int res = findWords(word, endWord, copyList, count);
                count--;
                if (res != 0) {
                    return res;
                }
            }
        }
        return 0;
    }

    private boolean isOneCharChange(String start, String target) {
        int count = 0;
        for (int i=0; i<start.length(); i++) {
            if (start.charAt(i) == target.charAt(i)){
                count++;
            }
        }
        return count == start.length()-1;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        LongestSubString longestSubString = new LongestSubString();
        System.out.println(longestSubString.ladderLength("hit", "cog", wordList));

    }
}
