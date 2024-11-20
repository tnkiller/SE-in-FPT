package model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import view.Menu1;
import view.Utils;

public class School extends Menu1 {

    private ArrayList<Student> studentList;

    public School(String title, String[] mc) throws ParseException {
        super(title, mc);
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

    @Override
    public void execute(int n) throws ParseException {
        boolean isExist = false;
        switch (n) {
            case 1 -> {
                float searchAvr = Float.parseFloat(Utils.getValue("Enter average you want to search: "));
                System.out.println("Result...");
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).calAverage() == searchAvr) {
                        isExist = true;
                        System.out.println(studentList.get(i).toString());
                    }
                }
                if (!isExist) {
                    System.out.println("Non-existent...");
                }
            }
            case 2 -> {
                String dateString = Utils.getValue("Enter dob you wanna search: ");
                System.out.println("Result...");
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getDob().equalsIgnoreCase(dateString)) {
                        isExist = true;
                        System.out.println(studentList.get(i));
                    }
                }
                if (!isExist) {
                    System.out.println("Non-existent...");
                }

            }
            case 3 -> {

            }
            case 0 ->
                System.exit(0);
        }

    }

    public void searchList() throws ParseException {
        run();
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
        int numOfStudent = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date year2000 = calendar.getTime();
        for (Student st : studentList) {
            if (st.getDobDate().before(year2000)) {
                System.out.println(st);
                numOfStudent++;
            }
        }
        System.out.println("Number of student born before 2000: " + numOfStudent);
    }

}
