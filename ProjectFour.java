/**
 * @author Nabaa Khan
 * A class implementing a hashtable
 */
public class ProjectFour{
  
  /** The hashtable */
  private HTLinkedList[] table;
  
  /** The table's size */
  private int tableSize;
  
  /** The table's ratio of elements to size */
  private double loadFactor = 0.75;
  
  /** The table's number of elements */
  private int numElements;
  
  /** 
   * Creates a table
   * @param size is the table's size
   */
  public ProjectFour(int size){
    table = new HTLinkedList[size];
    tableSize = size;
  }
  
  /** Retrieve table's size */
  public int getTableSize(){
    return tableSize;
  }
                         
  /**
   * Retrieve node in a specific index's linked list
   * @param key is the key you're searching for
   * @param hashIndex is the key's hash index (calculated using hash function)
   * @return the node in the linked list 
   */
  public HTNode getNode(String key, int hashIndex){
    //create a pointer that starts at the index's linked list's first node
    HTNode pointer = table[hashIndex].getFirstNode();
    //iterate as long as pointer's next is not null
    while(pointer.getNext() != null){
      //if the pointer's key is not null, increment the pointer
      if(!pointer.getKey().equals(key)){
        pointer = pointer.getNext();
      }
    }
    //otherwise, return the pointer
    return pointer;
  }
  
  /**
   * Adds a key to the hashtable
   * @param key is the key you would like to add
   */
  public void insert(String key){
    //create a node with the key (in lowercase) and a default frequency of 1
    HTNode data = new HTNode(key.toLowerCase(), 1);
    //calculate the index to which the key will be mapped
    int hashIndex = Math.abs(key.toLowerCase().hashCode()) % tableSize;
    //if the space is null,
    if(table[hashIndex] == null){
      //create a new linked list at that index
      table[hashIndex] = new HTLinkedList();
      //add the node to that linked list
      table[hashIndex].add(data);
      //increase the number of elements 
      numElements++;
    }
    //otherwise, if the space is not null,
    else if(table[hashIndex] != null){
      //if the pointer's key matches the input key,
      if(getNode(key.toLowerCase(), hashIndex).getKey().equals(key)){
        //increase the pointer's frequency by 1
        getNode(key.toLowerCase(), hashIndex).updateFrequency(1);
      }
      else{
        //otherwise, add the node to the back of the linked list 
        table[hashIndex].add(data);
        //increase the number of elements
        numElements++;
      }
    }
    //if the load factor has been exceeded, re-hash the table 
    if((numElements/tableSize) > loadFactor){
      reHash();
    }
  }
  
  /**
   * Expands table's size if load factor has been exceeded
   */
  public void reHash(){
    //create a variable that stores the original table
    HTLinkedList[] oldTable = table;
    //re-size the original table
    tableSize = oldTable.length * 2;
    //the table will now be updated to a new size (tableSize)
    this.table = new HTLinkedList[tableSize];
    //iterate through the original table
    for(int i = 0; i < oldTable.length; i++){
      //if the element at index i is not null,  
      if(oldTable[i] != null){
        //create a pointer that starts at the index's linked list's first node
        HTNode pointer = oldTable[i].getFirstNode();
        //iterate as long as the pointer is not null
        while(pointer != null){
          //insert the pointer's key
          insert(pointer.getKey());
          //increment the pointer
          pointer = pointer.getNext();
        }
      }
    }
  }
  
  /**
   * Converts table to String format
   * @return String version of table
   */
  public String toString(){
    //initializes String result
    String result = "";
    //iterate through the table
    for(int i = 0; i < table.length; i++){
      //if the element at index i is not null,
      if(table[i] != null){
        //for each iteration, retrieve the linked list and add it to String result
        result += table[i].toString() + "\n";
      }
      else{
        //if the element at index i is null, print null
        result += null + "\n";
      }
    }
    //returns the String version of table
    return result;
  }
  
  /**
   * Prints out all of the words encountered in the input String, along with that word's frequency
   * @param word is the input String 
   */
  public void wordCount(String word){
    //split the input String into list array of Strings
    String[] wordList = word.split("\\P{Alpha}+");
    //iterate through the list array
    for(int i = 0; i < wordList.length; i++){
      //insert the word at index i into table
      insert(wordList[i]);
    }
    //print the table
    System.out.println(toString());
  }
}