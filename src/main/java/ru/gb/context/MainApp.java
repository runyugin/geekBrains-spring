package ru.gb.context;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("ru.gb.context");

        OrderService orderService = applicationContext.getBean(OrderService.class);

        orderService.createOrderFromProduct(1L);

        Scanner scanner = new Scanner(System.in);

        Long id = scanner.nextLong();

        orderService.productGoToCart(id);
        orderService.showCart();

        orderService.productRemoveToCart(id);
        orderService.showCart();

        applicationContext.close();
    }
}