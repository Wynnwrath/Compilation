import java.util.Scanner;

public class QueueNodeMenu {
    public void menu(){
        Scanner scan = new Scanner(System.in);
        QueueNode qn = new QueueNode();
        int choice;

        while(true){
            System.out.println("\n---------- Queue Node ----------");
            System.out.println("[1] Enqueue");
            System.out.println("[2] Dequeue");
            System.out.println("[3] Display Queue");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();  
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    String value = scan.nextLine();
                    qn.enqueue(value);
                    System.out.println(value + " enqueued.");
                    break;

                case 2:
                    if (qn.dequeue()) {
                        System.out.println("Dequeued an element.");
                    } else {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    }
                    break;

                case 3:
                    System.out.println("\t[1] Display All");
                    System.out.println("\t[2] Display First");
                    System.out.println("\t[3] Display Last");
                    System.out.print("\tEnter your choice: ");
                    int displaychoice = scan.nextInt();
                    scan.nextLine();
                    System.out.println();
                        switch(displaychoice) {
                            case 1: 
                                System.out.println("Queue contents: \n" + qn);
                                break;
                            
                            case 2:
                                System.out.println(qn.getFirst());
                                break;

                            case 3:
                                System.out.println(qn.getLast());
                                break;
                            
                            default:
                                System.out.println("Must be an option");
                        }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
    }
}

class Node {
    Node next;
    String value;

    public Node(String value) {
        this.value = value;
        next = null;
    }
}

class QueueNode {
    Node last;
    Node first;
    int count;

    public QueueNode() {
        last = null;
        first = null;
        count = 0;
    }

    public boolean isEmpty() {
        return (last == null && first == null);
    }

    public String getLast(){
        if(!isEmpty()) 
            return "Last: " + last.value;
        else 
            return "Queue is Empty";
    }

    public String getFirst() {
        if(!isEmpty()) {
            return "First: " + first.value;
        }
        else
            return "Queue is Empty";
    }

    public boolean enqueue(String value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        count++;
        return true;
    }

    public boolean dequeue() {
        if (!isEmpty()) {
            if (first == last) {
                first = last = null;
            } else {
                first = first.next;
            }
            count--;
            return true;
        }
        return false;
    }


    public String toString(){
        String result = "";
        if(!isEmpty()) {
        
            Node temp = first;
            while (temp != null) {
            result += "[" + temp.value + "] --> ";
            temp = temp.next;
            }
        result += "null";
        } else {
            result += "Queue is Empty.";
        }
        return result;
    }
}





