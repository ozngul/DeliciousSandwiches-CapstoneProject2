# DeliciousSandwich POS System

**DeliciousSandwich** is a Java console-based Point of Sale (POS) application designed for a sandwich shop.
It allows customers to build customized sandwich orders, add drinks and chips, and receive a detailed receipt.
This project was developed as part of a Java capstone at the **Year Up Application Development** program.

---

## Features

* Create fully customizable sandwich orders:

  * Select size (4", 8", 12"), bread type, and toasted option
  * Choose meats, cheeses (with optional extras), toppings, and sauces
* Add drinks by selecting size and flavor
* Add chips from a predefined list
* Automatically calculates total price based on selections
* Generates a full receipt and saves it as a `.txt` file
* Built using Object-Oriented Programming principles

---

## Technologies Used

* Java
* OOP: Inheritance, Interface, Abstract Class
* File I/O (`BufferedWriter` / `FileWriter`)
* Java Collections (`ArrayList`, `HashMap`)
* `Scanner` for user input

---

## Sample Output

```
== DeliciousSandwich POS System ==
1) New Order
0) Exit
Choose an option: 1

--- ORDER MENU ---
1) Add Sandwich
2) Add Drink
3) Add Chips
4) Checkout
0) Cancel Order
Choose an option:

===== DeliciousSandwich Order Receipt =====
Order Time: 2025-05-30 00:24:07
------------------------------------

--- Sandwiches ---
4" white sandwich [Toasted]
Meats: [steak, ham, chicken]
Extra Meats: {chicken=1}
Cheeses: [american]
Extra Cheeses: {american=1}
Toppings: [lettuce, peppers, onions, tomatoes]
Sauces: [mayo]
Total: $10.05

------------------------------------
Total: $10.05
====================================
```

---

## Project Structure

```
src/
└── com/pluralsight/
    ├── MainApp.java
    ├── Order.java
    ├── Sandwich.java
    ├── Drink.java
    ├── Chips.java
    ├── MenuItem.java
    ├── Pricable.java
    └── ReceiptManager.java
```

---

## Author

**Ozan Gul**
Capstone Project – Year Up Application Development Track
