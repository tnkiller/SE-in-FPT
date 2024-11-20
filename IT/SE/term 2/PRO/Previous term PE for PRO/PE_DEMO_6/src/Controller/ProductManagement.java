/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Product;
import Model.ProductList;
import View.Menu;
import View.Utils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 *
 * @author ADMIN
 */
public class ProductManagement {

    ProductList productList;

    public ProductManagement() {
        productList = new ProductList();
    }

    public void run() throws ParseException {

        String[] choice = {
            "List all products",
            "Promotional products",
            "Product search",
            "Sort product",
            "Product statistics",
            "Exit"
        };

        Menu subMenu = new Menu("---TOOL---", choice) {
            @Override
            public void execute(int n) throws ParseException {
                switch (n) {
                    case 1 ->
                        listAll(productList.getListProduct());
                    case 2 ->
                        promoteProduct(productList.getListProduct());
                    case 3 ->
                        searchProduct();
                    case 4 ->
                        sortByPrice();
                    case 5 ->
                        statistic();
                }
            }
        };
        subMenu.run();
    }

    //MAIN
    public static void main(String[] args) throws ParseException {
        ProductManagement mgn = new ProductManagement();
        mgn.run();
    }

    //LIST ALL
    public void listAll(List<Product> list) {
        list.forEach(System.out::println);
    }

    //PROMOTIONAL
    public void promoteProduct(List<Product> e) {
        for (Product i : e) {
            System.out.println(i + " | " + i.getDiscount());
        }
    }

    //SEARCH
    private ArrayList<Product> search(Predicate<Product> o) {
        ArrayList<Product> res = new ArrayList<>();
        for (Product i : productList.getListProduct()) {
            if (o.test(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public void searchProduct() throws ParseException {
        String[] choice = {
            "by id",
            "by name",
            "by category",
            "by production date",
            "by price",
            "Back"
        };

        Menu<String> subMenu = new Menu<String>("Search by...", choice) {
            @Override
            public void execute(int n) throws ParseException {
                ArrayList<Product> result = new ArrayList<>();
                switch (n) {
                    case 1 -> {
                        String id = Utils.inputValue("Enter category to search: ");
                        result = search(o -> o.getProductId().equalsIgnoreCase(id));
                    }
                    case 2 -> {
                        String name = Utils.inputValue("Enter name to search: ");
                        result = search(o -> o.getProductName().equalsIgnoreCase(name));
                    }
                    case 3 -> {
                        String cate = Utils.inputValue("Enter category to search: ");
                        result = search(o -> o.getCategory().equalsIgnoreCase(cate));
                    }
                    case 4 -> {
                        Date proDate = Utils.checkInputDob("Enter production date: ");
                        result = search(o -> o.getProductDate().equals(proDate));
                    }
                    case 5 -> {
                        double price = Double.parseDouble(Utils.inputValue("Enter price to search: "));
                        result = search(o -> o.getPrice() == price);

                    }
                }
                if (!result.isEmpty()) {
                    promoteProduct(result);
                } else {
                    System.out.println("Not find your product!");
                }
            }
        };
        subMenu.run();
    }

    //SORT
    public void sortByPrice() {
        productList.getListProduct().sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
        productList.getListProduct().forEach(System.out::println);
    }

    //STATISTIC
    public void statistic() {
        Set<String> category = new HashSet<>();
        for (Product i : productList.getListProduct()) {
            category.add(i.getCategory());
        }
        for (String i : category) {
            ArrayList<Product> result = new ArrayList<>();
            for (Product j : productList.getListProduct()) {
                if (j.getCategory().equals(i)) {
                    result.add(j);
                }
            }
            if (result.size() > 1) {
                System.out.println("The products are same category");
                listAll(result);
                System.out.println("Total: " + result.size());
            }
        }
    }
}
