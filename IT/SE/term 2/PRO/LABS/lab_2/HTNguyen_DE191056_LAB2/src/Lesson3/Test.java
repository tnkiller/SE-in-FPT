package Lesson3;

import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        Person p1 = new Person(1, "trang", false);
        Person p2 = new Person(2, "vinh", true);

        Person[] perArr = new Person[4];
        perArr[0] = p1;
        perArr[1] = p2;

        Test t = new Test();
        for (int i = 2; i < perArr.length; i++) {
            Person ps = new Person();
            t.scanInfo(ps);
            perArr[i] = ps;
        }
        for (Person i : perArr) {
            t.printInfo(i);
        }
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

    //phuong thuc in
    public void printInfo(Person p) {
        System.out.println("-----------------------------------");
        System.out.println("| ID | Name | Male");
        System.out.printf("| %d | %s | %b |\n", p.getId(), p.getName(), p.isMale());
    }
}
