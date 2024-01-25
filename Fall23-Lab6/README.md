[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/2ofcJ6AK)
[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/kDKBZkp4)
# COMP 132, Fall 2023

# IMPORTANT

For each lab assignment, **you must include and sign (by writing your name and student ID number) the following Pledge of Honor statement at the **TOP of your Test.java class (if you do not do this, you will get zero)** source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```
## IMPORTANT NOTE 2: After you complete the tasks, do not forget to commit your changes and push them to your repository on GitHub.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# Lab-6 Prelab - Online Shopping System

![](/img/shopping.png?raw=true "")

In this lab, you create a demo of an online shopping system, which has products, people to buy the products, and stores which sell products. 

All classes except for `Test.java` should be in a package called `shopping`.

## Product Class

This class must implement the Comparable interface.

### Instance Variables
```
    - int rating
    - double price
    - int weight
    - double shipCost
    - int numSold
```

### Methods
- Create getters/setters for all fields.

- **public Product(int rating, double price, int weight, double shipCost)**: Constructor.

- **public Product()**: Initialize all variables to 0.

- **public void sell(int sold)**: Increases numSold by sold.

- **public double totalCost()**: Calculates the total cost by the following way: totalCost = price + weight * shipCost.

- **public boolean proper()**: Returns true if rating >= 16 and price <= 1000. Otherwise return false.

- **public int compareTo(Product p2)**: A product p1 is greater than a product p2 if price * numSold + numSold * weight * shipCost of p1 is greater than p2.

- **public static String toString(ArrayList\<Product\> listOfProducts)**: Produce a string which displays all products in the list, sorted using the compareTo method defined above.

## Retailer Class

### Instance Variables

```
    - String name
    - int id
    - LinkedList<Product> shoplist: list of products the retailer has bought.
    - double moneyOwed: how much money the retailer currently owes.
```

### Methods
- **public Retailer(String name, int id)**: Should initialize shoplist to be empty, and moneyOwed to be 0.
- Getters/setters for all fields including shoplist.
- **public boolean addProduct(Product product)**: Check the result of the proper() method of the product. If true, add the product to shoplist, display a message saying the product was added, add the price of the product to moneyOwed, and return true. Otherwise, display a message saying that the product isn't suggested, and return false.
- **public boolean removeProduct()**: Checks the moneyOwed field, and if moneyOwed > 4000, remove the 3rd product from shoplist. Use exception handling to make sure that an IndexOutOfBoundsException does not occur if there are less than 3 products in the shoplist. If a product was removed, return true. Otherwise, return false. Make sure to update moneyOwed after removing the product.
- **public static String toString(ArrayList<Retailer> list)**: Takes an arraylist of retailers, and returns a string containing the name/id/moneyOwed of each retailer on a different line, as well as the value calculated in the RetailerComparator class below.


## Store Class

### Instance Variables
```
    - String name
    - HashMap<Retailer, Integer> map: Associates to each retailer the number of products that the store has bought from that retailer.
