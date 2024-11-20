package QUES_1;

public class Employee {
    protected int id;
    protected String sur;
    protected String name;
    protected int age;
    protected String birthday;
    protected int workingDay;
    protected long wage;


    public Employee() {

    }

    public Employee(int id, String sur, String name, int age, String birthday, int workingDay) {
        this.id = id;
        this.sur = sur;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.workingDay = workingDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSur() {
        return sur;
    }

    public void setSur(String sur) {
        this.sur = sur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public long getWage() {
        return wage;
    }

    public void setWage(long wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", sur='" + sur + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", workingDay=" + workingDay +
                ", wage=" + wage +
                '}';
    }
}
