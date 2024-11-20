package QUES_1;

public class PartTimeEmployee extends Employee {
    private final float discount = 0.5f;

    public PartTimeEmployee() {
        super();
    }

    public PartTimeEmployee(int id, String sur, String name, int age, String birthday, int workingDay) {
        super(id, sur, name, age, birthday, workingDay);

    }

    public long calculateSalary() {
        this.wage = (long) (this.workingDay * 1000000 * 0.5f);
        return this.wage;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "id=" + id +
                ", sur='" + sur + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", workingDay=" + workingDay +
                ", discount=" + discount +
                ", wage=" + calculateSalary() +
                '}';
    }
}
