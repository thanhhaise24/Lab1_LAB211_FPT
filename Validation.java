package food.manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    // check input string
    public static String checkString() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        String str = "";
        do {
            try {
                str = sc.nextLine().trim();
                if (str.isEmpty()) throw new Exception();
                check = false;
            } catch (Exception e) {
                System.out.println("Input need to be not empty");
                System.out.println("---------");
                System.out.print("Please try again: ");
                check = true;
            }
        } while (check);
        return str;
    }

    // check input int
    public static int checkInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("-----------------");
                System.out.println("Please input an integer number");
                System.out.print("Enter again: ");
            }
        }
    }

    // check input float
    public static float checkFloat() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                float result = Float.parseFloat(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("-----------------");
                System.out.println("Please input a number");
                System.out.print("Enter again: ");
            }
        }
    }

    // check ID
    public static boolean checkID(ArrayList<Food> foods, String ID) {
        for (Food doctor : foods) {
            if (ID.equalsIgnoreCase(doctor.getID())) {
                return false;
            }
        }
        return true;
    }

    // check input Date
    public static String checkDate() {
        Scanner sc = new Scanner(System.in);
        Date currentDay = new Date();
        while (true) {
            String date = sc.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                Date parseExpiredDay = sdf.parse(date);
                if (currentDay.after(parseExpiredDay)) {
                    throw new IllegalArgumentException();
                }
                return date;
            } catch (ParseException e) {
                System.out.println("-----------------");
                System.out.print("Date format is incorrect!! Please enter again: ");
            } catch (IllegalArgumentException i) {
                System.out.println("-----------------");
                System.out.print("This product is out of date!! Please enter again: ");
            }
        }
    }

    // check input Yes/No
    public static boolean checkInputYN() {
        while (true) {
            String result = checkString();
            if (result.toUpperCase().equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.toUpperCase().equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    // check weight
    public static float checkWeight() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                float num = Float.parseFloat(sc.nextLine().trim());
                if (num < 0 || num > 10) {
                    throw new IllegalArgumentException();
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("-----------------");
                System.out.println("Please input a number");
                System.out.print("Enter again: ");
            } catch (IllegalArgumentException i) {
                System.out.println("-----------------");
                System.out.println("This product is not available");
                System.out.print("Enter again: ");
            }
        }
    }

    // check place
    public static String checkPlace() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String str = sc.nextLine().trim();
                if (str.isEmpty()) throw new Exception();
                if (!(str.equalsIgnoreCase("Cold") || str.equalsIgnoreCase("Cool"))) {
                    throw new IllegalArgumentException();
                }
                return str;
            } catch (IllegalArgumentException i) {
                System.out.println("Invalid place");
                System.out.println("---------");
                System.out.print("Please try again: ");
            } catch (Exception e) {
                System.out.println("Input need to be not empty");
                System.out.println("---------");
                System.out.print("Please try again: ");
            }
        }
    }
}