class TreeNode(object):

     def __init__(self, val=0, left=None, right=None):

         self.val = val

         self.left = left

         self.right = right

     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
       if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
       elif p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
       else:
            return root
            