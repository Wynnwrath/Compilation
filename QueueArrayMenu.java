import java.util.Scanner;

public class QueueArrayMenu {
    public void menu(){
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("Enter size: ");
        int size = scan.nextInt();
        QueueArray queue = new QueueArray(size);
        while(true){
            System.out.println("\n--------- Queue Array ----------");
            System.out.println("[1] Enqueue");
            System.out.println("[2] Dequeue");
            System.out.println("[3] Display Queue");
            System.out.println("[4] Front Element");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice: ");

            choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    if (queue.isFull()) {
                        System.out.println("Queue is full. Cannot enqueue.");
                    } else {
                        System.out.print("Enter a value to enqueue: ");
                        String value = scan.nextLine();
                        queue.enqueue(value);
                        System.out.println("Value enqueued.");
                    }
                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    } else {
                        queue.dequeue();
                        System.out.println("Value dequeued.");
                    }
                    break;

                case 3:
                    System.out.println("Current Queue: ");
                    queue.display();
                    break;

                case 4:
                    Object front = queue.front();
                    if (front != null) {
                        System.out.println("Front element: " + front);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    }
}

class QueueArray 
{
    private Object[] items;
    private int count;
    
    public QueueArray(int size)
    {
        items = new Object[size];
        count = 0;
    }
    
    public QueueArray() 
    {
        this(10);
    }
    
    public boolean isEmpty()
    {
        return count == 0;
    }
    
    public boolean isFull()
    {
        return count == items.length;
    }
    
    public boolean enqueue(Object val)
    {
        if(!isFull()) 
        {
            items[count++] = val;
            return true;
        }
        return false;
    }
    
    public boolean dequeue()
    {
        if(!isEmpty())
        {
            for(int i = 1; i < count; i++) 
            {
                items[i-1] = items[i];
            }
            items[count-1] = null;
            count--;
            return true;
        }
        return false;
    }
    
    public Object front() 
    {
        if(!isEmpty()) 
        {
            return items[0];
        }
        return null;
    }
    
    public void display()
    {
        if(!isEmpty())
        {
            for(int i = 0; i<count; i++)
            {
                System.out.println("[" + items[i] + "]");
            }
            System.out.println();
        }
        else
            System.out.println("\nQueue is empty...");
    }
}
