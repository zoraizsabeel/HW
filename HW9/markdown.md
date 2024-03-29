# Approach
  - build binary tree
  - create method for recursively finding Lowest Common Ancestor
  - create method for iteratively finding Lowest Common Ancestor
  - create in java, translate to python (vice versa)
# Recursive method
  - recurse through the given tree in TreeNode Root to find TreeNode p and TreeNode q
  - condition: checks if all params are null --> returns root
  - condition: checks if p and q are less than root --> calls function with root.left instead of root
  - condition: checks if p and q are more than root --> calls functoin with root.right instead of root
  - method returns root if none is met
# iterative:
  - while root is not null
  - condition checks if p and q are less than root --> sets root to left child, checks if (p = root or p = root.left) and (q = root or q = root.right) --> returns root
  - condition checks if p and q are more than root --> sets root to right child, checks if (p = root or p = root.left) and (q = root or q = root.right) --> returns root
  - else: returns root
  - outside of while: (root is null) --> returns root 

