package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:tasks.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                priority INTEGER NOT NULL DEFAULT 0,
                status INTEGER NOT NULL DEFAULT 0,
                created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
            );
            """;

        try (
            Connection connection = connect();
            Statement statement = connection.createStatement()
        ) {
            statement.execute(sql);
            resetTaskIdIfEmpty(connection);
            System.out.println("Tabela tasks criada ou já existente.");
        } catch (SQLException exception) {
            System.out.println("Erro ao criar tabela: " + exception.getMessage());
        }
    }

    public static void resetTaskIdIfEmpty(Connection connection) throws SQLException {
        String sql = """
            DELETE FROM sqlite_sequence
            WHERE name = 'tasks'
              AND NOT EXISTS (SELECT 1 FROM tasks)
            """;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }
}
