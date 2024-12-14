import java.util.Scanner;

public class Compilation {
    public static void main(String[] args) {
        boolean exit = false;
        while(!exit) {
            Scanner scan = new Scanner(System.in);
            int choice;
            
            System.out.println("\n---------Compilation of Activities----------");
            System.out.println("[1] Queue Node");
            System.out.println("[2] Queue Array");
            System.out.println("[3] Node List");
            System.out.println("[4] Infix to Postfix");
            System.out.println("[5] Odd and Even");
            System.out.println("[6] Sum and Product");
            System.out.println("[7] Stack Array");
            System.out.println("[8] Stack Node");
            System.out.println("[9] No Duplication Program");
            System.out.println("[10] Largest/Smallest Program");
            System.out.println("[11] Exit Program");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch(choice) {
                case 1:  
                    new QueueNodeMenu().menu();
                    break;
                case 2:
                    new QueueArrayMenu().menu();
                    break;
                case 3:
                    new NodeListMenu().menu();
                    break;
                case 4:
                    new InfixtoPostfixMenu().menu();
                    break;
                case 5:
                    new EvenOddMenu().menu();
                    break;
                case 6:
                    new SumAndProduct().menu();
                    break;
                case 7:
                    new StackArrayMenu().menu();
                    break;
                case 8:
                    new StackNodeMenu().menu();
                    break;
                case 9:
                    new NoDupeMenu().menu();
                    break;
                case 10:
                    new LargestSmallestMenu().menu();
                    break;
                case 11:
                    System.out.println("Exiting the Prgoram. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Please select an available option.");
            }
        }
    }
}
