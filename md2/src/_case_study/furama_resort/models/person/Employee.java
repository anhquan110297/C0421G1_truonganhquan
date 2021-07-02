package _case_study.furama_resort.models.person;

public class Employee extends Person  {
    private String level;
    private String onPosition;
    private double salary;

    public Employee() {
    }

    public Employee(String level, String onPosition, double salary) {
        this.level = level;
        this.onPosition = onPosition;
        this.salary = salary;
    }

    public Employee(int id, String name, String dateOfBirth, String gender, int idNo, int telephoneNumber, String email, String level, String onPosition, double salary) {
        super(id, name, dateOfBirth, gender, idNo, telephoneNumber, email);
        this.level = level;
        this.onPosition = onPosition;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOnPosition() {
        return onPosition;
    }

    public void setOnPosition(String onPosition) {
        this.onPosition = onPosition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+", level=" + level + ", onPosition=" + onPosition + ", salary=" + salary;
    }
}
