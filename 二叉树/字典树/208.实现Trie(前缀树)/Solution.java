// 208. 实现前缀树
// 思路分析: 长度为26定长数组 + 哈希表
// 或者哈希表，通过加入'#'字符来判断是否有前缀 

import java.util.HashSet;
import java.util.Set;

public class Solution{
    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
    }
}
class Trie {
    Node root;
    Set<String> set;
    public Trie() {
        root = new Node();
        set = new HashSet<>();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.next[c-'a'] != null){
                node = node.next[c-'a'];
            }else{
                Node newNode = new Node(c);
                node.next[c-'a'] = newNode;
                node = node.next[c-'a'];
            }
        }
        set.add(word);
    }
    
    public boolean search(String word) {
        return set.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        boolean res = true;
        Node node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.next[c-'a'] != null){
                node = node.next[c-'a'];
            }else{
                res = false;
                break;
            }
        }
        return res;
    }
}


class Node{
    public char alpha;
    public Node [] next;
    public Node(){
        next = new Node[26];
    }
    public Node(char word){
        alpha = word;
        next = new Node[26];
    }
}