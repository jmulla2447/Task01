# Java Task with NoSQL Database

## Intro

* This offline test was created to get a picture of your Java basics, necessary version control with Git as well as some algorithm solving skills.
* You're free to choose any Java-based technology or library you want. But do not use a library that solves the core problem for you.
* As storage, please use a NoSQL database like MongoDB.
* At least a CLI tool is expected with input given as a data file.
* Machine-readable output is preferred.

## Expectations

* We expect the use of Java 14 or higher.
* Make use of a build system and leave some documentation (even if you think it's obvious).
* We expect you to deliver appropriate documentation.
* Document your coding process with Git[^2] and publish your result to the given GitLab repository. We'll clone this repository to run your code locally on our machines.
* A README document on how to install and start your application, and optional build scripts to build and serve your application are a plus.
* Dont' expect us to use a specific operation system or IDE to run your solution. We just have a Linux or Windows PC and Java 11+ plus internet connection. (Of course we can use Maven, Gradle, Ant and the like.)
* If you have any questions, do not hesitate to contact us[^1].

### Notes on Version Control

* The result in GitLab should be a Git history of your development process. (A single commit with the complete application is not acceptable. We want to see multiple commits showing your progress.)
* Please create a branch for each task, e.g. `task/01-the-camera`, branching from the (to be created) `develop` branch.
* Please create a merge/pull request to `develop` when done and assign it to @expertsieve.
* You are allowed to merge between task branches.
* If you cannot finish a task or have an issue during implementation, try to explain it in the pull request description and/or `README` file.

# Tasks

## Task 1 - The Camera

Suppose we have a binary camera that delivers a picture of a table and items on it as a matrix of `0`s and `1`s.
This input data describes isolated items on a table: `0` identifies the table (or just "no item"), whereas `1` identifies
an item.

Connected `1`s belong to the same item. They connect horizontally and vertically only.

For example, in this diagram we have three items.

```
11100
11001
10011
00100
```

The following diagram visually separates them to make it clearer:
```
111  00
11  00 1
1  00 11
00 1  00
```

The input data is given in a file as a matrix of `0`s and `1`s. Example files are included in the `examples` folder.

- Write code that takes a data file as input and stores it in a database.
- Write code that takes any given matrix from the database and returns the number of items (islands of `1`) on the table.

Test your solution.

### Clarifications

* We expect all operations to be runnable via CLI.
* Please do not implement your solution in the `main` function.
* The input in the file is always a rectangle (number of columns per row is constant).
* The input in the file is never empty.
* Think about memory and CPU usage.
* You might want to upload/import more than one matrix to the database.
* You might have to address matrixes for the calculation.

## Task 2 - The Details

Based on Task 1, we now connect items that have diagonal touchpoints as well. Thus, for the example given in Task 1
we have just two items, as the single `1` touches the right item - they now belong together.

Write another method that takes a matrix as in Task 1 as input and **returns a collection of data points** for each
item. Bottom left is `(0,0)` with x indicating the horizontal position and y the vertically position.

**Expected result** based on the sample graph of Task 1:
```java
// one line per item
(2,0), (3,1), (4,1), (4,2)  // item in the bottom right
(0,1), (0,2), (1,2), (0,3), (1,3), (2,3)  // item in the top left
```

Test your solution.

### Clarifications

* Re-use of Task 1 is allowed.
* Your method must return a collection; just printing is not allowed.
* Your solution shall write a result file with the given format.
* The order of points in the result is not important; however it must be clear, which points belong together.
* All clarifications of Task 1 apply as well.
* Your input data always comes from the database.

## Resources

[^1]: support@fyltura.de
[^2]: https://git-scm.com