```


### Methods
- **public Store(String name)**: Be sure to initialize map to be empty.
- Getter/setter method for the name variable.
- **public void addRetailer(Retailer r, int itemCount)**: Adds the retailer r with the given itemCount to the map.
- **public ArrayList<String> multishoppers(HashMap<Retailer, Integer> shopStore)**: Compares the current map to the map of another store, and determines the names of the retailers which are available in both stores. The arraylist you return should be sorted in alphabetical order.


## RetailerComparator Class

Must implement the `Comparator<Retailer>` class. You may refer to `https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html`.

### Methods
- **public int compare(Retailer r1, Retailer r2)**: Compares two retailers in the following way: For each retailer, calculate the sum of the cost of each product in the shoplist, divided by the number of elements in the shoplist. r1 > r2 if this value is larger for r1 than for r2, and so on.

## Test Class
This class contains the main method. You will be required to make some changes in this file to finish the following TODO comments:
- TODO 1: Create two arraylists of Products called `listOfProducts` and `listOfProperProducts`.

- TODO 2: Check all the products in `listOfProducts` and if `proper()` returns true for that product, add it to `listOfProperProducts`.

- TODO 3: Sort the list of proper products using the `Collections.sort()` method.

- TODO 4: Use the `toString()` method of the Product class to display all products in `listOfProducts`.

- TODO 5: Use the `toString()` method of the Product class to display all proper products in `listOfProperProducts`.

- TODO 6: Use the `removeGood()` method of the Retailer class to remove all duplicate products of all retailers.

- TODO 7: Use `toString()` method of Product class to dislay the sorted list of all products.

- TODO 8: Create two Store objects: `center1` and `center2` with names `Center1` and `Center2`.

- TODO 9: Using the `multishoppers()` method of the Store class to find retailers shopping from both `center1` and `center2`.

- TODO 10: Create an arraylist of retailers called `retailerList`, and a RetailerComparator class called `retailerComp`.

- TODO 11: Sort `retailerList` using `retailerList.sort()` and providing the comparator `retailerComp`.

- TODO 12: Print out the sorted `retailerList`.

# Example Output

```
List of Products are as follow:
Rating = 16, price = 1000.0, total cost = 1600.0
Rating = 32, price = 1000.0, total cost = 1120.0
Rating = 16, price = 1000.0, total cost = 1070.0
Rating = 32, price = 950.0, total cost = 1250.0
Rating = 16, price = 320.0, total cost = 368.0
Rating = 4, price = 850.0, total cost = 898.0
Rating = 32, price = 900.0, total cost = 1180.0
Rating = 16, price = 650.0, total cost = 980.0
Rating = 64, price = 2100.0, total cost = 2250.0
Rating = 2, price = 300.0, total cost = 390.0
Rating = 12, price = 600.0, total cost = 810.0

---------------------------------
List of proper Products are as follow:
Rating = 16, price = 320.0, total cost = 368.0
Rating = 16, price = 1000.0, total cost = 1070.0
Rating = 32, price = 1000.0, total cost = 1120.0
Rating = 32, price = 900.0, total cost = 1180.0
Rating = 32, price = 950.0, total cost = 1250.0
Rating = 16, price = 650.0, total cost = 980.0
Rating = 16, price = 1000.0, total cost = 1600.0

----------------------------------------------
A product was added to the shoplist of Ali
A product was added to the shoplist of Ali
A product was added to the shoplist of Ali
A product was added to the shoplist of Ali
A product was added to the shoplist of Ali
We do not recommend this product
A product was added to the shoplist of Efe
A product was added to the shoplist of Mete
A product was added to the shoplist of Mete
A product was added to the shoplist of Ahmet
A product was added to the shoplist of Ahmet
A product was added to the shoplist of Ahmet
A product was added to the shoplist of Ahmet
A product was added to the shoplist of Ahmet
We do not recommend this product
----------------------------------------------
The shopper  Ali  should pay  4270.0
The shopper  Ahmet  should pay  3870.0
The shopper  Efe  should pay  320.0
The shopper  Mete  should pay  1270.0
----------------------------------------------
A product was removed from Ali
The Retailer   Ali  should pay 3270.0
The Retailer   Ahmet  should pay 3870.0
The Retailer   Efe  should pay 320.0
The Retailer   Mete  should pay 1270.0
----------------------------------------------
List of Products after sort are as follow:
Rating = 16, price = 320.0, total cost = 368.0
Rating = 4, price = 850.0, total cost = 898.0
Rating = 16, price = 1000.0, total cost = 1070.0
Rating = 2, price = 300.0, total cost = 390.0
Rating = 32, price = 1000.0, total cost = 1120.0
Rating = 64, price = 2100.0, total cost = 2250.0
Rating = 12, price = 600.0, total cost = 810.0
Rating = 32, price = 900.0, total cost = 1180.0
Rating = 32, price = 950.0, total cost = 1250.0
Rating = 16, price = 650.0, total cost = 980.0
Rating = 16, price = 1000.0, total cost = 1600.0

----------------------------------------------
[Ahmet, Ali]
Name: Efe, id: 3, moneyOwed: 320.0, score: 320.0
Name: Mete, id: 4, moneyOwed: 1270.0, score: 635.0
Name: Ahmet, id: 2, moneyOwed: 3870.0, score: 774.0
Name: Ali, id: 1, moneyOwed: 3270.0, score: 817.5
```

## Submission Instructions

After finishing each class, you should push your changes to GitHub Classroom. We will be checking the commit logs to verify this.

This pre-lab must be finished before 10 a.m. Friday, when the lab starts. Any questions can be answered by attending the office hours of one of the TAs/SLs, or emailing one of us.