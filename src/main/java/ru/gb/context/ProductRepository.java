package ru.gb.context;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void initProducts(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1L,"Milk", 200),
                new Product(2L,"Meat", 500),
                new Product(3L,"Bread", 250),
                new Product(4L,"Cheese", 400),
                new Product(5L,"Water", 100)
        ));
    }

    public Product findById(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(()-> new RuntimeException());
    }
}
