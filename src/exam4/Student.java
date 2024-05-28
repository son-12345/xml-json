package exam4;

import java.sql.Date;

public class Student {
    private int ID;
    private String name;
    private String address;
    private String email;
    private String phone;
    private Date DOB;

    public Student(int ID, String name, String address, String email, String phone, Date DOB) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.DOB = DOB;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDOB() {
        return DOB;
    }
}
