package exam4;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class StudentController {
    private StudentDAO studentDAO;
    private StudentView studentView;
    private static final String FILE_NAME = "students.json";
    private JsonArray studentsArray;
    private Gson gson;

    public StudentController(StudentDAO studentDAO, StudentView studentView) {
        this.studentDAO = studentDAO;
        this.studentView = studentView;
        this.gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader reader = new FileReader(FILE_NAME)) {
            studentsArray = JsonParser.parseReader(reader).getAsJsonArray();
        } catch (IOException e) {
            studentsArray = new JsonArray();
        }
    }

    public void writeDataToJSON() {
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            studentsArray.add(studentToJson(student));
        }
        saveToFile();
        System.out.println("Data has been written to students.json");
    }

    public void addStudent() {
        Student newStudent = studentView.getStudentDetails();
        studentsArray.add(studentToJson(newStudent));
        saveToFile();
    }

    public void displayAllStudents() {
        studentView.displayJSON(gson.toJson(studentsArray));
    }

    public void searchByName() {
        String name = studentView.getSearchQuery("name");
        for (JsonElement element : studentsArray) {
            JsonObject student = element.getAsJsonObject();
            if (student.get("name").getAsString().equalsIgnoreCase(name)) {
                studentView.displayJSON(student.toString());
            }
        }
    }

    public void searchByEmail() {
        String email = studentView.getSearchQuery("email");
        for (JsonElement element : studentsArray) {
            JsonObject student = element.getAsJsonObject();
            if (student.get("email").getAsString().equalsIgnoreCase(email)) {
                studentView.displayJSON(student.toString());
            }
        }
    }

    private JsonObject studentToJson(Student student) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("ID", student.getID());
        jsonObject.addProperty("name", student.getName());
        jsonObject.addProperty("address", student.getAddress());
        jsonObject.addProperty("email", student.getEmail());
        jsonObject.addProperty("phone", student.getPhone());
        jsonObject.addProperty("DOB", student.getDOB().toString());
        return jsonObject;
    }

    private void saveToFile() {
        try (FileWriter file = new FileWriter(FILE_NAME)) {
            file.write(gson.toJson(studentsArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
