package exam3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Write_JSON_Gson {
    public static void main(String[] args) throws IOException {
        //Tao dng ghi(Stream Writer)
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("employee.json"));

        //Tao doi tuong Employee thong Map
        Map<String, Object> employee = new HashMap<>();
        employee.put("id", 1);
        employee.put("name", "Khac Thanh");
        employee.put("email", "thanh@gmail.com");
        employee.put("age",18);

        //Tao doi tuong address
        Map<String,Object> address = new HashMap<>();
        address.put("street", "Ton That Thuyet");
        address.put("city","Ha Noi");
        address.put("zipcode",10000);

        //Gan address cho employee
        employee.put("address",address);

        //Tao project 1
        Map<String,Object> pro1 = new HashMap<>();
        pro1.put("title","java and json");
        pro1.put("budget",2000);

        //Tao project 2
        Map<String,Object> pro2 = new HashMap<>();
        pro2.put("title","Employee management");
        pro2.put("budget",5000);

        //Gan projects cho employee
        employee.put("projects", Arrays.asList(pro1,pro2));
        //Tao doi tuong Gson
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //Ghi JSON vao file(ghi noi dung vao Stream Writer)
        writer.write(gson.toJson(employee));

        //Giai phong tai nguyen
        writer.close();
}}
