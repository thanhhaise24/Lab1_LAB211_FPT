package food.manage;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FoodList {

    // add from file
    public static void readFromFile(ArrayList<Food> foods, String fName) {
        try {
            File f = new File(fName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String detail;
            while ((detail = br.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ",");
                String ID = stk.nextToken();
                String name = stk.nextToken();
                String type = stk.nextToken();
                float weight = Float.parseFloat(stk.nextToken());
                String place = stk.nextToken();
                String date = stk.nextToken();
                Food dt = new Food(ID, name, type, weight, place, date);
                foods.add(dt);
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Save to file
    public static void saveToFile(ArrayList<Food> foods, String fName) {
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < foods.size(); i++) {
                pw.println(foods.get(i).getID() + "," + foods.get(i).getName() + "," +
                        foods.get(i).getType() + "," + foods.get(i).getWeight() + "," +
                        foods.get(i).getPlace() + "," + foods.get(i).getExpiredDate());
            }
            fw.close();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // add one food
    public static void addOneFood(ArrayList<Food> foods) {
        System.out.print("Enter ID: ");
        String ID = Validation.checkString();
        if (!Validation.checkID(foods, ID)) {
            System.out.println("ID exist!!!!");
            return;
        } else {
            System.out.print("Enter name: ");
            String name = Validation.checkString();
            System.out.print("Enter type: ");
            String type = Validation.checkString();
            System.out.print("Enter weight(kg): ");
            float weight = Validation.checkWeight();
            System.out.print("Enter place (Cool or Cold): ");
            String place = Validation.checkPlace().toLowerCase(Locale.ROOT);
            System.out.print("Enter date (dd/MM/yyyy): ");
            String expiredDate = Validation.checkDate();
            foods.add(new Food(ID, name, type, weight, place, expiredDate));
            System.out.println("Add Successful");
        }
    }

    // case 1
    public static void addFoods(ArrayList<Food> foods) {
        while (true) {
            addOneFood(foods);
            while (true) {
                System.out.print("Do you want to add another food ? (Y/N): ");
                boolean ans = Validation.checkInputYN();
                if (ans == false) {
                    return;
                } else break;
            }
        }
    }

    // case 2
    public static void searchFood(ArrayList<Food> foods) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("You want search by: ");
            System.out.println("1. Name");
            System.out.println("2. Place");
            System.out.print("Enter your choice: ");
            choice = Validation.checkInt();
            switch (choice) {
                case 1:
                    searchFoodByName(foods);
                    while (true) {
                        System.out.print("Do you want to search other foods ? (Y/N): ");
                        boolean ans = Validation.checkInputYN();
                        if (ans == false) {
                            return;
                        } else break;
                    }
                    break;

                case 2:
                    searchFoodByPlace(foods);
                    while (true) {
                        System.out.print("Do you want to search other foods ? (Y/N): ");
                        boolean ans = Validation.checkInputYN();
                        if (ans == false) {
                            return;
                        } else break;
                    }
                    break;
            }
        }
    }

    // search by name
    public static void searchFoodByName(ArrayList<Food> foods) {
        Scanner sc = new Scanner(System.in);
        printAllElements(foods);
        System.out.print("Enter food's name you want to search: ");
        String name = sc.nextLine().trim();
        if (name == null) {
            displayAll(foods);
            return;
        }
        ArrayList<Food> foodsFound = getFoodByName(foods, name);
        displayAll(foodsFound);
    }

    // search by place
    public static void searchFoodByPlace(ArrayList<Food> foods) {
        Scanner sc = new Scanner(System.in);
        printAllElements(foods);
        System.out.print("Enter place you want to search: ");
        String place = sc.nextLine().trim();
        if (place == null) {
            displayAll(foods);
            return;
        }
        ArrayList<Food> foodsFound = getFoodByPlace(foods, place);
        displayAll(foodsFound);
    }

    // get object by name
    private static ArrayList<Food> getFoodByName(ArrayList<Food> foods, String name) {
        ArrayList<Food> foodFound = new ArrayList<>();
        for (Food food : foods) {
            if (food.getName().toLowerCase().contains(name.toLowerCase())) {
                foodFound.add(food);
            }
        }
        return foodFound;
    }

    // get object by place
    private static ArrayList<Food> getFoodByPlace(ArrayList<Food> foods, String place) {
        ArrayList<Food> foodFound = new ArrayList<>();
        for (Food food : foods) {
            if (food.getPlace().contains(place.toLowerCase())) {
                foodFound.add(food);
            }
        }
        return foodFound;
    }

    // case 3
    public static void removeFood(ArrayList<Food> foods) {
        while (true) {
            removeOneFood(foods);
            while (true) {
                System.out.print("Do you want to remove another food ? (Y/N): ");
                boolean ans = Validation.checkInputYN();
                if (ans == false) {
                    return;
                } else break;
            }
        }
    }

    // remove food
    public static void removeOneFood(ArrayList<Food> foods) {
        printAllElements(foods);
        System.out.print("Enter ID: ");
        String id = Validation.checkString();
        Food food = getFoodByID(foods, id);
        if (food == null) {
            System.out.println("No found food");
            return;
        } else {
            foods.remove(food);
        }
        System.out.println("Remove Successfully");
    }

    // get object by ID
    private static Food getFoodByID(ArrayList<Food> foods, String id) {
        for (Food food : foods) {
            if (food.getID().equalsIgnoreCase(id)) {
                return food;
            }
        }
        return null;
    }

    //Display 1 food
    public static void displayFood(Food food) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",
                food.getID(), food.getName(), food.getWeight(), food.getType(), food.getPlace(), food.getExpiredDate());
    }

    //Display all
    public static void displayAll(ArrayList<Food> foods) {
        if (foods.size() == 0) {
            System.out.println("Empty list");
            return;
        } else {
            sortByDate(foods);
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Weight", "Type", "Place", "ExpiredDay");
            System.out.println("----------------------------------------------------------------------------------");
            for (var food : foods) {
                displayFood(food);
            }
        }
    }

    // sort
    private static void sortByDate(ArrayList<Food> foods) {
        Collections.sort(foods, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                try {
                    return (sdf.parse(o2.getExpiredDate())).compareTo(sdf.parse(o1.getExpiredDate()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

    public static void printAllElements(ArrayList<Food> foods) {
        if (foods.size() == 0) {
            System.out.println("Empty list");
            return;
        } else {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Weight", "Type", "Place", "ExpiredDay");
            System.out.println("----------------------------------------------------------------------------------");
            for (var food : foods) {
                displayFood(food);
            }
        }
    }
}
