// implement Trie insert search and prefix search count word having prefix

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean endOfWord;

    TrieNode() {
        children =  new HashMap<>();
        endOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void insert(String st) {
        TrieNode curr = root;
        for(char ch : st.toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.endOfWord = true;
    }

    boolean search(String input) {
        TrieNode curr = root;
        for(char ch : input.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }
        if(curr.endOfWord) {
            return true;
        } else {
            return false;
        }
    }

    boolean startsWith(String input) {
        TrieNode curr = root;
        for(char ch : input.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            curr = curr.children.get(ch);
        }

        return true;
    }

    private int countWordsWithPrefix(String input) {
        TrieNode curr = root;
        for(char ch : input.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                return 0;
            }
            curr = curr.children.get(ch);
        }

        return countWords(curr);
    }

    private int countWords(TrieNode curr) {
        int count = 0;
        if(curr.endOfWord) {
            count++;
        }

        for(TrieNode node: curr.children.values()) {
            count += countWords(node);
        }

        return count;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        trie.insert("dog");
        trie.insert("cart");
        trie.insert("can");

        System.out.println("Search 'cat': " + trie.search("cat")); // true
        System.out.println("Search 'car': " + trie.search("car")); // true
        System.out.println("Search 'dog': " + trie.search("dog")); // true
        System.out.println("Search 'cart': " + trie.search("cart")); // false
        System.out.println("startsWith 'ca': " + trie.startsWith("ca")); // true
        System.out.println("startsWith 'do': " + trie.startsWith("do")); // true
        System.out.println("startsWith 'ze': " + trie.startsWith("ze")); // false

        System.out.println("Words with prefix 'ca': " + trie.countWordsWithPrefix("ca")); // 3 (cat, car, cart)
        System.out.println("Words with prefix 'do': " + trie.countWordsWithPrefix("do")); // 1 (dog)
        System.out.println("Words with prefix 'c': " + trie.countWordsWithPrefix("c")); // 3 (cat, car, cart, can)
        System.out.println("Words with prefix 'z': " + trie.countWordsWithPrefix("z")); // 0
    }
}
