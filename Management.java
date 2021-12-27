package food.manage;

import java.util.ArrayList;

public class Management {
    public static void main(String[] args) {
        ArrayList<Food> foods = new ArrayList<>();
        String fName = "food.dat";
        FoodList.readFromFile(foods, fName);
        Menu menu = new Menu();
        menu.addMenuItem("1. Add a new food");
        menu.addMenuItem("2. Search a food by name");
        menu.addMenuItem("3. Remove a Food by ID");
        menu.addMenuItem("4. Display all foods");
        menu.addMenuItem("5. Quit");
        int userChoice;

        do {
            System.out.println("=====*****=====");
            System.out.println("FOOD MANAGEMENT");
            userChoice = menu.getUserChoice();

            switch (userChoice) {
                case 1:
                    FoodList.addFoods(foods);
                    break;
                case 2:
                    FoodList.searchFood(foods);
                    break;
                case 3:
                    FoodList.removeFood(foods);
                    break;
                case 4:
                    FoodList.displayAll(foods);
                    break;
                case 5:
                    FoodList.saveToFile(foods, fName);
                    System.out.println("THANK YOU!!!");
                    return;
            }

        } while (userChoice > 0 && userChoice < 5);

    }
}
