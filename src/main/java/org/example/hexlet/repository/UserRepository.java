package org.example.hexlet.repository;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.hexlet.model.User;

public class UserRepository extends BaseRepository {
/*    private static List<User> entities = new ArrayList<User>();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        entities.add(user);
    }

    public static List<User> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return users;
    }

    public static Optional<User> find(Long id) {
        var maybeUser = entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny();
        return maybeUser;
    }

    public static void delete(Long id) {

    }

    public static List<User> getEntities() {
        return entities;
    }*/
public static void save(User user) throws SQLException {
    String sql = "INSERT INTO users (name, mail, password) VALUES (?, ?, ?)";
    try (var conn = dataSource.getConnection();
         var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getMail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.executeUpdate();
        var generatedKeys = preparedStatement.getGeneratedKeys();
        // Устанавливаем ID в сохраненную сущность
        if (generatedKeys.next()) {
            user.setId(generatedKeys.getLong(1));
        } else {
            throw new SQLException("DB have not returned an id after saving an entity");
        }
    }
}

    public static Optional<User> find(Long id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var mail = resultSet.getString("mail");
                var password = resultSet.getString("password");
                var user = new User(name, mail, password);
                user.setId(id);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static List<User> getEntities() throws SQLException {
        var sql = "SELECT * FROM users";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var mail = resultSet.getString("mail");
                var password = resultSet.getString("password");
                var user = new User(name, mail, password);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
    }
}
