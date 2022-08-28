package algorithm.stack;

public class StackSimple {
    static class Stack{
        public final static int MAX = 10000;

        private int values[] = new int[MAX];

        private int index = -1;

        public boolean isEmpty(){
            return index == -1;
        }

        public void push(int newElement){
            values[++index] = newElement;
        }

        public int peek(){
            return values[index];
        }

        public int pop(){
            return values[index--];
        }

        public void reset(){
            index = -1;
        }
    }
}
