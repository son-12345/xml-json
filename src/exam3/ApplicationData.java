package exam3;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ApplicationData {
    public static void main(String[] args) throws SQLException, IOException {
        //List users  from db
        List<User> users = ConnectionDB.getUsers();
        //Ghi users to json file
        String filePath = "users.json";
        JsonWriterData.writeUserToJson(users, filePath);
        System.out.println("Data has been Written to "+filePath);
    }
}
