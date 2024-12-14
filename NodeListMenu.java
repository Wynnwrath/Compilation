import java.util.Scanner;

public class NodeListMenu {
    public void menu(){
        NodeList list = new NodeList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while(true) {
            System.out.println("\n------ Node List ------");
            System.out.println("[1]Add a node");
            System.out.println("[2] Delete a node");
            System.out.println("[3] Display the list");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to add: ");
                    int value = scanner.nextInt();
                    list.add(list.new Node(value));
                    System.out.println("Node added successfully.");
                    break;

                case 2:
                    System.out.print("Enter the position to delete: ");
                    int position = scanner.nextInt();
                    if (list.delete(position)) {
                        System.out.println("Node deleted successfully.");
                    } else {
                        System.out.println("Invalid position.");
                    }
                    break;

                case 3:
                    System.out.println("Current list: ");
                    list.display();
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


class NodeList {
    private Node tail;
    private int size;

    public NodeList() {
        size = 0;
        tail = null;
    }

    public boolean add(Node node) {
        if (tail == null) {
            tail = node;
            node.next = null;
            size++;
        } else {
            Node curr = tail;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
            node.next = null;
        }
        size++;
        return true;
    }

    public boolean delete(int loc) {
        if (loc < 1 || loc > size) {
            return false;
        }
        if (loc == 1) {
            tail = tail.next;
            size--;
            return true;
        }
        Node prev = tail;
        for (int i = 1; i < loc - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        size--;
        return true;
    }

    public void display() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    class Node {
        public Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }
}

