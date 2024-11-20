/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Employee {

    //attributes
    private String empId;
    private String account;
    private Date workStartingDate;
    private float productivityScore;
    private double monthlyIncome = 0;
    private double rewardSalary;
    private long allowance;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //constructor
    public Employee(String empId, String account, String workStartingDate, float productivityScore, long allowance) throws ParseException {
        this.empId = empId;
        this.account = account;
        this.workStartingDate = setWorkStartingDate(workStartingDate);
        this.productivityScore = productivityScore;
        this.allowance = allowance;
    }

    //Calculate monthly income
    public double calMonthlyIncome() {
        return this.rewardSalary + this.allowance;
    }

    public double calReward() {
        return this.productivityScore * 3000000;
    }

    //getter & setter
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getAccount() {
        return account;
    }

    public Date getWorkStartingDate() {
        return workStartingDate;
    }

    public Date setWorkStartingDate(String workStartingDate) throws ParseException {
        return sdf.parse(workStartingDate);
    }

    public float getProductivityScore() {
        return productivityScore;
    }

    public void setProductivityScore(float productivityScore) {
        this.productivityScore = productivityScore;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getRewardSalary() {
        return rewardSalary;
    }

    public void setRewardSalary(double rewardSalary) {
        this.rewardSalary = rewardSalary;
    }

    public long getAllowance() {
        return allowance;
    }

    public void setAllowance(long allowance) {
        this.allowance = allowance;
    }

    @Override
    public String toString() {
        return String.format(" %-10s | %-10s | %-10s | %-10s | %-10.1f",
                this.empId,
                this.account,
                sdf.format(this.workStartingDate),
                this.productivityScore,
                (float) Math.round(this.monthlyIncome)
        );
    }

}
