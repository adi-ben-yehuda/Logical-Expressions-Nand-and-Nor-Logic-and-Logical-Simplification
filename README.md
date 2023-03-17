# Logical-Expressions-Nand-and-Nor-Logic-and-Logical-Simplification

## Introduction
This system can represent nested logical expressions that include variables, evaluate their values for specific variable assignments, convert them, and simplify the results.


## Table of contents
* [Class Hierarchy](#Class-Hierarchy)
* [General Information](#general-information)
* [Installation](#installation)
* [Contact](#Contact)

## Class Hierarchy
<img width="611" alt="image" src="https://user-images.githubusercontent.com/75027826/225859400-2153d649-aabb-4add-b9db-ae14a2f1a83b.png">

## General Information
### Part 1 - Logical Expressions
The goal is to represent logical expressions such as:
~~~
~((T & (x | y))^x)
~~~
Where T is a value of "True", the ~,|,&,^, symbols denotes the "not","or","and" and "xor" operators respectively, and x and y are variables.

The unary expressions are:
* Var("x") indicating that x is a variable.
* Not(x) indicating the negation of the value of x.

The binary expressions are:
* Or(x,y) indicating the "or" of x, y.
* And(x,y) indicating the "and" of x, y.
* Xor(x,y) indicating the "xor" of x, y.

We also have a Val(F) expression indicating the logical value "False".

Once we have an expression, we would like to be able to:
* Get a nice and readable string representation.
* Ask about the variables in the expression.
* Assign values to variables.
* Evaluate its value for a given variable assignment to values.

### Part 2 - Nandify and Norify
We can now create expressions, get their variables, and evaluate them with given variable assignments.

In this part we will also convert them to logically equal expressions according to this logic:
* [Wikipedia page for Nand Logic](https://en.wikipedia.org/wiki/NAND_logic)
* [Wikipedia page for Nor Logic](https://en.wikipedia.org/wiki/NOR_logic)

### Part 3 - Simplification
Logical expression can be quite messy and contain many "redundant" parts. Therefore, we need to "simplify" the expression to make it more friendly to humans. The solution is to add another method to the Expression interface. This method will return a new expression which is a simplified version of the current one.

## Installation
Before installing this project, you need to install on your computer:
* Git
* IDE such as Intellij, Eclipse, etc.
* JDK

Run the following command in the terminal:

```
git clone https://github.com/adi-ben-yehuda/Logical-Expressions-Nand-and-Nor-Logic-and-Logical-Simplification.git
```

There are two options to run this project. 
### Option 1:
1. open the project using any IDE.
2. Create a configuration with ExpressionsTest as the Main Class.
3. Run the project.

### Option 2: 
Install [Apache Ant](https://ant.apache.org/bindownload.cgi)
Run the following command in the terminal:

```
ant run
```

## Contact
Created by @adi-ben-yehuda - feel free to contact me!
