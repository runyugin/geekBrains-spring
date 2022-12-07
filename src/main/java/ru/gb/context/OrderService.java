package ru.gb.context;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    private ProductService productService;

    @Autowired
    private Cart cart;

    public void createOrderFromProduct(Long productId){
        System.out.println("Заказ создан");
        System.out.println(productService.getTitleById(productId));
    }


    public void showCart(){
        System.out.println("Просмотр корзины");
        cart.showCart();
    }


    public void productGoToCart(Long productId){
        System.out.println("Товар #" + productId + " добавлен в корзину");
        cart.addProductsToCart(productId);
    }

    public void productRemoveToCart(Long productId){
        System.out.println("Товар #" + productId + " удален из корзины");
        cart.removeProductsToCart(productId);
    }
}
