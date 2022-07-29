package algorithm;

public class QueueImplementation {

    static class Queue{
        private int values[] = new int[10000];

        /**
         * Rear is last element of queue
         * Front is first element of queue
         * When queue is created, front = 0 and rear = -1;
         */
        int front = 0, rear = -1;

        public void enQueue(int newElement){
            rear = rear + 1;
            values[rear] = newElement;
        }

        public int deQueue(){
            int output = values[front];
            front = front + 1;
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
