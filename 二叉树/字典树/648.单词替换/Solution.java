// 648 µ¥´ÊÌæ»»
// 


public class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for(String prefix: dictionary){
            set.add(prefix);
        }
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = 0; j < word.length(); j++){
                if(set.contains(word.substring(0,1+j))){
                    words[i] = word.substring(0,1+j);
                    break;
                }
            }
        }
        return String.join(" ",words);
    }
    public String replaceWords2(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for(String str: dictionary){
            Trie cur = root;
            for(char c : str.toCharArray()){
                if(cur.next.containsKey(c)){
                    cur = cur.next.get(c);
                }else{
                    cur.next.put(c,new Trie());
                    cur = cur.next.get(c);
                }
            }
            cur.next.put('#',new Trie());
        }
        String words[] = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            words[i] = findRoot(words[i], root);
        }
        return String.join(" ", words);
    }
    public String findRoot(String word, Trie trie){
        StringBuilder builder = new StringBuilder();
        Trie cur = trie;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            // Ç°×ºÖÕÖ¹
            if(cur.next.containsKey('#')){
                return builder.toString();
            }
            if(cur.next.containsKey(c)){
                builder.append(c);
                cur = cur.next.get(c);
            }else{
                return word;
            }
        }
        return builder.toString();
    }
}

class Trie{
    Map<Character,Trie> next;
    public Trie(){
        next = new HashMap<>();
    }
}