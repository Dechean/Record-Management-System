package Service;

import Connection.DbConnection;
//import com.sun.tools.javac.util.List;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    // insert user
    public void insertUser(User user) {

        String insertsql = "INSERT into user(name, username, pwd)" + "values (?,?,?)";

        PreparedStatement preparedStatement = new DbConnection().getStatement(insertsql);

        try {
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPwd());


            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // delete the user
    public void deleteUser(int id) {

        String deletesql = "DELETE from user where id = ?";

        PreparedStatement preparedStatement = new DbConnection().getStatement(deletesql);

        try {
            preparedStatement.setInt(1, id);

            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    //update user
    public void editUser(int id, User user) throws SQLException {
        String editquery = "UPDATE user set name = ?, username = ?, pwd = ?  where " + "id = ?";


//        String updatesql = "UPDATE user SET  name= ?, username=?, ";

        PreparedStatement preparedStatement = new DbConnection().getStatement(editquery);

        preparedStatement.setString(1, user.getFullName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPwd());
        preparedStatement.setInt(4, id);

        preparedStatement.execute();

    }


    // LOGIN
    public User getUser(String userName, String pwd) {
        User user = null;
        String query = "select * from user where username=? and pwd=? ";

        PreparedStatement preparedStatement = new DbConnection().getStatement(query);
        try {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, pwd);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // database bata liyeko values haru .... column name bata
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPwd(resultSet.getString("pwd"));

                System.out.println("Username: " + userName + " Password : " + pwd);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;

    }



//    for printing the list of users
    public List<User> getUserList() {
        // create an arraylist and store all the user details
       ArrayList<User> arrayList1 = new ArrayList();
//       ArrayList<User> arrayList = new ArrayList<>();


        String userList = "select * from user";
        PreparedStatement preparedStatement = new DbConnection().getStatement(userList);

        try {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // store all the user details in an object called user
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPwd(resultSet.getString("pwd"));

                arrayList1.add(user);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayList1;
    }






    // get only the particular user details needed
    public User showUserRow(int id) {

        User user = new User();


        String myuser = "select * from user where id=?";
        PreparedStatement preparedStatement = new DbConnection().getStatement(myuser);

        try {

            preparedStatement.setInt(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // store all the user details in an object called user


                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPwd(resultSet.getString("pwd"));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }









}




