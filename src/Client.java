/**
 *
 * @author Graham
 */
public class Client {

    public static void testStack(Stack<Integer> stack) {
        try {
            stack.push(15);
            stack.push(21);
            System.out.println("Stack size: " + stack.size());
            System.out.println("Pop: " + stack.pop());
            System.out.println("Is Empty: " + stack.isEmpty());
            System.out.println("Pop: " + stack.pop());
            System.out.println("Is empty: " + stack.isEmpty());
            System.out.println("Pop: " + stack.pop());
            stack.push(47);
            stack.push(91);
            System.out.println("Top: " + stack.top());
            stack.push(422);
            System.out.println("Stack size: " + stack.size());
            System.out.println("Pop: " + stack.pop());
            stack.push(6423);
            stack.push(8231);
            System.out.println("Pop: " + stack.pop());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    
    public static void testQueue(Queue<Integer> queue){
        try{
            queue.enqueue(55);
            queue.enqueue(63);
            System.out.println("Size: " + queue.size());
            System.out.println("Dequeue: " + queue.dequeue());
            System.out.println("Is empty: "+ queue.isEmpty());
            System.out.println("Dequeue: " + queue.dequeue());
            System.out.println("Is empty: " + queue.isEmpty());
            System.out.println("Dequeue: " + queue.dequeue());
            queue.enqueue(42);
            queue.enqueue(21);
            System.out.println("First: " + queue.first());
            queue.enqueue(99);
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayStack<Integer> stack1 = new ArrayStack(3);
        System.out.println("Testing array Stack");
        testStack(stack1);
        LinkedStack<Integer> stack2 = new LinkedStack();
        System.out.println("Testing linked stack");
        testStack(stack2);
        
        ArrayQueue<Integer> queue1 = new ArrayQueue(2);
        System.out.println("Testing array queue");
        testQueue(queue1);
        LinkedQueue<Integer> queue2 = new LinkedQueue();
        System.out.println("Testing Linked queue");
        testQueue(queue2);
        
        
    }
    
}
