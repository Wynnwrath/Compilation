import java.util.Scanner;
public class SumAndProduct {
    public void menu(){
        Scanner scan = new Scanner(System.in);
        int num, sum = 0, prod = 1, i = 0;
        for (;i < 10; i++) {
            num = scan.nextInt();

            if (num > 0){
                sum += num;
                prod = prod * num;
            }
        }
        if(sum == 0)
            prod = 0;
        System.out.println("Total sum: " + sum);
        System.out.println("Total product: "+ prod);
    }
}