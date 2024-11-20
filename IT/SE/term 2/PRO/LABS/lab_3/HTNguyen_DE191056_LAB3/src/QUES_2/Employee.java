package QUES_2;

import java.util.Scanner;

public class Employee {
    protected int id;
    protected String sur;
    protected String name;
    protected int age;
    protected String birthday;
    protected int workingDay;
    Scanner sc = new Scanner(System.in);


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

    //input method
    public void input() {
        System.out.println("Enter id: ");
        this.id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter surname: ");
        this.sur = sc.nextLine();
        System.out.println("Enter name: ");
        this.name = sc.nextLine();
        System.out.println("Enter age: ");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter birthday: ");
        this.birthday = sc.nextLine();
        System.out.println("Enter workingDay: ");
        this.workingDay = sc.nextInt();

    }

    //calculate salary method
    public long calculateSalary() {
        return 0;
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
                '}';
    }
}
