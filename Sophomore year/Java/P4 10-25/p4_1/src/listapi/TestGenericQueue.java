package listapi;

/**@author Y. Daniel Liang*/
public class TestGenericQueue {

    public TestGenericQueue() {
        // Create a queue
        GenericQueue<String> queue = new GenericQueue<>();

        // Add elements to the queue
        queue.enqueue("Tom"); // Add it to the queue
        System.out.println("(7) " + queue);

        queue.enqueue("Susan"); // Add it to the queue
        System.out.println("(8) " + queue);

        queue.enqueue("Kim"); // Add it to the queue
        queue.enqueue("Michael"); // Add it to the queue
        System.out.println("(9) " + queue);

        // Remove elements from the queue
        System.out.println("(10) " + queue.dequeue());
        System.out.println("(11) " + queue.dequeue());
        System.out.println("(12) " + queue);
    }
}
