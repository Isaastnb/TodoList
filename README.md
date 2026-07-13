# TodoList in Java

A lightweight, terminal-based (CLI) To-Do List manager built in Java.

> [!WARNING]
> **Work in Progress:** This project is currently under construction and active development.

## How it works
- **File storage:** The application stores tasks in a text file named `task.txt` in the `src/app` directory.
- **File structure:** The file is structured as follows:
```
task1;priority1;status1
task2;priority2;status2
task3;priority3;status3
```
- **File parsing:** The application reads the file and stores the tasks in memory.
- **File writing:** The application writes the tasks to the file when the application is closed.
- **Memory storage:** The application stores tasks in memory.
- **Priority logic:** The application stores priority as numbers (1, 2, 3) and converts them to text (High, Medium, Low) for display.


## Requirements & Run
- Java JDK 17 or higher
- To run the application, execute from the root directory:
  ```bash
  java -cp bin app.App
  ```
