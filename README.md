# Functional Programming Exercises

This project contains exercises in Functional Programming and the Stream API using Java.

## Part 1 - Functional Programming

- Creating functional interfaces
- Using lambda expressions
- Working with Predicate and Consumer
- Combining conditions using AND, OR and NOT
- Filtering people using custom methods
- Processing people with PersonProcessor

## Part 2 - Stream API

- Filtering people
- Mapping names
- Counting adults
- Sorting people by age
- Finding the first matching person
- Combining filter conditions
- Finding unique and sorted values
- Formatting person information
- Generating email addresses

## Reflection

**1. Which solutions were easier to read: loop-based or stream-based?**

I found loops easier to understand because I am more familiar with them. Streams were a little harder for me to follow, especially when several operations were chained together. I can see that streams can make the code shorter, but I still need more practice to understand them properly.

**2. Which operations felt like transformations and which felt like side effects?**

I am still learning the difference between transformations and side effects. From these exercises, I understood that operations like `map()` change or transform the data, while `forEach()` performs an action, such as printing something to the console. I need more practice to become confident with this distinction.

**3. Where did Predicate, Function and Consumer fit naturally?**

I found `Predicate` easier to understand because we used it to check conditions, such as whether a person was active or an adult. I understood that `Consumer` was used for actions, such as printing a person's name. `Function` was a little less clear to me, but I could see how it was used to transform information, such as getting a person's name or creating an email address. I would like to practise these concepts more.

## Technologies

- Java
- Maven
- IntelliJ IDEA

## Running the project

Run the `Main` class to execute the exercises and see the results in the console.