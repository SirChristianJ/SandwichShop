package com.pluralsight;
import java.util.*;

public class SandwichShop {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int sandwichPick = promptUserForPrice("Which sandwich type would you like? \n(1) Regular $5.45 || (2) Large $8.95: ");
        int userAge = promptUserForAge("Enter your age: ");
        double price = discountType(userAge, sandwichPick);
        price = loadedOption("Would you like the loaded option ? (Y)es or (N)o: ", price);
        System.out.println("Please pay: $" + String.format("%.2f" , price ));
    }

    public static int promptUserForPrice(String prompt){
        //Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        int sandwichPick = scanner.nextInt();
        return sandwichPick;
    }

    public static double loadedOption(String prompt, double newPrice){
        System.out.print(prompt);
        String userSelection = scanner.nextLine();

        if(userSelection.equals("Y")||userSelection.equals("y")){
            System.out.print("Pick between our (1) Regular option: $1.00 or (2) Large option: $1.75: ");
            int loadedSelection = scanner.nextInt();
            if(loadedSelection == 1) newPrice+=1.00;
            else if (loadedSelection == 2) newPrice+=1.75;
            else System.out.println("Selection available option, please!");
        }

        return newPrice;
    }

    public static int promptUserForAge(String prompt){
        //Scanner scanner = new Scanner(S)
        System.out.print(prompt);
        int userAge = scanner.nextInt();
        scanner.nextLine();

        return userAge;
    }

    public static double discountType(int age, int pick){
        double newPrice = 0.00;
        if(age <= 17 && pick == 1) newPrice = 5.45 - (5.45 * .10);
        else if (age<=17 && pick == 2) newPrice = 8.95 - (8.95 * .10);
        else if (age>=65 && pick == 1 ) newPrice = 5.45 - (5.45 * .10);
        else if (age>=65 && pick == 2 ) newPrice = 8.95 - (8.95 * .10);
        else{
            newPrice = (pick == 1) ? 5.45:8.95;
        }

        return newPrice;
    }
}
