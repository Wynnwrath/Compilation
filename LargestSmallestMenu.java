import java.util.Scanner;

public class LargestSmallestMenu {
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----- Find Largest/Smallest Progrma ------");
            System.out.println("[1] Input Three Numbers");
            System.out.println("[2] Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter three numbers:");
                    int z = scanner.nextInt();
                    int y = scanner.nextInt();
                    int x = scanner.nextInt();
                    findLargestSmallest(z, y, x);
                    break;
                case 2:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }

    public static void findLargestSmallest(int z, int y, int x) {
        int largest = z; 
        if (y > largest) {
            largest = y;
        }
        if (x > largest) {
            largest = x; 
        }

        int smallest = z;
        if (y < smallest) {
            smallest = y; 
        }
        if (x < smallest) {
            smallest = x; 
        }

        System.out.println("The largest number is: " + largest);
        System.out.println("The smallest number is: " + smallest);
    }
}