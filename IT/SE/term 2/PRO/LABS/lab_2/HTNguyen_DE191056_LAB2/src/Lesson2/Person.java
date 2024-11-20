package Lesson2;

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


}
