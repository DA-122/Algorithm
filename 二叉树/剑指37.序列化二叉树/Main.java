public class Main{
    public static void main(String[] args){
        Codec solution = new Codec();
        // String s = "[1,3,null,null,4]";
        String s = "[1,3,null,null,4]";
        TreeNode root = solution.deserialize(s);
        String result = solution.serialize(root);
    }
}