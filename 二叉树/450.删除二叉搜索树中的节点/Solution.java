public class Solution{
    // 递归法
    public TreeNode deleteNodeRecursion(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else{
            if(root.left == null&& root.right ==null){
                return null;
            }
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            TreeNode node = root.right;
            while(node.left!=null){
                node =node.left;
            }
            node.left = root.left;
            return root.right;
        }
        return root;
    }

    
    // 迭代法
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key){
            TreeNode rightL = root.right;
            if(root.right == null)
                return root.left;
            if(root.left == null)
                return root.right;

            while(rightL.left!=null){
                rightL = rightL.left;
            }
            rightL.left = root.left;
            return root.right;
        }

        TreeNode curNode = root;
        while(true){
            // key在当前节点左子树
            if(curNode.val > key){
                if(curNode.left ==null)
                    break;
                // 左孩子就是key
                if(curNode.left.val == key){
                    TreeNode target = curNode.left;
                    if(target.right == null){
                        curNode.left = target.left;
                    }else{
                        TreeNode rightL = target.right;
                        while(rightL.left!=null){
                            rightL = rightL.left;
                        }
                        rightL.left = target.left;
                        curNode.left = target.right;
                    }
                    break;
                }else{
                    curNode = curNode.left;
                }
            // key在当前节点右子树
            }else{
                if(curNode.right ==null){
                    break;
                }
                if(curNode.right.val == key){
                    TreeNode target = curNode.right;
                    if(target.left == null){
                        curNode.right = target.right;
                    }else{
                        TreeNode leftR = target.left;
                        while(leftR.right!=null){
                            leftR = leftR.right;
                        }
                        leftR.right =target.right;
                        curNode.right = target.left;
                    }
                    break;
                }else{
                    curNode = curNode.right;
                }
            }
        }
        return root;
    }
}