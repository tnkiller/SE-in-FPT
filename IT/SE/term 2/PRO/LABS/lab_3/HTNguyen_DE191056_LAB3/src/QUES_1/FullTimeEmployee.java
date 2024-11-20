package QUES_1;

public class FullTimeEmployee extends Employee {
    private float otTime;

    public FullTimeEmployee() {
        super();
    }

    public FullTimeEmployee(int id, String sur, String name, int age, String birthday, int workingDay, float otTime) {
        super(id, sur, name, age, birthday, workingDay);
        this.otTime = otTime;
    }

    public float getOtTime() {
        return otTime;
    }

    public void setOtTime(int otTime) {
        this.otTime = otTime;
    }

    public long calculateSalary() {
        this.wage = (long) (this.workingDay * 1000000 + this.otTime * 100000);
        return this.wage;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "id=" + id +
                ", sur='" + sur + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", workingDay=" + workingDay +
                ", otTime=" + otTime +
                ", wage=" + calculateSalary() +
                '}';
    }
}
