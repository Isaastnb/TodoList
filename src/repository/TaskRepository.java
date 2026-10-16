package repository;

import database.Database;
import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskRepository {

    public void save(Task task) {
        String sql = """
            INSERT INTO tasks (name, priority, status)
            VALUES (?, ?, ?)
            """;

        try (
            Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, task.getName());
            statement.setInt(2, task.getPriorityValue());
            statement.setInt(3, task.getStatus());

            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("Erro ao salvar tarefa: " + exception.getMessage());
        }
    }

    public ArrayList<Task> findAll() {
        ArrayList<Task> tasks = new ArrayList<>();

        String sql = """
            SELECT id, name, priority, status
            FROM tasks
            ORDER BY priority, id
            """;

        try (
            Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery()
        ) {
            while (result.next()) {
                Task task = new Task(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getInt("priority"),
                    result.getInt("status")
                );

                tasks.add(task);
            }
        } catch (SQLException exception) {
            System.out.println("Erro ao carregar tarefas: " + exception.getMessage());
        }

        return tasks;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (
            Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("Erro ao excluir tarefa: " + exception.getMessage());
        }
    }

    public Task findById(int id) {
        String sql = "SELECT id, name, priority, status FROM tasks WHERE id = ?";

        try (
            Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return new Task(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getInt("priority"),
                    result.getInt("status")
                );
            }
        } catch (SQLException exception) {
            System.out.println("Erro ao buscar tarefa: " + exception.getMessage());
        }

        return null;
    }

    public void update(Task task) {
        String sql = """
            UPDATE tasks
            SET name = ?, priority = ?, status = ?
            WHERE id = ?
            """;

        try (
            Connection connection = Database.connect();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, task.getName());
            statement.setInt(2, task.getPriorityValue());
            statement.setInt(3, task.getStatus());
            statement.setInt(4, task.getId());

            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println("Erro ao atualizar tarefa: " + exception.getMessage());
        }
    }
}
