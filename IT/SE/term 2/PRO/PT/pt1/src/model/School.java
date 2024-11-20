package model;

import java.text.ParseException;
import java.util.ArrayList;
import view.Utils;

public class School {

    private ArrayList<Student> studentList;

    public School() throws ParseException {
        this.studentList = new ArrayList<>();
        this.studentList.add(new Student(1, "Nguyen Van A", "15/01/2000", 8.5f, 9.0f));
        this.studentList.add(new Student(2, "Tran Thi B", "23/11/1999", 7.8f, 8.2f));
        this.studentList.add(new Student(3, "Le Van C", "10/03/2001", 9.2f, 8.8f));
        this.studentList.add(new Student(4, "Pham Thi D", "22/07/1998", 7.4f, 7.7f));
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void searchList(int opt) throws ParseException {
        boolean isExist = false;
        if (opt == 1) {
            float searchAvr = Float.parseFloat(Utils.getValue("Enter average you want to search: "));
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).calAverage() == searchAvr) {
                    isExist = true;
                    System.out.println(studentList.get(i).toString());
                }
            }
            if (!isExist) {
                System.out.println("Non-existent...");
            }
        } else {
            String dateString = Utils.getValue("Enter dob you wanna search: ");
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getDob().equalsIgnoreCase(dateString)) {
                    isExist = true;
                    System.out.println(studentList.get(i));
                }
            }
            if (!isExist) System.out.println("Non-existent...");
        }
    }

    public void printList() {
        System.out.format("%-5s | %-15s | %-15s | %-5s | %-5s | %-5s\n",
                "ID",
                "Name",
                "Date of birth",
                "Java",
                "HTML",
                "Average"
        );
        for (Student iStudent : studentList) {
            System.out.println(iStudent.toString());

        }

    }

    public void addNew() throws ParseException {
        int id = (Integer.parseInt(Utils.getValue("Enter id: ")));
        String name = Utils.getValue("Enter name: ");
        String dob = Utils.getValue("Enter date of birth: ");
        float java = Float.parseFloat(Utils.getValue("Enter Java score: "));
        float html = Float.parseFloat(Utils.getValue("Enter HTML score: "));
        Student s1 = new Student(id, name, dob, java, html);
        studentList.add(s1);
    }

    public void sortAvr() {
        for (int i = 1; i < studentList.size(); i++) {
            float key = studentList.get(i).calAverage();
            Student keyStudent = studentList.get(i);
            int j = i - 1;
            while (j >= 0 && key > studentList.get(j).calAverage()) {
                studentList.set(j + 1, studentList.get(j));
                j--;
            }
            studentList.set(j + 1, keyStudent);
        }
        System.out.println("\t\t After sorted");
        System.out.format("%-5s | %-15s | %-15s | %-5s | %-5s | %-5s\n",
                "ID",
                "Name",
                "Date of birth",
                "Java",
                "HTML",
                "Average"
        );
        for (Student i : studentList) {
            System.out.println(i.toString());
        }
    }

    public void stat() {
        for (Student iStudent : studentList) {
            String stringdob = iStudent.getDob();
            String[] splitted_dob = stringdob.split("/");
            if (Integer.parseInt(splitted_dob[splitted_dob.length - 1]) < 2000) {
                System.out.println(iStudent.toString());
            }
        }
    }

}
