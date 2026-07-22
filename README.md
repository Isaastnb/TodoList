# TodoList in Java

A lightweight CLI (Command Line Interface) To-Do List manager built in Java.

> [!NOTE]
> This project is currently under construction and active development.

## How it works
- **File storage:** The application stores tasks in a text file named `tasks.json` in the `src/app` directory.
- **File structure:** The file is structured as follows:
```json
[
    {
        "name":"task1",
        "priority":"priority1",
        "status":"status1"
    },
    {
        "name":"task2",
        "priority":"priority2",
        "status":"status2"
    },
    {
        "name":"task3",
        "priority":"priority3",
        "status":"status3"
    }
]
```
- **File parsing:** The application reads the file and stores the tasks in memory.
- **File writing:** The application writes the tasks to the file when the application is closed.
- **Memory storage:** The application stores tasks in memory.
- **Priority logic:** The application stores priority as numbers (1, 2, 3) and converts them to text (High, Medium, Low) for display.
- **Status logic:** The application stores status as numbers (0, 1) and converts them to text (PENDING ⏳️, DONE ✅) for display.


## Requirements
- Java JDK 17 or higher

## Run
To compile and run the application automatically, run from the root directory:
  ```bash
  ./run.sh
  ```

To compile and run it manually:
  ```bash
  javac -d bin -sourcepath src src/app/App.java && java -cp bin app.App
  ```
