public class Trie {
    private Trie[] child;
    private boolean isEnd;
    public Trie(){
        this.child = new Trie[26];
        this.isEnd = false;
    }
    public Trie(String[] words){
        this.child = new Trie[26];
        this.isEnd = false;
        for(String str: words){
            Trie node = this;
            for(int i = str.length()-1; i >= 0; i--){
                int alpha = str.charAt(i)-'a';
                if(node.child[alpha] == null){
                    node.child[alpha] = new Trie();
                }
                node = node.child[alpha];
            }
            node.isEnd = true;
        }
    }
    public boolean query(StringBuilder q){
        Trie node = this;
        for(int i = q.length()-1;i>=0; i--){
            int alpha = q.charAt(i) - 'a';
            if(node.child[alpha] ==null){
                return false;
            }
            node = node.child[alpha];
            if(node.isEnd){
                return true;
            }
        }
        return false;
    }
}
