/*
 * Grundlagen der Programmierung II
 * Lerneinheit: Listen (LST)
 */
package lst;

import java.util.Stack;


/**
 * @author andreas
 *
 */
public class StackTest {

	private static String[] buecher = {"Maennerspagat", 
			"Never split the difference", "Die Kunst des klaren Denkens", 
			"Fuer Eile fehlt mir die Zeit", "Monster", "The Big Five For Live"};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Using java.util.Stack<E>
		System.out.println("*** Verwendung der Klasse: java.util.Stack<E> ***\r");
		Stack<String> buecherstapel1 = javaUtilStackTest();
		Stack<String> buecherstapel2 = javaUtilStackTest("A promised land");
		
//		Using ArrayStack<E>
		System.out.println("\r\r*** Verwendung der Klasse: ArrayStack<E> ***\r");
		
//		Array too small
		ArrayStack<String> buecherstapel3 = arrayStackTest(5);
//		Array large enough
		ArrayStack<String> buecherstapel4 = arrayStackTest(6);
//		Array large enough. Adding new book.
		ArrayStack<String> buecherstapel5 = arrayStackTest(6, "A promised land");
		
		
//		Using ListStack<E>
		System.out.println("\r\r*** Verwendung der Klasse: ListStack<E> ***\r");
		ListStack<String> buecherstapel6 = listStackTest();
		ListStack<String> buecherstapel7 = listStackTest("A promised land");
	
	}
	
	/*
	 * Method to test java.util.Stack<E> methods
	 */
	public static java.util.Stack<String> javaUtilStackTest(){
		Stack<String> stack = new java.util.Stack<String>();
		for (String buch : buecher)
			stack.push(buch);
		String stackDisplay = stripBrackets(stack);
		System.out.println("\r--");
		System.out.println("Dieser Stapel enthaelt " + buecher.length + " Buecher: "  + stackDisplay);
		System.out.println("Das neueste Buch ist: \"" + stack.peek() + "\".");
		return stack;
	}
	
	public static java.util.Stack<String> javaUtilStackTest(String newBook){
		Stack<String> stack = javaUtilStackTest();
		System.out.println("\rNeues Buch hinzufuegen: \"" + newBook + "\".");
		stack.push(newBook);
		int newLength = buecher.length + 1;
		String stackDisplay = stripBrackets(stack);
		System.out.println("Dieser Stapel enthaelt jetzt " + newLength + " Buecher: "  + stackDisplay);
		System.out.println("Das neueste Buch ist: \"" + stack.peek() + "\".");
		return stack;
	}

	
	/*
	 * Method to test ArrayStack<E> methods
	 */
	public static ArrayStack<String> arrayStackTest(int elements) {
		ArrayStack<String> stack = new ArrayStack<String>(elements);
		System.out.println("\r--");
		System.out.println("Ein Stapel mit " + elements + " Elementen wurde erstellt.");
		if (stack.full()) {
			System.out.println("Der Stapel ist bereits voll!");
		} else {
			System.out.println("Der Stapel ist leer. " + buecher.length + " Buecher werden auf den Stapel gelegt.");
			try {
				for (String buch : buecher)
					stack.push(buch);
			} catch (FullStackException e) {
				e.printStackTrace();
				int difference = buecher.length - elements;
				System.out.println("Mindestens " + difference + " Buch konnte nicht hinzugefuegt werden.");
			}
		}
		String stackDisplay = stripBrackets(stack);
		System.out.println("Der Stapel enthaelt jetzt " + elements + " Buecher: " + stackDisplay);
		return stack;
	}
	


	public static ArrayStack<String> arrayStackTest(int elements, String newBook) {
		ArrayStack<String> stack = arrayStackTest(elements);
		System.out.println("\rNeues Buch hinzufuegen: \"" + newBook + "\".");
		if (stack.full()) {
			System.out.println("Der Stapel ist voll, das letzte Buch wird ausgetauscht.");
			String removed = null;
			try {
				removed = stack.pop();
			} catch (EmptyStackException e) {
				e.printStackTrace();
			}
			try {
				stack.push(newBook);
			} catch (FullStackException e) {
				e.printStackTrace();
			}
			System.out.println("Das Buch \"" + removed + "\" wurde gegen \"" + newBook + "\" ausgetauscht.");
		}
		String stackDisplay = stripBrackets(stack);
		System.out.println("Der Stapel enthaelt jetzt " + elements + " Buecher: " + stackDisplay);
		return stack;
	}
	
	
	/*
	 * Method to test ListStack<E> methods
	 */
	public static ListStack<String> listStackTest(){
		ListStack<String> stack = new ListStack<String>();
		for (String buch : buecher)
			stack.push(buch);
		System.out.println("\r--");
		System.out.println("Ein Stapel mit " + buecher.length + " Elementen wurde erstellt.");
		String stackDisplay = stripBrackets(stack);
		System.out.println("Dieser Stapel enthaelt " + buecher.length + " Buecher: "  + stackDisplay);
		return stack;
	}
	
	public static ListStack<String> listStackTest(String newBook){
		ListStack<String> stack = listStackTest();
		System.out.println("\rNeues Buch hinzufuegen: \"" + newBook + "\".");
		stack.push(newBook);
		String stackDisplay = stripBrackets(stack);
		System.out.println("Dieser Stapel enthaelt jetzt " + buecher.length + " Buecher: "  + stackDisplay);
		return stack;
	}
	
	
	/*
	 * Helper methods to format the stack
	 */
	public static String stripBrackets(Stack<String> stack) {
		String stackDisplay = stack.toString();
		stackDisplay = stackDisplay.substring(1, stackDisplay.length() - 1);
		return stackDisplay;
	}
	
	private static String stripBrackets(ArrayStack<String> stack) {
		String stackDisplay = stack.toString();
		stackDisplay = stackDisplay.substring(1, stackDisplay.length() - 1);
		return stackDisplay;
	}
	
	private static String stripBrackets(ListStack<String> stack) {
		String stackDisplay = stack.toString();
		stackDisplay = stackDisplay.substring(1, stackDisplay.length() - 1);
		return stackDisplay;
	}

}
