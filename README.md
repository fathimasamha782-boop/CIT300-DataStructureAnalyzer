# CIT300-DataStructureAnalyzer

## Project Description
A Java-based console application that demonstrates data structures, algorithms,
searching, graph concepts and algorithmic complexity. Developed for CIT300 Data
Structures and Algorithms - Graded Practical Assignment 2.

## Technologies Used
- Java
- Eclipse IDE
- Git and GitHub

## Main Features
- Array operations (Insert, Delete, Search, Display)
- Stack operations (Push, Pop, Peek, Display)
- Queue operations (Enqueue, Dequeue, Peek/Front, Display)
- Linked List operations (Insert, Delete, Search, Display)
- Searching (Linear Search, Binary Search)
- Graph operations (Add Vertex, Add Edge, Display, BFS, DFS)
- Performance comparison (steps and execution time)

## Team Members

## Member 1: Array and Searching

**Student Name:** Fathima Samha
**Student ID:** 23DA2-1074
**Assigned Responsibility:** Array and Searching Implementation

**Individual Contribution:**
- Implemented the Array class with insert, delete, search and display
- Implemented Linear Search and Binary Search
- Recorded the number of steps and execution time for the searches
- Added input validation and handled empty/full array conditions
- Integrated the Array, Searching and Performance Comparison menus into `Main.java`
- Used my own branch (`samha-array-search`), commits and pull request (PR #1) for collaboration




## Member 2: Stack and Queue

**Student Name:** Fathima Nusha
**Student ID:** 23DA2-1025
**Assigned Responsibility:** Stack and Queue Implementation

**Individual Contribution:**
- Implemented the Stack (`StackOperations.java`) with push, pop, peek and display
- Implemented the Queue (`QueueOperations.java`) with enqueue, dequeue, peek/front and display
- Handled empty-stack and empty-queue conditions without crashing
- Added input validation in the Stack and Queue submenus
- Wrote `StackQueueTest.java` to test edge cases
- Integrated the Stack and Queue menus into `Main.java` (options 2 and 3)
- Used my own branch(`feature/stack-queue` and `nusha/readme-member2`), commits and pull request (PR #3 and #4) for collaboration




## Member 3: Linked List

**Student Name:** MIF Shadha
**Student ID:** 23DA2-0769
**Assigned Responsibility:** Linked List Implementation

**Individual Contribution:**
- The Linked List component (`LinkedListOperations.java`) was implemented by Fathima Samha (23DA2-1074) on branch `samha/linked-list`, as this member was unable to contribute due to a laptop issue.




## Member 4: Graph Implementation and Traversal

**Student Name:** AFF Simra
**Student ID:** 23DA2-0917
**Assigned Responsibility:** Graph Implementation and Traversal

**Individual Contribution:**
- This member started the Graph component, but the version produced was incomplete and could not be integrated into the project.
- The final Graph component (`GraphOperations.java`) was therefore implemented by Fathima Nusha (23DA2-1025) on branch.
- The final Graph component includes add vertex, add edge, display graph, BFS traversal and DFS traversal. It is integrated into the main menu (option 6) and the Performance Comparison table (option 7).



## How to Run

### Requirements
- Java Development Kit (JDK) 8 or higher
- Eclipse IDE (recommended) or any terminal with `javac` and `java`

### Option 1: Run in Eclipse
1. Clone the repository: `git clone https://github.com/fathimasamha782-boop/CIT300-DataStructureAnalyzer.git`
2. In Eclipse, select **File > Import > General > Existing Projects into Workspace** and choose the cloned folder.
3. Open `src/dsanalyzer/Main.java`.
4. Click **Run** (or press Ctrl+F11).
5. Click inside the **Console** tab, type a menu number (1-9) and press Enter.

### Option 2: Run from the command line
1. Open a terminal in the project folder.
2. Compile: `javac -d bin src/dsanalyzer/*.java`
3. Run: `java -cp bin dsanalyzer.Main`

### Using the program
- Use the main menu to select a component: Array, Stack, Queue, Linked List, Searching, Graph, Performance Comparison.
- Each component has its own submenu. Choose "Return to Main Menu" to go back.
- To see the performance table, first run Searching (option 5, Compare) and Graph (option 6, BFS and DFS), then choose option 7.
- In the Graph menu, option 6 loads a sample graph (vertices A to F) for quick testing.




## Conclusion
This project is a Java console application that brings together the main data structures and algorithms studied in CIT300. It implements an array, stack, queue, singly linked list, linear and binary search, and a graph with BFS and DFS traversal, all connected through one menu-driven system with input validation and handling of empty structures.

The Performance Comparison table records the number of steps and the execution time of each algorithm. It shows that binary search needs fewer steps than linear search on sorted data (O(log n) compared with O(n)). It also shows that BFS and DFS have the same step count on the same graph, because both are O(V + E), while their visiting order differs because BFS uses a queue and DFS uses a stack.

Through this project the team practised object-oriented design, algorithm analysis, and collaboration on GitHub using branches, commits and pull requests.