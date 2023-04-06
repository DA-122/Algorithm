public class Main {
    public static void main(String[] args){
        String[] words = {"ab","ba","aaab","baa"};
        StreamChecker checker = new StreamChecker(words);
        System.out.println(checker.query('a'));
        checker.query('a');
        checker.query('a');
        checker.query('a');
        checker.query('a');
        checker.query('b');
        checker.query('a');
        checker.query('b');

    }
}
