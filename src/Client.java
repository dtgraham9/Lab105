
import java.util.Objects;

/**
 *
 * @author Graham
 */
public class Client {

    public static void testStack(Stack<Integer> stack) {
        try {
            Integer[] test = new Integer[5];
            Integer top = 0;
            stack.push(15);
            test[0] = 15;
            stack.push(21);
            test[1] = 21;
            top++;
            System.out.println("Stack size: " + stack.size());
            Integer pop =stack.pop();
            System.out.println("Pop: " + pop + " and is correct pop: " + (Objects.equals(pop, test[top--])));
            System.out.println("Is Empty: " + stack.isEmpty());
            pop = stack.pop();
            System.out.println("Pop: " + pop + " and is correct pop: " + (Objects.equals(pop, test[top--])));
            System.out.println("Is empty: " + stack.isEmpty());
            pop = stack.pop();
            System.out.println("Pop: " + pop + " and is corect pop: " + (pop == null));
            stack.push(47);
            test[++top] = 47;
            stack.push(91);
            test[++top] = 91;
            Integer topStack = stack.top();
            System.out.println("Top: " + topStack + " and is correct top: " + (Objects.equals(topStack, test[top])) );
            stack.push(422);
            test[+top] = 422;
            System.out.println("Stack size: " + stack.size());
            pop = stack.pop();
            System.out.println("Pop: " + pop + " and is correct pop: " + (Objects.equals(pop, test[top--])));
            stack.push(6423);
            test[++top]=6423;
            stack.push(8231);
            test[++top] = 8231;
            pop = stack.pop();
            System.out.println("Pop: " +  pop + " and is correct pop: " + (Objects.equals(pop, test[top--])));
        }
        catch (IllegalStateException e){
            System.out.print("\u001b[31m\u001b[1m");
            e.printStackTrace(System.out);
        }
        finally{
            System.out.print("\n");
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
            System.out.print("\u001b[31m\u001b[1m");
            e.printStackTrace(System.out);
        }
        finally{
            System.out.print("\n");
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
