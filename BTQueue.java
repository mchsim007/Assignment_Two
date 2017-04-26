// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BTQueue<String>
{
   BTQueueNode<String> head;
   BTQueueNode<String> tail;

   public BTQueue ()
   {
      head = null;
      tail = null;
   }

   public BinaryTreeNode<String> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<String> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }

   public void enQueue ( BinaryTreeNode<String> node )
   {
      if (tail == null)
      {
         tail = new BTQueueNode<String> (node, null);
         head = tail;
      }
      else
      {
         tail.next = new BTQueueNode<String> (node, null);
         tail = tail.next;
      }
   }
}
