import java.util.NoSuchElementException;
/**
 * @author Nabaa Khan
 * A class implementing a linked list
 */
public class HTLinkedList{
  
  /** The first node of the linked list */
  private HTNode firstNode;
  
  /** Creates an empty linked list */
  public HTLinkedList(){
    firstNode = null;
  }
  
  /** Retrieve the first node of the list */
  protected HTNode getFirstNode(){
    return firstNode;
  }
  
  /** Change the first node of the list */
  protected void setFirstNode(HTNode node){
    firstNode = node;
  }
  
  /** 
   * Checks if the list is empty
   * @return whether list is empty or not
   */
  public boolean isEmpty(){
    return getFirstNode() == null;
  }
  
  /**
   * Adds node to the list 
   * @param node to be added to list
   */
  public void add(HTNode node){
    //if list is empty, first node in list will be added node 
    if(isEmpty()){
      firstNode = node;
    }
    //otherwise, create a pointer
    else{
      HTNode pointer = getFirstNode();
      //iterates through list as long as node's next is not null
      while(pointer.getNext() != null){
        //increment pointer
        pointer = pointer.getNext();
      }
      //set the pointer's next to be added node
      pointer.setNext(node);
    }
  }
  
  /*
   * Converts linked list to String format
   * @return String version of list
   */
  @Override
  public String toString(){
    //initializes String result
    String result = "";
    //saves current node, which is set to start at the first node of list
    HTNode current = getFirstNode();
    //iterates through list as long as current is not null
    while(current != null){
      //for every iteration, retrieve node's key and frequency from list and add it to String result
      result += (current.getKey() + ", " + current.getFrequency());
      //if current's next is not null, add a semicolon after each node's key-frequency pair to String result
      if(current.getNext() != null){
        result += "; ";
      }
      //increment current
      current = current.getNext();
    }
    //returns the String version of linked list
    return "List: " + result;
  }
}