# Java Task with NoSQL Database

## Prerequisites:

* Java version : Java 17
* Docker for MongoDB : 20.10.24
* Maven :  3.2.0

### Deployment of the Application:
1) Docker based MongoDB Deployment:
* Execute the following command to start a MongoDB container:
  arduino
   ```
   docker run -d -p 27017:27017 --name mongo_db mongo:latest
   ```
* From project root directory, execute mvn command that create executable jar file
   ```
   mvn clean package
   ```
* Once the MongoDB container is running and executable jar file is created, proceed to execute the application.
   ```
   java -jar okapi-camera.jar
   ```
2) If MongoDB already installed on a separate server(Not as Docker) then inject mongodb instance details using command line argument:
* Run the application using the following command, providing the path to the application.yml file that contains the MongoDB host, port, and other information
   ```
   java -jar -Dspring.config.location=/path/to/application.yml okapi-camera.jar
   ```
* Ensure that the application.yml file is correctly configured with the MongoDB connection details for the okapi-camera.jar to establish a connection with the MongoDB server.

### Usage and Example
Once the MongoDB container is running, proceed to execute the application.
1) Task1-Part1 add matrix data from file to DB command :

   **CMD Information :** Use the add command followed by the directory path where the camera matrix data file is located, along with the desired file name. This command will insert the data into MongoDB. If the specified directory path or file is not found, an exception will be logged, and the interactive module will prompt for the next input.

   **CMD Syntax :** add <directory_path> <file_name>

   **CMD Argument description :**

   As per above example, add need directory information where data camera matrix data file is present then use data to
   inserted into MongoDB.

   If directory path or file specified as argument is not present then it log exception and interactive module ask for next
   input.

   **Output Example :**
   ```
      2023-07-03 13:42:02.020  INFO 63319 --- [           main] com.okapi.org.validate.impl.AddCommand   : Enter a command (add, fetch) or 'exit' to quit1 :
      2023-07-03 13:42:02.020  INFO 63319 --- [           main] com.okapi.org.validate.impl.AddCommand   : ===============================================
      add /Users/javedmulla/Downloads/Task01/examples example3.data
   ```
2) Task1-Part2 Count of items (island of 1's connected orthogonally)

   **CMD Information :** The fo command fetches the orthogonal matrix data.

   **CMD Example :** fo

   **CMD Argument description :**
   No arguments is required

   **Output Example :**
   ```
      2023-07-03 13:43:33.130  INFO 63319 --- [           main] com.okapi.org.validate.impl.AddCommand   : ===============================================
      fo
      2023-07-03 13:43:40.735 DEBUG 63319 --- [           main] o.s.data.mongodb.core.MongoTemplate      : find using query: {} fields: Document{{}} for class: class com.okapi.org.model.entity.MatrixEntity in collection: camera_matrix
      2023-07-03 13:43:40.755  INFO 63319 --- [           main] c.okapi.org.validate.impl.FetchCommand   : Total count for Orthogoanl Matrix Data is 63.
   ```

3) Task2 vertices of items  (island of 1's connected orthogonally or diagonally)

   **CMD Information :** The fd command fetches the diagonal matrix information.

   **CMD Example :** fd

   **CMD Argument description :**
   No arguments is required
   **Output Example :**
   ```
      2023-07-03 13:43:09.448  INFO 63319 --- [           main] com.okapi.org.validate.impl.AddCommand   : ===============================================
      fd
      2023-07-03 13:43:40.735 DEBUG 63319 --- [           main] o.s.data.mongodb.core.MongoTemplate      : find using query: {} fields: Document{{}} for class: class com.okapi.org.model.entity.MatrixEntity in collection: camera_matrix
      2023-07-03 13:43:33.130  INFO 63319 --- [           main] c.okapi.org.validate.impl.FetchCommand   : Total count for Diagonal Matrix Data is 43.
   ```
4) Exit command
   **CMD Information :** Used for exit from the application

   **CMD Example :** exit or Exit (lower or caps)

   **CMD Argument description :**
   No arguments is required
   **Output Example :**
   ```
      2023-07-03 13:43:09.448  INFO 63319 --- [           main] com.okapi.org.validate.impl.AddCommand   : ===============================================
      exit
   ```
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
```
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
