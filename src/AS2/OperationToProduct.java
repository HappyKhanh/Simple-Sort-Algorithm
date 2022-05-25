package AS2;

import java.io.*;
import java.util.Scanner;

public class OperationToProduct {
    static Scanner sc = new Scanner(System.in);

    public int index (Product p, MyList list){
        int index = 0;
        Node current = list.getHead();
        while (current!= null){
            index++;
            if (current.getInfo().equals(p)){
                return index;
            }
            current= current.getNext();
        }
        return -1;
    }
    public Product createProduct (){
        System.out.print("Input new ID: ");
        String bcode = sc.next();
        System.out.print("Input Product's Name: ");
        String title = sc.next();
        System.out.print("Input Product's quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Input Product's price: ");
        double price = sc.nextDouble();
        Product p = new Product(bcode,title,quantity,price);
        return p;
    }
    public void getAllItemFromFile (String filename, MyList list){
        try {
            list.clear();
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            while (true){
                String line = br.readLine();
                if (line ==null){
                    break;
                }
                String data[] = line.split(" ");
                list.insertToTail(new Product(data[0], data[1], Integer.parseInt(data[2]),Double.parseDouble(data[3])));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
    public void getAllItemFromFile (String filename, MyStack stack){
        try {
            stack.clear();
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            while (true){
                String line = br.readLine();
                if (line ==null){
                    break;
                }
                String data[] = line.split(" \\| ");
                stack.push(new Product(data[0], data[1], Integer.parseInt(data[2]),Double.parseDouble(data[3])));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
    public void getAllItemFromFile (String filename, MyQueue queue){
        try {
            queue.clear();
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            while (true){
                String line = br.readLine();
                if (line ==null){
                    break;
                }
                String data[] = line.split(" \\| ");
                queue.enqueue(new Product(data[0], data[1], Integer.parseInt(data[2]),Double.parseDouble(data[3])));
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
    public void addLast (MyList list){
        Product p = createProduct();
        list.insertToTail(p);
        System.out.println("\nSuccessfully!");
    }
    public void displayAll(MyList list) {
        if (!list.isEmpty()) {
            System.out.println("ID  | Title | Quantity | Price");
            System.out.println("------------------------------");
            Node current = list.getHead();
            while (current != null) {
                System.out.println(current.getInfo());
                current = current.getNext();
            }
            System.out.println("\nSuccessfully!");
        }else {
            System.out.println("Your list is empty, let's add some information first!");
        }
    }

    public void displayAll(MyStack stack){
        if (!stack.isEmpty()) {
            System.out.println("ID  | Title | Quantity | Price");
            System.out.println("------------------------------");
            Node current = stack.getHeadStack();
            while (current!= null ){
                System.out.println(current.getInfo());
                current = current.getNext();
            }
            System.out.println("\nSuccessfully!");
        }else {
            System.out.println("Your stack is empty, let's add some information first!");
        }
    }
    public void displayAll(MyQueue queue){
        if (!queue.isEmpty()) {
        System.out.println("ID  | Title | Quantity | Price");
        System.out.println("------------------------------");
        Node current = queue.getHead();
        while (current!= null ){
            System.out.println(current.getInfo());
            current = current.getNext();
        }
        System.out.println("\nSuccessfully!");
        }else {
            System.out.println("Your queue is empty, let's add some information first!");
        }
    }
    public void writeAllItemsToFile(String filename, MyList list){
        if (!list.isEmpty()){
            FileWriter fw = null;
            try {
                fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw);
                String output;
                Node current = list.getHead();

                while (current!= null) {
                    output = current.getInfo().toString();
                    bw.write(output);
                    bw.newLine();
                    current = current.getNext();
                }
                System.out.println("Successfully!!!");
                bw.close();
                fw.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
        }
    }
    public void searchByCode(MyList list) {
        if (list.isEmpty()) {
            System.out.println("Your list is empty, let's add some information first!");
        } else {
            System.out.print("Input the ID to search: ");
            String id = sc.next();
            Node current = list.getHead();
            boolean found = false;
            while (current != null) {
                if (current.getInfo().getBcode().equals(id)) {
                    System.out.print("Result: ");
                    System.out.println(current);
                    found = true;
                }
                current = current.getNext();
            }
            if (!found) {
                System.out.println("the ID is not avaiable");
            }
        }
    }
        public void deleteByCode (MyList list) {
            if (list.isEmpty()) {
                System.out.println("The list is empty, let's add some information first!");
            } else {
                System.out.print("Input the bcode to delete: ");
                String id = sc.next();
                Product p;
                Node current = list.getHead();
                boolean found = false;
                while (current != null) {
                    if (current.getInfo().getBcode().equals(id)) {
                        p = current.getInfo();
                        list.deleteElement(p);
                        found = true;
                        System.out.println("Delete!");
                        break;
                    }
                    current = current.getNext();
                }

                if (!found) {
                    System.out.println("the ID is not avaiable");
                }
            }
        }
        public void sortByCode(MyList list, Node p) {
            if (p == null) {
                return;
            } else {
                Node current = p;
                Node min = current;
                Node next = current.getNext();
                while (next != null) {
                    if (next.getInfo().getBcode().compareTo(min.getInfo().getBcode()) < 0) {
                        min = next;
                    }
                    next = next.getNext();
                }
                list.swap(min, current);

            sortByCode(list,p.getNext());
            }
            System.out.println("\nSuccesfully!!!");
        }
        public void addFirst(MyList list){
            Product p= createProduct();
            list.insertToHead(p);
        }

        public String toBinary(int i){
            if(i==1){ return "1";}
            return toBinary(i/2)+(i%2);
        }

        public int[] convertToBinary (int i){
            String a =toBinary(i);
            int []b = new int[a.length()];
            for(int j =0; j< a.length();j++ ){
                b[j] = Integer.parseInt(Character.toString(a.charAt(j)));
            }
            return b;
        }
    }


