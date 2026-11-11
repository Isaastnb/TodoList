# TodoList in Java

A lightweight command-line to-do list manager built with Java. Tasks are stored
in a local SQLite database.

## Features

- Add tasks with a name and priority.
- List tasks with their database ID, priority, and status.
- Mark a task as completed by its ID.
- Delete a task by its ID.
- Generate task IDs automatically. When the task table is empty, the next task
  starts again at ID `1`.
- Sort tasks by priority and then by ID when listing them.

## How it works

The application creates a `tasks` table in `tasks.db` in the working directory
when it starts. SQLite stores each task's ID, name, priority, status, and
creation timestamp.

Priorities are stored as numbers:

| Value | Priority |
| --- | --- |
| 1 | High |
| 2 | Medium |
| 3 | Low |

Task status is stored as `0` for pending and `1` for completed.

## Requirements

- Java JDK 21 or higher
- Maven

## Run

From the project root, run:

```bash
mvn compile exec:java -Dexec.mainClass=app.App
```

The SQLite database file (`tasks.db`) is created in the current working
directory if it does not already exist.
