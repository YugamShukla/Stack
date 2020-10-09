package Stack;
public class Stack {
    private int capacity=1000;
    private int[]data;
    private int top=-1;

    public Stack(){
        data=new int[capacity];
    }

    public Stack(int size){
        data=new int[size];
        capacity=size;
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public void push(int value){
        top++;
        data[top]=value;
    }

    public void pop(){
        int topValue=data[top];
        top--;
        System.out.println("\nThe popped value is"+topValue);
        
    }

    public void peek(){
        System.out.println("\nThe top value is "+ data[top]);
    }

    public void print(){
        for (int i = top; i>-1;i--) {
            System.out.println(" "+data[i]);
        }

    }

    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(100);
        st.push(200);
        st.push(300);
        st.print();
        st.pop();
        st.print();
        st.peek();
    }
}
