
class TreeNode(object):
     def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    def isBalanced(self, root):
     def getDepth(self,root):
        if(root==None):
         return 0
        return 1+max(getDepth(self,root.left),getDepth(self,root.right))

     if(root==None):
      return True
     if(abs(getDepth(self,root.left)-getDepth(self,root.right)>1)): 
      return False
     return self.isBalanced(root.left) and self.isBalanced(root.right)


