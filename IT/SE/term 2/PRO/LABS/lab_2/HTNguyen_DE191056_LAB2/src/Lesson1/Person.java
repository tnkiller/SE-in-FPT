package Lesson1;

import java.util.Scanner;

public class Person {

    private int id;
    private String name;
    private boolean gender;

    //constructor without argument
    public Person() {
    }

    //constructor with argument
    public Person(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    //get accessor

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public boolean isMale() {
        return gender;
    }

    public void setMale(boolean value) {
        this.gender = value;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + this.id + ", name=" + this.name + ", gender=" + this.gender + '}';
    }

    //phuong thuc nhap
    public void scanInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ID: ");
        this.id = input.nextInt();
        input.nextLine();
        System.out.print("Enter Name: ");
        this.name = input.nextLine();
        System.out.print("Enter Gender: ");
        this.gender = input.nextBoolean();
    }

    //phuong thuc in
    public void printInfo() {
        System.out.println("-----------------------------------");
        System.out.println("| ID | Name | Male");
        System.out.printf("| %d | %s | %b |\n", this.id, this.name, this.gender);
    }


}
