
import java.util.Objects;

/**
 * Runs tests on stacks, both array and linked.
 * Runs tests on queues, both array and linked
 * Runs a test on Arraylists until it JVM runs out of memory
 * @author Graham
 * @version 
 */
public class Client {

    /**
     * This will run tests on classes that use the stack interface
     * It will test if it follows LIFO, what happens when trying to remove
     * an element when none are there
     * Test array when it is full
     * @param stack
     * @return
     */
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
    /**
     * Performs a removal of an integer from the beginning and 
     * shifts everything down
     * @param test
     * @param i
     * @return 
     */
    public static Integer[] remove(Integer[] test, int i){
        if(i == 0)
            return test;
        for(int y = 0; y < i; y++){
                test[y] = test[y+1];
            }
        return test;
    }
    
    /**
     * This will run tests on classes that use the stack interface
     * It will test if it follows FIFO, what happens when trying to remove
     * an element when none are there
     * Test array when it is full
     */
    public static void testQueue(Queue<Integer> queue){
        try{
            Integer[] test = new Integer[5];
            int top = -1;
            queue.enqueue(55);
            test[++top]= 55;
            queue.enqueue(63);
            test[++top] =63;
            System.out.println("Size: " + queue.size());
            Integer removed = queue.dequeue();
            System.out.println("Dequeue: " + removed + " and dequeue is correct: " + (Objects.equals(removed, test[0])));
            test = remove(test, top--);
            System.out.println("Is empty: "+ queue.isEmpty());
            removed = queue.dequeue();
            System.out.println("Dequeue: "  + removed + " and dequeue is correct: " + (Objects.equals(removed, test[0])));
            test = remove(test, top--);
            System.out.println("Is empty: " + queue.isEmpty());
            System.out.println("Dequeue: "  + removed + " and dequeue is correct: " + (Objects.equals(removed, test[0])));
            test = remove(test, 0);
            queue.enqueue(42);
            test[++top] = 42;
            queue.enqueue(21);
            test[++top] = 21;
            removed = queue.first();
            System.out.println("First: " + removed + " and first is correct: " + (Objects.equals(removed, test[0])));
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
     * Returns the power of a 2 given an exponent
     * @param power
     * @return 
     */
    public static int power(int power){
        int result = 1;
        while(power > 1) {
            result*=2;
            power--;
        }
        return result;
    }
    /**
     * Will test run time of operation and will run until JVM runs out of ram
     */
    public static void memoryError(){
        int exp = 27;
        int n = power(exp);
        int i = 0;
        try{
            while(true){
                System.out.printf("========================= %,d ===============================\n",n);
                for(i = n - 3; i < n + 4; i++){
                    long start = System.nanoTime();
                    ArrayList<Boolean> list = new ArrayList(i);
                    for(int y = 0; y <=n;y++){
                        list.add(y,true);
                    }
                    
                    long diff = System.nanoTime() - start;
                    System.out.printf("Size = %,d \tTime = %,d nsec\n",i,diff );
                }
                n = power(++exp);
            }
        }
        catch(OutOfMemoryError e){
            System.out.printf("Out of Memory at %,d\n",i);
        }
    }
    
    
    /**
     * Tests array stacks and linked stacks to ensure they behave as intended
     * Tests array queue and linked queue to ensure they behave as intended
     * Call memory error method to run until JVM runs out of ram
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
        
        memoryError();
    }
    
}
