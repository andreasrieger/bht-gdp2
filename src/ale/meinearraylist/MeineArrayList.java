package ale.meinearraylist;

/**
 * a very simplified version of java.util.ArrayList 
 *
 * @param <E>
 */

public class MeineArrayList<E> {
	 private E[] list;
	 private int size;
	 private int capacity;
	 private int increment;
	 
/**
 * constructs a MeineArrayList-Object with initial capacity c
 * and increment inc
 * @param c the initial capacity
 * @param inc the number of positions that will be added
 * when the list is made bigger
 */
      public MeineArrayList(int c, int inc) {
         capacity = c;
         list = (E[]) new Object[c];
         size = 0;
         increment = inc;
      }
      
      public void addEntry(String foo) {

      }
      
      public void removeEntry() {
    	  
      }
      
      public void removeAllEntries() {
    	  
      }
      
      public int size() {
    	  return 0;
      }
}