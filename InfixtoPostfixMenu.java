import java.util.Scanner;

public class InfixtoPostfixMenu{
    public void menu() {
        Scanner scan = new Scanner(System.in);
        InfixtoPostfix itp = new InfixtoPostfix(null);
        String postfixExpression = "";
        while (true){
            System.out.println("\n----- Infix to Postfix Converter -----");
            System.out.println("[1] Convert Infix to Postfix");
            System.out.println("[2] Evaluate Postfix Expression");
            System.out.println("[3] Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();
            scan.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter an infix expression: ");
                    String infixExpression = scan.nextLine();

                    itp = new InfixtoPostfix(infixExpression);
                    postfixExpression = itp.convert();

                    System.out.println("Postfix Expression: " + postfixExpression);
                    break;
                case 2:
                    if (!postfixExpression.isEmpty()) {
                        System.out.println("Result: " + itp.evaluate(postfixExpression));
                    } else {
                        System.out.println("No postfix expression available. Please convert an infix expression first.");
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

class InfixtoPostfix {
    private String infix;

    public InfixtoPostfix(String infix) {
        this.infix = infix;
    }

    private int getPrec(char c) {
        if (c == '*' || c == '/') {
            return 2;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        return -1; 
    }

    public String convert() {
        StackList s = new StackList();
        String result = "";

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                result += c;
            } else if (c == '(') {
                s.push(c + "");
            } else if (c == ')') {
                while (!s.peek().equals("(")) {
                    result += s.pop();
                }
                s.pop();  
            } else {
                while (!s.isEmpty() && getPrec(c) <= getPrec(s.peek().charAt(0))) {
                    result += s.pop();
                }
                s.push(c + "");
            }
        }

        while (!s.isEmpty()) {
            result += s.pop();
        }

        return result;
    }

    public double evaluate (String r){
        StackList s =  new StackList();
        double ans = 0;
        
        for(int i = 0; i < r.length(); i++){
           char ch = r.charAt(i);
           
           if(Character.isDigit(ch))
              s.push(ch+"");
           else{
              double val2 = Double.parseDouble(s.pop());
              double val1 = Double.parseDouble(s.pop());
           
              switch(ch){
                 case '*':
                    ans = val1 * val2;
                    break;
                 case '/':
                    ans = val1 / val2;
                    break;
                 case '+':
                    ans = val1 + val2;
                    break;
                 case '-':
                    ans = val1 - val2;
                    break;
              }
              s.push(ans + "");
           }
        }
        return Double.parseDouble(s.pop());
    }
}

class StackList {
    private Node tail;
    private int count;

    public StackList() {
        tail = null;
        count = 0;
    }

    public boolean push(String val) {
        Node newNode = new Node(val);
        newNode.next = tail;  
        tail = newNode; 
        count++;
        return true;
    }

    public String pop() {
        if (!isEmpty()) {
            String value = tail.val;  
            tail = tail.next;  
            count--;
            return value;  
        }
        return null;  
    }

    public String peek() {
        if (isEmpty()) {
            return null;  
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}

class Node {
    Node next;
    String val;

    public Node(String val) {
        this.val = val;
        next = null;
    }
}
