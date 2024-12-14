import java.util.Scanner;

public class EvenOddMenu {
    public void menu(){
        Scanner scan = new Scanner(System.in);
        int odd[] = new int[10];
        int even[] = new int[10];
        int countEven = 0, countOdd = 0;

        while (true) {
            System.out.println("\n----- Even-Odd Menu -----");
            System.out.println("[1] Enter 10 integers");
            System.out.println("[2] Display Even and Odd numbers");
            System.out.println("[3] Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    countEven = 0;
                    countOdd = 0;
                    System.out.println("Enter 10 integers:");
                    for (int i = 0; i < 10; i++) {
                        int num = scan.nextInt();
                        if (num % 2 == 0) {
                            even[countEven++] = num;
                        } else {
                            odd[countOdd++] = num;
                        }
                    }
                    System.out.println("Numbers have been successfully stored.");
                    break;

                case 2:
                    System.out.println("Even\tOdd");
                    for (int i = 0; i < Math.max(countEven, countOdd); i++) {
                        if (i < countEven) {
                            System.out.print(even[i] + "\t");
                        } else {
                            System.out.print("\t");
                        }
                        if (i < countOdd) {
                            System.out.println(odd[i]);
                        } else {
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
