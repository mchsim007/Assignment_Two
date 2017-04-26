// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<String>
{
   String data;
   BinaryTreeNode<String> left;
   BinaryTreeNode<String> right;
   int height;
   String key;

   public BinaryTreeNode ( String key, String d, BinaryTreeNode<String> l, BinaryTreeNode<String> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
      this.key = key;
   }

   BinaryTreeNode<String> getLeft () { return left; }
   BinaryTreeNode<String> getRight () { return right; }
}
