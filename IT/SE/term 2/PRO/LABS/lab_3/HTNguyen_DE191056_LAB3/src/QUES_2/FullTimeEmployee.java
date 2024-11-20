package QUES_2;

public class FullTimeEmployee extends Employee {
    private int otTime;

    //empty constructor
    public FullTimeEmployee() {
        super();
    }

    //non-empty constructor
    public FullTimeEmployee(int id, String sur, String name, int age, String birthday, int workingDay, int otTime) {
        super(id, sur, name, age, birthday, workingDay);
        this.otTime = otTime;
    }

    public int getOtTime() {
        return otTime;
    }

    public void setOtTime(int otTime) {
        this.otTime = otTime;
    }

    @Override
    public void input(){
        super.input();
        System.out.println("Enter OT time: ");
        otTime = sc.nextInt();
    }

    @Override
    public long calculateSalary() {
        return this.workingDay * 1000000 + this.otTime * 100000;
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
