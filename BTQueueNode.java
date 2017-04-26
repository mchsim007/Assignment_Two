// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BTQueueNode<String>
{
   BinaryTreeNode<String> node;
   BTQueueNode<String> next;

   public BTQueueNode ( BinaryTreeNode<String> n, BTQueueNode<String> nxt )
   {
      node = n;
      next = nxt;
   }
}
