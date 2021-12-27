package food.manage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Menu extends Vector<String> {
    public Menu() {
        super();
    }

    ArrayList<String> menu = new ArrayList<>();

    void addMenuItem(String option) {
        menu.add(option);
    }

    int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
        System.out.print("Enter your choice: ");
        int choice = checkInputMenu(menu);
        return choice;
    }

    public static int checkInputMenu(ArrayList<String> menu) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean check = false;
        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < 1 || number > menu.size()) throw new Exception();
                check = false;
            } catch (Exception e) {
                System.out.println("---------------");
                System.out.println("Invalid input!!");
                System.out.print("Please enter again: ");
                check = true;
            }
        } while (check);
        return number;
    }
}
