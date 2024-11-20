package QUES_2;

public class PartTimeEmployee extends Employee {
    private final float discount = 0.5f;

    public PartTimeEmployee() {
        super();
    }

    public PartTimeEmployee(int id, String sur, String name, int age, String birthday, int workingDay) {
        super(id, sur, name, age, birthday, workingDay);

    }

    @Override
    public long calculateSalary() {
        return (long) (this.workingDay * 1000000 * this.discount);
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
