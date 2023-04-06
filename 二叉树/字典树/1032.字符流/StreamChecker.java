// ����1032 �ַ���

public class StreamChecker {
    Trie trie;
    StringBuilder builder;
    public StreamChecker(String[] words) {
        trie = new Trie(words);
        builder = new StringBuilder();
    }   
    
    public boolean query(char letter) {
        builder.append(letter);
        return trie.query(builder);
    }
}

