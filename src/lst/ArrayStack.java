/*
 * Grundlagen der Programmierung II
 * Lerneinheit: Listen (LST)
 */
package lst;



/**
 * Ueberschrift: Implementierung der Stapel-Schnittstelle als Feld (Reihung)
 * Beschreibung:
 * F�r die Implementierung unseres Stapels benutzen wir eine Reihung,
 * in der die Stapelelemente gespeichert werden und einen Zeiger (top),
 * der immer auf das oberste Element des Stapels zeigt.
 * Copyright:     Copyright (c) 2002
 * Organisation: BHT-Berlin (Projektgruppe VFH)
 * @author  M.Esponda  Agathe Merceron Oktober 2007
 * @version 1.0
 */
public class ArrayStack<E> implements Stack<E> {

    // Instanzvariablen
    private int top; // zeigt immer auf das oberste Element des Stapels
    private E[] stack; // hier werden die Stapel Elemente gespeichert

    // Konstruktoren

    /**
     * Ein leerer Stapel mit der Groe�e max. wird erzeugt.
     * 
     * @param max
     *            maximale Anzahl der Elemente im Stapel
     */
    public ArrayStack(int max) {
        top = -1; // Initialwert fuer leeren Stapel
        stack = (E[]) new Object[max];
    }

    /**
     * Ein leerer Stapel mit Platz f�r 100 Objekte wird erzeugt.
     */
    public ArrayStack() {
        this(100); // erster Konstruktur wird aufgerufen
    }

    // Methoden

    /**
     * Ueberprueft, ob der Stapel leer ist.
     * 
     * @return boolean true falls der Stapel leer ist, false sonst
     */
    @Override
    public boolean empty() {
        return (top == -1);
    }

    /**
     * Ueberprueft, ob der Stapel voll ist.
     * 
     * @return boolean true falls der Stapel voll ist, false sonst
     */
    @Override
    public boolean full() {
        return !(top < stack.length - 1);
    }

    /**
     * Falls der Stapel noch nicht voll ist, wird das Objekt 'e' dem Stapel als
     * oberstes Element hinzugefuegt, andernfalls wird ein
     * FullStackException-Objekt erzeugt.
     * 
     * @param e
     *            zu speicherndes Element
     * @throws FullStackException
     */
    @Override
    public void push(E e) throws FullStackException {
        if (!full()) {
            stack[++top] = e;
        } else {
            throw new FullStackException("Der Stapel ist voll!");
        }
    }

    /**
     * Falls der Stapel nicht leer ist, wird das oberste Element des Stapels
     * entfernt und als Ergebnis zurueckgegeben, andernfalls wird ein
     * EmptyStackException-Objekt erzeugt.
     * 
     * @return entferntes Element
     * @throws EmptyStackException
     */
    @Override
    public E pop() throws EmptyStackException {
        if (!empty()) {
            return stack[top--];
        } else {
            throw new EmptyStackException("Der Stapel ist leer");
        }
    }

    /**
     * Gibt die Stapel-Elemente, beginnend mit dem Obersten, und zwischen "[]"
     * als String zur�ck. Die Elemente werden mit ',' getrennt.
     * Wenn der Stapel leer ist, wird einfach "[]" zurueckgegeben.
     * 
     * @return String Stapel-Inhalt
     */
    public String toString() {
        if (!empty()) {
        	StringBuilder returnVal = new StringBuilder("[");
            for (int i = top; i > 0; i--) {
                returnVal.append(stack[i].toString() + ", ");
            }
            returnVal.append(stack[0].toString() + "]");
            return returnVal.toString();
        } else {
            return "[]";
        }
    }

    /**
     * Alternative Implementierung von toString
     * Mit der Benutzung der Java Bibliothek.
     * 
     * @return
     */
    public String toStringSimple() {
        return java.util.Arrays.toString(stack);
    }
}