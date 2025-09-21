package practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByFuncAndCollector2 {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Electronics", 999.99),
                new Product("Electronics", 499.99),
                new Product("Furniture", 299.99)
        );

        Map<String,Double> res = products.stream().collect(Collectors.groupingBy(Product::category, Collectors.summingDouble(Product::price)));

        System.out.println(res);


    }
}

record Product(String category, double price) {}


