// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

import java.io.*;
import java.util.*;
/**
 * BinarySearchTree class inherits from Comparable, BinaryTree. It basically insert data into
 * BinarySearchTree, traverse in ascending order
 * @author  Hussein Suleman
 * @see reference kukuruku.co/post/avl-trees/
 */

public class AVLTree<String extends Comparable<? super String>> extends BinaryTree<String>
{
  /**This method takes in one parameter of type BinaryTreeNode, calculates height
   *@param node  this parameter is of type BinaryTreeNode
   *@return -1 if node is null
   */
   public int height ( BinaryTreeNode<String> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   /**This method takes in one parameter of type BinaryTreeNode, checks if AVL conditions
    * are met
    *@param node  this parameter is of type BinaryTreeNode
    *@return  difference in height of left and right subtrees
    */
   public int balanceFactor ( BinaryTreeNode<String> node )
   {
      return height (node.right) - height (node.left);
   }
   /**This method takes in one parameter of type BinaryTreeNode, fixes height
    *@param node  this parameter is of type BinaryTreeNode
    */
   public void fixHeight ( BinaryTreeNode<String> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }

   /**This method takes in one parameter of type BinaryTreeNode, rotates Tree to
    * the right
    *@param p  this parameter is of type BinaryTreeNode
    *@return left node
    */

   public BinaryTreeNode<String> rotateRight ( BinaryTreeNode<String> p )
   {
      BinaryTreeNode<String> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }
   /**This method takes in one parameter of type BinaryTreeNode, rotates Tree to
    * the left
    *@param q  this parameter is of type BinaryTreeNode
    *@return right node
    */


   public BinaryTreeNode<String> rotateLeft ( BinaryTreeNode<String> q )
   {
      BinaryTreeNode<String> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   /**This method takes in one parameter of type BinaryTreeNode, balances the
    * tree
    *@param p  this parameter  of type BinaryTreeNode
    *@return rotated tree if there is an imbalance on the left
    *@return rotated tree if there is an imbalance on the right
    *@return node
    */


   public BinaryTreeNode<String> balance ( BinaryTreeNode<String> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   /**This method takes in two parameters of type String, insert to tree
    *@param k  this parameter is of type String, takes in key
    *@param d  this parameter is of type String takes in data item
    */

   public void insert ( String k, String d )
   {
      root = insert (k, d, root);
   }

   /**This method takes in 3 parameters of type String and BinaryTreeNode,insert
    * to tree
    *@param k this parameter of type String takes in the key
    *@param d this parameter of type String takes in the whole data set
    *@param node this parameter of type String takes in the node
    *@return new BinaryTreeNode if node is null
    *@return balanced node
    */
   public BinaryTreeNode<String> insert (String k, String d, BinaryTreeNode<String> node )
   {
      if (node == null)
         return new BinaryTreeNode<String> (k,d, null, null);
      if (k.compareTo (node.key) <= 0)
         node.left = insert (k,d, node.left);
      else
         node.right = insert (k,d, node.right);
      return balance (node);
   }


   /**This method takes in one parameter of type String, finds element
    *@param k this parameter of type String takes in the key
    *@return key and root
    */
   public BinaryTreeNode<String> find ( String k )
   {
      if (root == null)
         return null;
      else
         return find (k, root);
   }

   /**This method takes in two parameter of types String and traverse through the tree, finds
    * element
    * to find a specified entry according to key
    *@param k this parameter of type String takes in the key
    *@param node this parameter of type String takes in the node
    *@return data on the specified node
    *@return specific node, either left or right
    */

   public BinaryTreeNode<String> find ( String k, BinaryTreeNode<String> node )
   {
      if (k.compareTo (node.key) == 0)
         return node;
      else if (k.compareTo (node.key) < 0)
         return (node.left == null) ? null : find (k, node.left);
      else
         return (node.right == null) ? null : find (k, node.right);
   }

   public void treeOrder()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode<String> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
   /**This method takes in two parameters of type String and BinaryTreeNode
    *@param k this parameter of type BinaryTreeNode takes in the key
    *@param d this parameter is of type String, takes in the whole line data set
    *@return key, data root, removed
    */
   public void delete ( BinaryTreeNode<String> k, String d )
   {
      root = delete (k,d, root);
   }
   /**This method takes in 3 parameters of types String and BinaryTreeNode, perfoms a deletion of a
    * a specified element
    * to find a specified entry according to key
    *@param k this parameter of type BinaryTreeNode takes in the key
    *@param node this parameter of type BinaryTreeNode takes in the node
    *@param d this parameter is of type String, takes in the whole line data set
    *@return left node if right node is null
    *@return balanced minimum value
    *@return balanced node
    */
   public BinaryTreeNode<String> delete (BinaryTreeNode<String> k, String d, BinaryTreeNode<String> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (k,d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (k,d, node.right);
      else
      {
         BinaryTreeNode<String> q = node.left;
         BinaryTreeNode<String> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<String> min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }
   public BinaryTreeNode<String> findMin ( BinaryTreeNode<String> node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode<String> removeMin ( BinaryTreeNode<String> node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

}
