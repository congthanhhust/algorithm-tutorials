package algorithm.queue;

public class QueueImplementation {

    static class Queue{
        final static int MAX = 1000;

        private int values[] = new int[MAX];

        /**
         * Rear is last element of queue
         * Front is first element of queue
         * When queue is created, front = 0 and rear = -1;
         */
        int front = 0, rear = -1;

        public void enQueue(int newElement){
            rear++;
            values[rear] = newElement;
        }

        public int deQueue(){
            int output = values[front];
            front++;
            return output;
        }

        public int peek(){
            return values[front];
        }

        public boolean isEmpty(){
            return front > rear;
        }
    }

    public static void main(String[] args) {
        // Demo
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        while (!queue.isEmpty()){
            System.out.println(queue.deQueue());
        }
    }
}
