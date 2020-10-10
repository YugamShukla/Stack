package Stack;

public class StackLL {
    private class Node{

        private int value;
        private Node next;

        private Node(int v, Node n){
            value=v;
            next=n;
        }
    }
    private Node head=null;
    private int size=0;

    public void peek(){
        if (size==0) {
            System.out.println("list is empty");
        }
        System.out.println("\nThe top value is "+head.value);
    }

    public void push(int value) {
        head = new Node(value, head);
        size++ ;
    }

    public void pop(){
        if (size==0) {
            System.out.println("list is empty");
        }
       head=head.next;
       size--;
    }
    

    public void print(){
        Node curr=head;

        while (curr!=null) {
            System.out.println(" "+curr.value);
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        StackLL st=new StackLL();
        st.push(10);
        st.push(20);
        st.push(30);
        st.print();
        st.peek();
        st.pop();
        st.print();
    }
}
