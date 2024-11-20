package Lesson2;

import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        Person person = new Person();
        Test t = new Test();

        t.scanInfo(person);
        t.printInfo(person);
    }

    //phuong thuc nhap
    public void scanInfo(Person p) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ID: ");
        p.setId(input.nextInt());
        input.nextLine();
        System.out.print("Enter Name: ");
        p.setName(input.nextLine());
        System.out.print("Enter Gender: ");
        p.setMale(input.nextBoolean());
    }

    public void printInfo(Person p) {
        System.out.println("-----------------------------------");
        System.out.println("| ID | Name | Male");
        System.out.printf("| %d | %s | %b |\n", p.getId(), p.getName(), p.isMale());
    }
}
