package AS2;

import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        int choose;
        MyList list =new MyList();
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();
        OperationToProduct t = new OperationToProduct();
        String data = "src/AS2/data.txt";
        String output ="src/AS2/output.txt";


        while (flag) {
            menu();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println();
                    t.getAllItemFromFile(data,list);
                    t.displayAll(list);
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    t.addLast(list);
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    t.displayAll(list);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    t.writeAllItemsToFile(output,list);
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    t.searchByCode(list);
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    t.deleteByCode(list);
                    System.out.println();
                    break;
                case 7:
                    System.out.println();
                    t.sortByCode(list,list.getHead());
                    break;
                case 8:
                    System.out.println();
                    int quantity = list.getHead().getInfo().getQuantity();
                    String binary = t.toBinary(quantity);
                    System.out.printf("Quantity=%d=>(%s)\n\n",quantity,binary);
                    break;
                case 9:
                    System.out.println();
                    t.getAllItemFromFile(output,stack);
                    t.displayAll(stack);
                    System.out.println();
                    break;
                case 10:
                    System.out.println();
                    t.getAllItemFromFile(output,queue);
                    t.displayAll(queue);
                    System.out.println();
                    break;
                case 0:
                    flag = false;
                    System.out.println("Thanks!!!");
                    break;
                default:
                    flag = false;
                    System.out.println("Thanks!!!");
                    break;
            }
        }
    }
    public static void menu (){
        System.out.println("Choose one of this option:");
        System.out.println("Product list");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display");
        System.out.println("0. Exit");
        System.out.print("\nChoice: ");
    }
}
