/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

 示例:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // 返回 true
 trie.search("app");     // 返回 false
 trie.startsWith("app"); // 返回 true
 trie.insert("app");
 trie.search("app");     // 返回 true

 说明:

 你可以假设所有的输入都是由小写字母 a-z 构成的。
 保证所有输入均为非空字符串。


 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) return;

        char[] wordChars = word.toCharArray();
        TrieNode node = root;
        for (char wordChar: wordChars) {
            if (node.next[wordChar-'a'] == null) {
                node.next[wordChar-'a'] = new TrieNode();
            }
            node = node.next[wordChar-'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean startsWith(String word) {
        if (word==null) return false;
        TrieNode node = root;
        char[] wordChars = word.toCharArray();
        for (char wordChar: wordChars){
            if (node.next[wordChar-'a'] == null) return false;
            node = node.next[wordChar-'a'];
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean search(String prefix) {
        if (prefix==null) return false;
        TrieNode node = root;
        char[] wordChars = prefix.toCharArray();
        for (char wordChar: wordChars){
            if (node.next[wordChar-'a'] == null) return false;
            node = node.next[wordChar-'a'];
        }

        return node.isWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
//        trie.search("apple");   // 返回 true
//        trie.search("app");     // 返回 false
//        trie.startsWith("app"); // 返回 true
//        trie.insert("app");
//        trie.search("app");

        System.out.println(trie.search("app"));
    }
}

class TrieNode {
    public TrieNode[] next;
    public boolean isWord;

    public TrieNode() {
        next = new TrieNode[26];
        isWord = false;
    }
}
