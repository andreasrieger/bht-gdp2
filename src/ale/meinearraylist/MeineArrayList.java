package ale.meinearraylist;

import java.util.Arrays;
import java.util.Comparator;

import aki.firma.Person;
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

	public void addEntry(E elem) {
		if (size >= capacity) {
			expandList();
		}
		list[size++] = elem;
	}

	public void removeEntry(E e) {
		for (int i = 0; i < size; i++)
			if (list[i] == e)
				list[i] = null;
	}

	public void removeAllEntries() {
		for (E elem : list)
			elem = null;
	}

	private void expandList() {
		capacity += increment;
		E[] list2 = (E[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			list2[i] = list[i];
		}
		list = list2;
	}

	public int size() {
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null)
				size = size++; //alternative: size = i + 1;
		}
		return size;
	}

	public String toString() {
		return "Element: ";
	}
	
	public void showAll() {
		for (E all : list)
			System.out.println(all);
	}
	
	public E[] sortArray() {
//	Arrays.sort(list, (o1, o2) -> o1.compareTo(o2));
	Arrays.sort(list, new Comparator<E>() {
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
            return o1.compareTo(o2);
        }});
	}
}