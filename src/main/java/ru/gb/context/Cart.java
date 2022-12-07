package ru.gb.context;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private List<Product> productsToCart = new ArrayList<>();

    public void addProductsToCart(Long idProduct) {
        productsToCart.add(productRepository.findById(idProduct));
    }

    public void removeProductsToCart(Long idProduct) {
        productsToCart.removeIf(s -> s.equals(productRepository.findById(idProduct)));
    }

    public void showCart() {
        productsToCart.stream().forEach(s->System.out.println(s));
    }

}
