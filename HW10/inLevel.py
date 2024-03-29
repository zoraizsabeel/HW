from typing import List, Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def levelOrder(root: Optional[TreeNode]) -> List[List[int]]:
    tree = []
    if root is None:
        return tree
    
    holder = deque()
    holder.append(root)

    while holder:
        size = len(holder)
        levels = []

        for _ in range(size):
            current = holder.popleft()
            levels.append(current.val)

            if current.left:
                holder.append(current.left)
            if current.right:
                holder.append(current.right)

        tree.append(levels)

    return tree

def main():
    root = TreeNode(4)
    root.left = TreeNode(3)
    root.right = TreeNode(8)
    root.left.left = TreeNode(1)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(9)

    holder = levelOrder(root)

    for level in holder:
        print(level)

if __name__ == "__main__":
    main()
