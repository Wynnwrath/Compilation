import java.util.Scanner;

public class StackArrayMenu {
    public void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the stack: ");
        int size = scan.nextInt();
        Stack stack = new Stack(size);

        while (true) {
            System.out.println("\n------- Stack Array --------");
            System.out.println("[1] Push");
            System.out.println("[2] Pop");
            System.out.println("[3] Peek");
            System.out.println("[4] Display Stack");
            System.out.println("[5] Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    String value = scan.nextLine();
                    if (stack.push(value)) {
                        System.out.println("Pushed: " + value);
                    } else {
                        System.out.println("Stack is full! Cannot push.");
                    }
                    break;

                case 2:
                    if (stack.pop()) {
                        System.out.println("Popped from stack.");
                    } else {
                        System.out.println("Stack is empty! Cannot pop.");
                    }
                    break;

                case 3:
                    if (!stack.isEmpty()) {
                        System.out.println("Top of stack: " + stack.peek());
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

class Stack {
    String[] arr;
    int count;

    public Stack(int size) {
        arr = new String[size];
        count = 0;
    }

    public boolean push(String val) {
        if (!isFull()) {
            arr[count++] = val;
            return true;
        }
        return false;
    }

    public boolean pop() {
        if (!isEmpty()) {
            arr[--count] = null;
            return true;
        }
        return false;
    }

    public String peek() {
        return arr[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == arr.length;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = count - 1; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
}
