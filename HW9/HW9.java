public class HW9
{
//recursive method
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           
        //if only the root exists then return root
        if(p == null || q== null || root == null)
        {
            return root;
        }
       if(p.val > root.val && q.val > root.val)
       {
            return lowestCommonAncestor(root.right, p, q);
       }
       if(p.val < root.val && q.val < root.val)
       {
            return lowestCommonAncestor(root.left, p, q);
       }
       return root;
}
//iterative method
    public static TreeNode lowest(TreeNode root, TreeNode p, TreeNode q)
    {
        while(root != null)
        {
            if(p.val < root.val && q.val < root.val)
            {
                root = root.left;
                if((p.val == root.left.val || p.val == root.val) && (q.val == root.val || q.val == root.right.val))
                {
                    return root;
                }
            }
            else if(p.val > root.val && q.val > root.val)
            {
                root = root.right;
                if((p.val == root.left.val || p.val == root.val) && (q.val == root.val || q.val == root.right.val))
                {
                    return root;
                }
            }
            else 
            {
                return root;
            }
        }
        return root;
    }
    public static void main(String[] args)
    {
       
            // Make the binary tree from canvas
            TreeNode root = new TreeNode(4);
            TreeNode three = root.left = new TreeNode(3);
            TreeNode eight = root.right = new TreeNode(8);
            TreeNode one = root.left.left = new TreeNode(1);
            TreeNode five = root.right.left = new TreeNode(5);
            TreeNode nine = root.right.right = new TreeNode(9);
    
            // Test case: LCA of nodes 1 and 9
            TreeNode lca1 = lowestCommonAncestor(root, one, nine);
            System.out.println("LCA of 1 and 9: " + lca1.val); // Expected output: 4
            // TreeNode test1 = lowest(root, one, nine);
            // System.out.println("LCA iterative: " + test1.val);
    
            // Test case: LCA of nodes 5 and 9
            TreeNode lca2 = lowestCommonAncestor(root, five, nine);
            System.out.println("LCA of 5 and 9: " + lca2.val); // Expected output: 8
    
            // Test case: LCA of nodes 3 and 1
            TreeNode lca3 = lowestCommonAncestor(root, three, one);
            System.out.println("LCA of 3 and 1: " + lca3.val); // Expected output: 3
    
            // Test case: LCA of nodes 1 and 5
            TreeNode lca4 = lowestCommonAncestor(root, one, five);
            System.out.println("LCA of 1 and 5: " + lca4.val); // Expected output: 4
    }   

}