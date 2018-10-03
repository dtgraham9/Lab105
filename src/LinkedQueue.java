/**
* A collection of objects that are inserted and removed according to the last-in
* first-out principle. Although similar in purpose, this interface differs from
* java.util.Stack.
*
* @author Michael T. Goodrich
* @author Roberto Tamassia
* @author Michael H. Goldwasser
*/

/** Realization of a FIFO queue as an adaptation of a SinglyLinkedList. */

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>( ); // an empty list

    public LinkedQueue( ) { } // new queue relies on the initially empty list

    public int size( ) { 
        return list.size( ); 
    }
    
    public boolean isEmpty( ) { 
        return list.isEmpty( ); 
    } 
    
    public void enqueue(E element) { 
        list.addLast(element); 
    } 
    
    public E first( ) { 
        return list.first( ); 
    } 
    public E dequeue( ) { 
        return list.removeFirst( ); 
    } 
}