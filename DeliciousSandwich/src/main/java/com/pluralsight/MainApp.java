package com.pluralsight;
import java.util.Scanner;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n== DELI-cious POS System ==");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

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

    public static void handleNewOrder(Scanner scanner) {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n--- ORDER MENU ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();

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
                    System.out.println("\n" + order.getSummary());

                    System.out.print("Confirm and save receipt? (yes/no): ");
                    String confirm = scanner.nextLine();
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
            size = scanner.nextLine();
            if (size.equals("4") || size.equals("8") || size.equals("12")) {
                break;
            } else {
                System.out.println("Invalid size. Please enter 4, 8, or 12.");
            }
        }

        String bread;
        while (true) {
            System.out.print("Choose bread type (white, wheat, rye, wrap): ");
            bread = scanner.nextLine().toLowerCase();
            if (bread.equals("white") || bread.equals("wheat") || bread.equals("rye") || bread.equals("wrap")) {
                break;
            } else {
                System.out.println("Invalid bread type. Please enter white, wheat, rye, or wrap.");
            }
        }

        System.out.print("Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        addMeatsToSandwich(scanner, sandwich);
        addCheesesToSandwich(scanner, sandwich);
        addToppingsToSandwich(scanner, sandwich);
        addSaucesToSandwich(scanner, sandwich);

        order.addSandwich(sandwich);
        System.out.println("\nSandwich added to order!");
    }

    public static void addMeatsToSandwich(Scanner scanner, Sandwich sandwich) {
        List<String> meats = Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon");

        while (true) {
            System.out.println("\nChoose a meat (type number or 'done'):");
            for (int i = 0; i < meats.size(); i++) {
                System.out.println((i + 1) + ") " + meats.get(i));
            }
            System.out.print("Selection: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) break;

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= meats.size()) {
                    String selected = meats.get(choice - 1);
                    sandwich.addMeat(selected);

                    System.out.print("Add extra " + selected + "? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        sandwich.addExtraMeat(selected);
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
        List<String> cheeses = Arrays.asList("american", "provolone", "cheddar", "swiss");

        while (true) {
            System.out.println("\nChoose a cheese (type number or 'done'):");
            for (int i = 0; i < cheeses.size(); i++) {
                System.out.println((i + 1) + ") " + cheeses.get(i));
            }
            System.out.print("Selection: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) break;

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= cheeses.size()) {
                    String selected = cheeses.get(choice - 1);
                    sandwich.addCheese(selected);

                    System.out.print("Add extra " + selected + "? (yes/no): ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        sandwich.addExtraCheese(selected);
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
        List<String> toppings = Arrays.asList("lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms");

        while (true) {
            System.out.println("\nChoose a topping (type number or 'done'):");
            for (int i = 0; i < toppings.size(); i++) {
                System.out.println((i + 1) + ") " + toppings.get(i));
            }
            System.out.print("Selection: ");
            String input = scanner.nextLine();

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
        List<String> sauces = Arrays.asList("mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette", "au jus", "sauce");

        while (true) {
            System.out.println("\nChoose a sauce (type number or 'done'):");
            for (int i = 0; i < sauces.size(); i++) {
                System.out.println((i + 1) + ") " + sauces.get(i));
            }
            System.out.print("Selection: ");
            String input = scanner.nextLine();

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
            System.out.print("Choose size (small, medium, large): ");
            size = scanner.nextLine().toLowerCase();
            if (size.equals("small") || size.equals("medium") || size.equals("large")) {
                break;
            } else {
                System.out.println("Invalid size. Please enter small, medium, or large.");
            }
        }

        List<String> flavors = Arrays.asList("cola", "lemonade", "orange", "water", "root beer");

        System.out.println("Choose a flavor:");
        for (int i = 0; i < flavors.size(); i++) {
            System.out.println((i + 1) + ") " + flavors.get(i));
        }

        String flavor = "";
        while (true) {
            System.out.print("Selection: ");
            String input = scanner.nextLine();

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
            String input = scanner.nextLine();

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

        Chips chips = new Chips(chipType);
        order.addChips(chips);
        System.out.println("Chips added to order!");
    }

}
