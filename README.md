# Mongodb

[![Build Status](https://travis-ci.org/DistributedTeam/MongoDB.svg?branch=master)](https://travis-ci.org/DistributedTeam/MongoDB)

[![Build status](https://ci.appveyor.com/api/projects/status/acsscyxg9rn31m9s?svg=true)](https://ci.appveyor.com/project/xpdavid/mongodb)

[![Coverage Status](https://coveralls.io/repos/github/DistributedTeam/MongoDB/badge.svg?branch=master)](https://coveralls.io/github/DistributedTeam/MongoDB?branch=master)


### General Instruction

This project is built using `gradlew`. 

For Windows users, use `gradlew.bat` at project root. 

For Linux/Mac users, use `gradlew` at project root. 

In the following sections, this script is referred to generally as `gradlew`.

### Prerequisite
- MongoDB
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and above

For Windows users, ensure that paths to Java 8 are correctly added to `System Properties` > `Advanced` > `Environment Variables` > `PATH`.

### Prepare and Denormalize Data
Download zipped data files from [http://www.comp.nus.edu.sg/~cs4224/cs4224-project-files.zip](http://www.comp.nus.edu.sg/~cs4224/cs4224-project-files.zip).

Unzip the data files and put them under folder `project-files` at project root.

Run command `gradlew massage:run`.

### Import Data To Project

Make sure `gradlew massage:run` command is executed successfully before this step.

The `gradlew` script assumes by default that MongoDB runs on IP address `127.0.0.1:27017`. 

To change default IP address, change `cassandra.ip` in file `import/project.properties`. 

If more than one node is involved, the IP address could be from any one of the nodes.

Run command `gradlew import:all`.

This command performs `import:dropCollection` and `import:importData` sequentially. 

### Run Client

WIP


**New Transaction: `N`**

Format

    N, W_ID, D_ID, C_ID, NUM_ITEMS
	ITEM_NUMBER[i], SUPPLIER_WAREHOUSE[i], QUANTITY[i]
> Process a new transaction from a custormer.
> 
> Note that 1 <= NUM_ITEMS <= 20, i ∈ [1,NUM ITEMS]

Examples:

    N,347,7,7,3
    14,10,68
    283,7,40
    312,12,10


**Payment Transaction: `P`**

Format

    P, W_ID, D_ID, C_ID, PAYMENT

> Process a payment made by a customer.

**Delivery Transaction: `D`**

Format

    D, W_ID, CARRIER_ID

> Process the delivery of the oldest yet-to-be-delivered order for each of the 10
districts in a specified warehouse.   

**Order-Status Transaction: `O`**

Format

    O, W_ID, D_ID, C_ID

> Query the status of the last order of a customer

**Stock-level Transaction: `S`**

Format
    S, W_ID, D_ID, T, L

> Examine the items from the last L orders at a specified warehouse district and reports the number of those items that have a stock level below a specified threshold.

**Popular-Item Transaction: `I`**

Format

    I, W_ID, D_ID, L

> Find the most popular item(s) in each of the last L orders at a specified warehouse district. 
> Given two items X and Y in the same order O, X is defined to be more popular than Y in O if the quantity ordered for X in O is greater than the quantity ordered for Y in O.

**Top-Balance Transaction: `T`**

Format

     T     
> Find the top 10 customers ranked in descending order of their outstanding balance payments.

### Verification

To verify that the project is correctly set up, refer to [`test.md`](test.md) at project root for more details.
