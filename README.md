# Logical-Expressions-Nand-and-Nor-Logic-and-Logical-Simplification

## Introduction
Hypernymy (also called IS-A relation) is a semantic relation between two noun phrases, hypernym and hyponym, such that the hyponym is a subtype of the hypernym. For example, cat and dog are hyponym of animal because they are types of animals. Hypernym relations are hierarchical, so a word can have multiple hypernyms. For example, dog is a hyponym of animal, canine and mammal.
Many methods have been developed in the last decades in order to automatically construct a database of hypernym relations from large corpora.
A well-established approach to do so is using lexico-syntactic patterns, often called Hearst patterns (as the idea was introduced by Marti Hearst in this paper). For example, given the sentence "semitic languages such as Hebrew or Arabic are composed of consonants and voyels", we can infer that both Hebrew and Arabic are semitic languages. Such relations can be retrieved using a simple regular expression.


## Table of contents
* [UML Diagram of the project](#UML Diagram-of-the-project)
* [General Information](#general-information)
* [Installation](#installation)
* [Contact](#Contact)

## UML Diagram of the project
<img width="611" alt="image" src="https://user-images.githubusercontent.com/75027826/225859400-2153d649-aabb-4add-b9db-ae14a2f1a83b.png">

## General Information



## Installation
Before installing this project, you need to install on your computer:
* Git
* IDE such as Intellij, Eclipse, etc.
* JDK

Run the following command in the terminal:

```
git clone https://github.com/adi-ben-yehuda/Hearst-Patterns.git
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
