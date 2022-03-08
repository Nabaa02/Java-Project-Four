/**
 * @author Nabaa Khan
 * A testing class for ProjectFour class
 */
public class TestProjectFour{
  
  public static void main(String[] args){
    //create a String 
    String justinBieber = "All around the world, they no different than us, all around the world";
    //create a table with size 100
    ProjectFour pf = new ProjectFour(100);
    //call word count on the String justinBieber
    pf.wordCount(justinBieber);
  }
}