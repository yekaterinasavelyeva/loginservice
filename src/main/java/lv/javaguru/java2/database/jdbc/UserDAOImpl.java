package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl extends DAOImpl implements UserDAO {

    public User save(User user) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into USERS values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getState().name());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                user.setUserId(rs.getLong(1));
                PreparedStatement preparedStatementPasswords =
                        connection.prepareStatement("insert into PASSWORDS values (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatementPasswords.setLong(1, user.getUserId());
                preparedStatementPasswords.setString(2, user.getPassword());
                preparedStatementPasswords.setString(3, null);
                preparedStatementPasswords.setString(4, null);
                preparedStatementPasswords.executeUpdate();
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return user;
    }

    public Optional<User> getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from USERS where UserID = ?");
            preparedStatement.setLong(1, id);
            PreparedStatement preparedStatementPasswords = connection
                    .prepareStatement("select * from PASSWORDS where UserID = ?");
            preparedStatementPasswords.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSetPasswords = preparedStatementPasswords.executeQuery();
            User user = null;
            if (resultSet.next() && resultSetPasswords.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setLogin(resultSet.getString("Login"));
                user.setPassword(resultSetPasswords.getString("Password"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setState(UserState.valueOf(resultSet.getString("Status")));
            }
            return Optional.ofNullable(user);
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<User> getAll() throws DBException {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from USERS");
            PreparedStatement preparedStatementPasswords = connection
                    .prepareStatement("select * from PASSWORDS");


            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSetPasswords = preparedStatementPasswords.executeQuery();
            while (resultSet.next() && resultSetPasswords.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setLogin(resultSet.getString("Login"));
                user.setPassword(resultSetPasswords.getString("Password"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setState(UserState.valueOf(resultSet.getString("Status")));
                users.add(user);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return users;
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from USERS where UserID = ?");
            PreparedStatement preparedStatementPasswords = connection
                    .prepareStatement("delete from PASSWORDS where UserID = ?");
            preparedStatement.setLong(1, id);
            preparedStatementPasswords.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatementPasswords.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public void update(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update USERS set Login = ?, FirstName = ?, LastName = ?, Status = ? " +
                            "where UserID = ?");
            PreparedStatement preparedStatementPasswords = connection
                    .prepareStatement("update PASSWORDS set Password = ?, Password2 = ?, Password3 = ?"
                    + "where UserID = ?");
            PreparedStatement preparedStatementAllPasswords = connection
                    .prepareStatement("select * from PASSWORDS");
            ResultSet resultSetPasswords = preparedStatementAllPasswords.executeQuery();
            while (resultSetPasswords.next()) {
                String pass3 = resultSetPasswords.getString("Password2");
                String pass2 = resultSetPasswords.getString("Password");

                preparedStatement.setString(1, user.getLogin());

                preparedStatementPasswords.setString(3, pass3);
                preparedStatementPasswords.setString(2, pass2);
                preparedStatementPasswords.setString(1, user.getPassword());
                preparedStatementPasswords.setLong(4, user.getUserId());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getState().name());
                preparedStatement.setLong(5, user.getUserId());
                preparedStatement.executeUpdate();
                preparedStatementPasswords.executeUpdate();
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

}
