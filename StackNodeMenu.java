import java.util.Scanner;

public class StackNodeMenu {
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        Tail stack = new Tail();

        while (true) {
            System.out.println("\n--------- Stack Node ----------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    String value = scanner.nextLine();
                    stack.push(value);
                    System.out.println("Pushed: " + value);
                    break;
                case 2:
                    String poppedValue = stack.pop();
                    if (poppedValue != null) {
                        System.out.println("Popped: " + poppedValue);
                    } else {
                        System.out.println("Stack is empty! Cannot pop.");
                    }
                    break;
                case 3:
                    String topValue = stack.peek();
                    if (topValue != null) {
                        System.out.println("Top of stack: " + topValue);
                    } else {
                        System.out.println("Stack is empty! No top element.");
                    }
                    break;
                case 4:
                    System.out.println("Stack contents:");
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

class Node {
    Node next;
    String value;

    public Node(String value) {
        this.value = value;
        this.next = null;
    }
}

class Tail {
    Node tail;

    public Tail() {
        tail = null;
    }

    public void push(String val) {
        Node stack = new Node(val);
        stack.next = tail;
        tail = stack;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String temp = tail.value;
        tail = tail.next;
        return temp;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node current = tail;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}
