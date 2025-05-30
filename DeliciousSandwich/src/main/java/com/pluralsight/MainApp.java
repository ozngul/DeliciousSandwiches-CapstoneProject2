package com.pluralsight;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main menu loop
        while (running) {
            System.out.println("\n== DeliciousSandwich POS System ==");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    handleNewOrder(scanner);
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
    // Handles the full ordering process
    public static void handleNewOrder(Scanner scanner) {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n--- ORDER MENU ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Add Cookies");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    addSandwichMenu(scanner, order);
                    break;
                case "2":
                    addDrinkMenu(scanner, order);
                    break;
                case "3":
                    addChipsMenu(scanner, order);
                    break;
                case "4":
                    addCookiesMenu(scanner, order);
                    break;
                case "5":
                    System.out.println("\n" + order.getSummary());
                    System.out.print("Confirm and save receipt? (yes/no): ");
                    String confirm = scanner.nextLine().trim();
                    if (confirm.equalsIgnoreCase("yes")) {
                        ReceiptManager.saveReceipt(order);
                    } else {
                        System.out.println("Order not saved.");
                    }
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void addSandwichMenu(Scanner scanner, Order order) {
        System.out.println("\n== Add a Sandwich ==");

        String size;
        while (true) {
            System.out.print("Choose a size (4, 8, 12): ");
            size = scanner.nextLine().trim();
            if (size.equals("4") || size.equals("8") || size.equals("12")) {
                break;
            } else {
                System.out.println("Invalid size. Please enter 4, 8, or 12.");
            }
        }

        String bread;
        while (true) {
            System.out.print("Choose bread type (White, Wheat, Rye, Wrap): ");
            bread = scanner.nextLine().toLowerCase().trim();
            if (bread.equals("white") || bread.equals("wheat") || bread.equals("rye") || bread.equals("wrap")) {
                break;
            } else {
                System.out.println("Invalid bread type. Please enter white, wheat, rye, or wrap.");
            }
        }

        boolean toasted = false;
        while (true) {
            System.out.print("Toasted? (yes/no): ");
            String toastInput = scanner.nextLine().trim().toLowerCase();
            if (toastInput.equals("yes")) {
                toasted = true;
                break;
            } else if (toastInput.equals("no")) {
                toasted = false;
                break;
            } else {
                System.out.println("Invalid input. Please type 'yes' or 'no'.");
            }
        }

        Sandwich sandwich = new Sandwich(size, bread, toasted);

// Prompt the user to customize their sandwich by selecting ingredients:
// 1. Meats: The user can choose one or more meats, and optionally add extra portions.
// 2. Cheeses: The user selects cheeses, with the option for extra cheese on each.
// 3. Toppings: The user chooses vegetable toppings like lettuce, tomato, pickles, etc.
// 4. Sauces: The user picks from a list of sauces to add flavor to their sandwich.
        addMeatsToSandwich(scanner, sandwich);
        addCheesesToSandwich(scanner, sandwich);
        addToppingsToSandwich(scanner, sandwich);
        addSaucesToSandwich(scanner, sandwich);

        // After all ingredients have been selected, the completed sandwich is added to the order.
        order.addSandwich(sandwich);
        System.out.println("\nSandwich added to order!");
    }

    public static void addMeatsToSandwich(Scanner scanner, Sandwich sandwich) {
        List<String> meats = Arrays.asList("Steak", "Ham", "Salami", "Sucuk", "Chicken", "Turkey");

        while (true) {
            System.out.println("\nChoose a meat (type number or 'done'):");
            for (int i = 0; i < meats.size(); i++) {
                System.out.println((i + 1) + ") " + meats.get(i));
            }
            System.out.print("Selection: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) break;

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= meats.size()) {
                    String selected = meats.get(choice - 1);
                    sandwich.addMeat(selected);

                    System.out.print("Add extra " + selected + "? (yes/no): ");
                    String extraInput = scanner.nextLine().trim().toLowerCase();
                    if (extraInput.equals("yes")) {
                        sandwich.addExtraMeat(selected);
                    } else if (!extraInput.equals("no")) {
                        System.out.println("Invalid input. Please type 'yes' or 'no'.");
                    }
                } else {
                    System.out.println("Invalid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public static void addCheesesToSandwich(Scanner scanner, Sandwich sandwich) {
        List<String> cheeses = Arrays.asList("American", "Provolone", "Cheddar", "Swiss");

        while (true) {
            System.out.println("\nChoose a cheese (type number or 'done'):");
            for (int i = 0; i < cheeses.size(); i++) {
                System.out.println((i + 1) + ") " + cheeses.get(i));
            }
            System.out.print("Selection: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) break;

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= cheeses.size()) {
                    String selected = cheeses.get(choice - 1);
                    sandwich.addCheese(selected);

                    System.out.print("Add extra " + selected + "? (yes/no): ");
                    String extraInput = scanner.nextLine().trim().toLowerCase();
                    if (extraInput.equals("yes")) {
                        sandwich.addExtraCheese(selected);
                    } else if (!extraInput.equals("no")) {
                        System.out.println("Invalid input. Please type 'yes' or 'no'.");
                    }
                } else {
                    System.out.println("Invalid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public static void addToppingsToSandwich(Scanner scanner, Sandwich sandwich) {
        List<String> toppings = Arrays.asList("lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "olives", "mushrooms");

        while (true) {
            System.out.println("\nChoose a topping (type number or 'done'):");
            for (int i = 0; i < toppings.size(); i++) {
                System.out.println((i + 1) + ") " + toppings.get(i));
            }
            System.out.print("Selection: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) break;

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= toppings.size()) {
                    sandwich.addRegularTopping(toppings.get(choice - 1));
                } else {
                    System.out.println("Invalid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public static void addSaucesToSandwich(Scanner scanner, Sandwich sandwich) {
        List<String> sauces = Arrays.asList("Mayo", "Mustard", "Ketchup", "Ranch", "Bbq", "Vinaigrette", "Chipotle", "Buffalo");

        while (true) {
            System.out.println("\nChoose a sauce (type number or 'done'):");
            for (int i = 0; i < sauces.size(); i++) {
                System.out.println((i + 1) + ") " + sauces.get(i));
            }
            System.out.print("Selection: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) break;

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= sauces.size()) {
                    sandwich.addSauce(sauces.get(choice - 1));
                } else {
                    System.out.println("Invalid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public static void addDrinkMenu(Scanner scanner, Order order) {
        System.out.println("\n== Add a Drink ==");
        String size;
        while (true) {
            System.out.print("Choose size (Small, Medium, Large): ");
            size = scanner.nextLine().toLowerCase().trim();
            if (size.equals("small") || size.equals("medium") || size.equals("large")) {
                break;
            } else {
                System.out.println("Invalid size. Please enter small, medium, or large.");
            }
        }

        List<String> flavors = Arrays.asList("Cola", "Lemonade", "Orange", "Ayran", "Water");

        System.out.println("Choose a flavor:");
        for (int i = 0; i < flavors.size(); i++) {
            System.out.println((i + 1) + ") " + flavors.get(i));
        }

        String flavor = "";
        while (true) {
            System.out.print("Selection: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= flavors.size()) {
                    flavor = flavors.get(choice - 1);
                    break;
                } else {
                    System.out.println("Invalid number. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }

        Drink drink = new Drink(size, flavor);
        order.addDrink(drink);
        System.out.println("Drink added to order!");
    }
    // We pass Scanner and Order as parameters so the method works with the current context.
    //This keeps the code clean and avoids unexpected behavior
    public static void addChipsMenu(Scanner scanner, Order order) {
        System.out.println("\n== Add Chips ==");

        List<String> chipOptions = Arrays.asList("Doritos", "Lays", "Cheetos", "Ruffles", "Pringles");

        System.out.println("Choose a chip type:");
        for (int i = 0; i < chipOptions.size(); i++) {
            System.out.println((i + 1) + ") " + chipOptions.get(i));
        }

        String chipType = "";
        while (true) {
            System.out.print("Selection: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= chipOptions.size()) {
                    chipType = chipOptions.get(choice - 1);
                    break;
                } else {
                    System.out.println("Invalid number. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
//This line creates a new Chips object using the selected chip type (e.g., "Doritos", "Lays").
//The variable chipType holds the user's choice, and that value is passed to the Chips constructor.
        Chips chips = new Chips(chipType);
        order.addChips(chips);
        System.out.println("Chips added to order!");
    }
    public static void addCookiesMenu(Scanner scanner, Order order) {
        System.out.println("\n== Add Cookies ==");

        List<String> cookieOptions = Arrays.asList("Chocolate Chip", "Oatmeal", "Peanut Butter", "Sugar", "Double Chocolate");

        System.out.println("Choose a cookie type:");
        for (int i = 0; i < cookieOptions.size(); i++) {
            System.out.println((i + 1) + ") " + cookieOptions.get(i));
        }

        String cookieType = "";
        while (true) {
            System.out.print("Selection: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= cookieOptions.size()) {
                    cookieType = cookieOptions.get(choice - 1);
                    break;
                } else {
                    System.out.println("Invalid number. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }

        Cookies cookies = new Cookies(cookieType);
        order.addCookies(cookies);
        System.out.println("Cookies added to order!");
    }
}
