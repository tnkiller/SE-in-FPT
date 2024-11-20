/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.Validation;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class ProductList {

    private List<Product> listProduct;

    public ProductList() {
        listProduct = new ArrayList<>();
        loadFile("product.txt");
    }

    //getter & setter
    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProdcuct) {
        this.listProduct = listProdcuct;
    }

//load FILE
    public void loadFile(String fname) {
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fname))) {
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length == 5) {
                    if (Validation.checkIdData(temp[0]) != null) {
                        listProduct.add(new Product(temp[0], temp[1], temp[2], temp[3], Double.parseDouble(temp[4])));
                    }
                }
            }
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        } catch (IOException ioe) {
            System.out.println("IO error");
        } catch (ParseException pe) {
            System.out.println("Parse error");
        }
    }

}
