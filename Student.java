package project;

public class Student {
    private String name;
    private int rollNumber;
    private String department;
    private int batchYear;

    
    public Student(String name, int rollNumber, String department, int batchYear) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
        this.batchYear = batchYear;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getBatchYear() {
        return batchYear;
    }

    public void setBatchYear(int batchYear) {
        this.batchYear = batchYear;
    }

    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", department='" + department + '\'' +
                ", batchYear=" + batchYear +
                '}';
    }
}
