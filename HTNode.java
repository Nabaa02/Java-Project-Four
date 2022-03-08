/**
 * @author Nabaa Khan
 * A class implementing a node in a linked list
 */
public class HTNode{
  
  /** The key (String) */
  private String key;
  
  /** The frequency of the key */
  private int frequency = 1;
  
  /** The next node */
  private HTNode next;
  
  /** Creates a node 
    * @param key is the String 
    * @param frequency is the key's frequency in the list
    */
  public HTNode(String key, int frequency){
    this.key = key;
    this.frequency = frequency;
  }
  
  /** Retrieve the node's key */
  public String getKey(){
    return key;
  }
  
  /** Update the key's frequency */
  public void updateFrequency(int increment){
    int updatedFrequency = getFrequency() + increment;
    this.frequency = updatedFrequency;
  }
  
  /** Retrieve key's frequency */
  public int getFrequency(){
    return frequency;
  }
  
  /** Set next node */
  public void setNext(HTNode next){
    this.next = next;
  }
  
  /** Retrieve next node */
  public HTNode getNext(){
    return next;
  }
  
  /*
   * Converts node to String format
   * @return String version of node
   */
  @Override
  public String toString(){
    //create a StringBuilder 
    StringBuilder sb = new StringBuilder(); 
    //add node's key and frequency to StringBuilder
    sb.append("Node: " + getKey() + " + " + "Frequency: " + getFrequency());
    //return String version of StringBuilder
    return sb.toString();
  } 
}