import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class inLevel
{
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> tree = new ArrayList<>();

        if(root == null)
        {
            return tree;
        }

        Queue<TreeNode> holder = new LinkedList<>();
        holder.add(root);

        while(!holder.isEmpty())
        {
            int size = holder.size();
            List<Integer> levels = new LinkedList<Integer>();

            for(int i = 0; i < size; i++)
            {
                TreeNode current = holder.remove();
                levels.add(current.val);

                if(current.left != null)
                {
                    holder.add(current.left);
                }
                if(current.right != null)
                {
                    holder.add(current.right);
                }
            }

            tree.add(levels);
        }

    return tree;   
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(4);
        TreeNode three = root.left = new TreeNode(3);
        TreeNode eight = root.right = new TreeNode(8);
        TreeNode one = root.left.left = new TreeNode(1);
        TreeNode five = root.right.left = new TreeNode(5);
        TreeNode nine = root.right.right = new TreeNode(9);

        List<List<Integer>> holder = levelOrder(root);

        
        for(List<Integer> level : holder)
        {
                System.out.println(level);
        }
    }
}