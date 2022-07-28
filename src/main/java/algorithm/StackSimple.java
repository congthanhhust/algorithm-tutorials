package algorithm;

public class StackSimple {
    static class Stack{
        private int values[] = new int[10000];
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
