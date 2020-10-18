package Queue;

public class CircularQueue {
    int size;
    int[]data;
    int front;
    int rear;

     CircularQueue(int size){
      this.size=size;
      data=new int[size];
      this.rear=-1;
      this.front=-1;
    }

    public void Enqueue (int value){
       if (((rear+1)%size)==front) {
         System.out.println("Queue is full");
       }
       else{
         if (rear==front & rear==-1) {
           front=0;
         }
         else{
           rear=(rear+1)%size;
           data[rear]=value;
         }
       }
    }

    public void Dequeue(){
      if (rear==front & rear==-1) {
        System.out.println("Queue is empty");
      }
      else{
        int item=data[front];
        data[front]=0;
        if (rear==front) {
          rear=-1;
          front=-1;
        }
        else{
          front=(front+1)%size;
        }
      }
    }

    public void print(){
        for(int i=(front+1)%size ; i<=rear ; i++) {
            System.out.println(" "+data[i]);
        }
    }

    public static void main(String[] args) {
        int size=5;
        CircularQueue cq=new CircularQueue(size);
        cq.Enqueue(10);
        cq.Enqueue(20);
        cq.Enqueue(30);
        cq.Enqueue(40);
        cq.Enqueue(50);
        cq.print();
        System.out.println("\n");
        cq.Dequeue();
        cq.print();
        System.out.println("\n");
        cq.Enqueue(60);
        cq.print();
    }
}
