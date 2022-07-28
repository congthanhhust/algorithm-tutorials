package algorithm;

public class StackImplementation {

    static class Stack{
        private int values[] = new int[10000];

        /*
            Index is top element position. When stack is empty, index = -1
         */
        private int index = -1;

        public boolean isEmpty(){
            return index == -1;
        }

        public void push(int newElement){
            index = index + 1;
            values[index] = newElement;
        }

        public int pop(){
            int output = values[index];
            index = index - 1;
            return output;
        }

        public int peek(){
            return values[index];
        }
    }

    public static void main(String[] args) {
        // Demo
        Stack stack = new Stack();
        stack.push(1);
        stack.push(10);
        stack.push(100);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
