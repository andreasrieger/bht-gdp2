package ale.meinearraylist;

import java.util.Arrays;
import java.util.Comparator;

/**
 * a very simplified version of java.util.ArrayList
 * 
 * @author: Andreas Rieger
 *
 * @param <E>
 */

public class MeineArrayList<E> {
	private E[] list;
	private int size;
	private int capacity;
	private int increment;

	/**
	 * constructs a MeineArrayList-Object with initial capacity c and increment inc
	 * 
	 * @param c   the initial capacity
	 * @param inc the number of positions that will be added when the list is made
	 *            bigger
	 */
	public MeineArrayList(int c, int inc) {
		capacity = c;
		list = (E[]) new Object[c];
		size = 0;
		increment = inc;
	}

	/**
	 * Method to add an element to array
	 * 
	 * @param e
	 */
	public void addEntry(E e) {
		if (size >= capacity) {
			expandList();
		}
		list[size++] = e;
	}

	/**
	 * Method to remove an element from array
	 * 
	 * @param e
	 */
	public void removeEntry(E e) {
		for (int i = 0; i < size; i++)
			if (list[i] == e)
				list[i] = null;
		Arrays.sort(list, new ListElementComparator());
	}

	/**
	 * Method to remove all elements from array (clean array)
	 */
	public void removeAllEntries() {
		for (E elem : list)
			elem = null;
	}

	/**
	 * Method to expand the array for more space
	 */
	private void expandList() {
		capacity += increment;
		E[] list2 = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			list2[i] = list[i];
		}
		list = list2;
	}

	/**
	 * Method to evaluate the array size
	 * 
	 * @return number of elements that are not null
	 */
	public int size() {
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null)
				size = size++; // alternative: size = i + 1;
		}
		return size;
	}

	@Override
	public String toString() {
		// TODO: rework to create a nicer output
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.length; i++) {
			sb.append(list[i]);
		}
		String output = sb.toString();
		return output;
	}

	/**
	 * Method to list all entries of the array
	 * 
	 * @return array with entries
	 */
	public E[] getAllEntries() {
		return this.list;
	}

	/**
	 * Helper class to make elements comparable
	 * 
	 * @author Andreas Rieger
	 *
	 */
	public class ListElementComparator implements Comparator<E> {

		@Override
		public int compare(E o1, E o2) {

			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null) {
				return 1;
			}
			if (o2 == null) {
				return -1;
			}
			return o1.toString().compareTo(o2.toString());
		}
	}
}