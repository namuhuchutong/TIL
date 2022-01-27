package me.pepeprmill.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StreamExample4 {

    public static void main(String[] args) {

        final List<Product> products =
                Arrays.asList(
                        new Product(1L, "A", new BigDecimal("100")),
                        new Product(2L, "B", new BigDecimal("20")),
                        new Product(3L, "C", new BigDecimal("230")),
                        new Product(4L, "D", new BigDecimal("5")),
                        new Product(5L, "E", new BigDecimal("10"))
                );

        System.out.println(
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .collect(toList())
        );

        System.out.println(
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .map(Product::toString)
                        .collect(joining("\n"))
        );

        System.out.println(
                IntStream.of(1, 2, 3, 4, 5)
                        .sum()
        );

        System.out.println(
                products.stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );

        System.out.println(
                products.stream()
                        .map(Product::getPrice)
                        .filter(price -> price.compareTo((new BigDecimal("30"))) >= 0)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );

        System.out.println(
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .count()
        );

        final OrderItem item1 = new OrderItem(1L, products.get(0), 1);
        final OrderItem item2 = new OrderItem(2L, products.get(2), 3);
        final OrderItem item3 = new OrderItem(3L, products.get(4), 10);

        final Order order = new Order(1L, Arrays.asList(item1, item2, item3));
        System.out.println("order = " + order.totalPrice());
    }
}

@AllArgsConstructor
@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}

@AllArgsConstructor
@Data
class OrderItem {
    private Long id;
    private Product product;
    private int quantity;

    public BigDecimal getTotalPrice() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}

@AllArgsConstructor
@Data
class Order {
    private Long id;
    private List<OrderItem> items;

    public BigDecimal totalPrice() {
        return items.stream()
                .map(OrderItem::getTotalPrice)//.map(item -> item.getTotalPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);// .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));
    }
}