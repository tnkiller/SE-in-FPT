/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Formatter;

/**
 *
 * @author ADMIN
 */
public class Product {

    //attributes
    private String productId;
    private String productName;
    private String category;
    private double price;
    private Date productDate;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date today = new Date();

    //constructor
    public Product(String productId, String productName, String category, String productDate, double price) throws ParseException {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.productDate = setProductDate(productDate);
        this.price = price;
    }

    //get discount method
    public double getDiscount() {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(today));
        int d2 = Integer.parseInt(formatter.format(productDate));
        int age = (d1 - d2) / 10000;
        if (age < 1) {
            return 0;
        } else if (age < 2) {
            return 0.2;
        } else {
            return 0.5;
        }
    }

    //getter & setter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getProductDate() {
        return productDate;
    }

    public Date setProductDate(String productDate) throws ParseException {
        return sdf.parse(productDate);
    }

    //toString
    @Override
    public String toString() {
        return String.format("%-10s | %-15s | %-10s | %-10s | %-10.2f",
                this.productId,
                this.productName,
                this.category,
                sdf.format(this.productDate),
                this.price);
    }

}
