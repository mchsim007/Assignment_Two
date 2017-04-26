import java.io.*;
import java.util.*;
import java.time.*;

/**This SearchAVL class extends AVLTree and perfoms insert,search,delete
  *and print the output
 *@author Simphiwe Mchunu
 */


public class SearchAVL extends AVLTree<String>{
  /**
   *
   *
   *This InsertToTree() static method allows the insertion of data into the AVLTree from a certain filename
   * it reads each line of the file until there are no items left
   *
   *
   *@return avlt, returns BinarySearchTree with data loaded
   * @see IOException
   *
   */
  public static AVLTree<String> InsertToTree(){
    AVLTree<String> avlt = new AVLTree<String>();
    try{
      Scanner filename = new Scanner(new FileInputStream("testdata"));
      //String lineOne = "";
      while(filename.hasNextLine()){
        String lineOne = filename.nextLine();
        String fullname = lineOne.substring((lineOne.lastIndexOf("|"))+1);
        avlt.insert(fullname,lineOne); //..need to be modified
        //System.out.println(fullname);
    }
      filename.close();
    }
    catch(IOException e){
      System.out.println(e.getLocalizedMessage());
    }
    return avlt;
  }

  /**
    *This searchTree static method allows the searching of data from the AVLTree
    *and compare similar entries
    * it reads each line of the queryfile until there are no items left
    * @see IOException
    *@see NoSuchElementException
    *
    */
  public static void searchTree(){
    try{
      InsertToTree();
      Scanner file = new Scanner(new FileInputStream("file20"));
      String line2 = "";

      while(file.hasNextLine()){
        line2 = file.nextLine();
        BinaryTreeNode<String> mydata = InsertToTree().find(line2);
        if((InsertToTree().find(line2))!=null){
          String p = mydata.data;
          //String s = InsertToTree().find(line2);
          //BinaryTreeNode<String> s = InsertToTree().find(line2);
          System.out.println(p);
          //InsertToTree().delete(InsertToTree().find(line2),p);
          //System.out.println("Done");
          //InsertToTree().delete(mydata.data,line2);
          //System.out.println("Done");
        }
        //else{break;}
        else{
          System.out.println("Not found");
        }
      }

    }
    catch(IOException e){
      System.out.println(e.getLocalizedMessage());
    }
    catch(NoSuchElementException b){
      System.out.println(b.getLocalizedMessage());
    }
  }
  /**This is the main method which prints out the output
		*@param args Unused
	 */
  public static void main(String args[])
{
    Instant start = Instant.now();
    searchTree();
    //InsertToTree();
    Instant end = Instant.now();
    Duration time_taken = Duration.between(start,end);
    System.out.println("Time taken: "+time_taken.toMillis()+" milliseconds");
  }


}
