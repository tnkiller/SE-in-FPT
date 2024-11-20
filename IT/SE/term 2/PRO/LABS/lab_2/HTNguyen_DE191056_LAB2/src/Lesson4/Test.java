package Lesson4;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {


    //main
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Test t = new Test();
        ArrayList<Person> perArr = new ArrayList<>();
        Person p1 = new Person(1, "khai", true);
        Person p2 = new Person(2, "hai", false);
        perArr.add(p1);
        perArr.add(p2);

        for (int i = 0; i < 2; i++) {
            Person person = new Person();
            t.scanInfo(person);
            perArr.add(person);
        }

        System.out.printf("| %-5s | %-10s | %-5s |\n", "ID", "Name", "Male");
        for (Person i : perArr) {
            t.printInfo(i);
        }
        sortName(perArr);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~After sorted~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf("| %-5s | %-10s | %-5s |\n", "ID", "Name", "Male");
        for (Person i : perArr) {
            t.printInfo(i);
        }
        System.out.println("Input name you want to search: ");
        String searchName = sc.nextLine();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~After searching~~~~~~~~~~~~~~~~~~~~~");
        int res = searchName(perArr, searchName);
        System.out.println(perArr.get(res).toString());


    }


    //sort ArrayList by only name  method
    public static void sortName(ArrayList<Person> perArr) {
        //insertion sort
        for (int i = 1; i < perArr.size(); i++) {
            String key = perArr.get(i).getName();
            Person keyPer = perArr.get(i);
            int j = i - 1;
            while (j >= 0 && perArr.get(j).getName().compareTo(key) > 0) {
                perArr.set(j + 1, perArr.get(j));
                j--;
            }
            perArr.set(j + 1, keyPer);
        }
    }

    //search name method
    public static int searchName(ArrayList<Person> perArr, String searchName) {
        //binary search
        sortName(perArr);
        int begin = 0;
        int end = perArr.size() - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (perArr.get(mid).getName().compareTo(searchName) == 0) {
                return mid;
            } else if (perArr.get(mid).getName().compareTo(searchName) < 0) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
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
        System.out.printf("| %-5d | %-10s | %-5b |\n", p.getId(), p.getName(), p.isMale());
    }
}
