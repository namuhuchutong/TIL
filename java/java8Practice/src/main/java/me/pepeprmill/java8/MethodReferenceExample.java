package me.pepeprmill.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        final Section section = new Section(10);

        final Function<Integer, Section> sectionFactoryWithLambda = number -> new Section(number);
        final Function<Integer, Section> sectionFactoryWtihMethodRef = Section::new;

        final Section section1 = sectionFactoryWithLambda.apply(1);
        final Section section2 = sectionFactoryWtihMethodRef.apply(2);
;
        System.out.println("section1 = " + section1);
        System.out.println("section2 = " + section2);
        System.out.println("section = " + section);

        System.out.println("------------------------");

        final ProductA a = createProduct(1L, "A", new BigDecimal("123"), ProductA::new);
        final ProductB b = createProduct(1L, "B", new BigDecimal("123"), ProductB::new);

        System.out.println("a = " + a);
        System.out.println("b = " + b);


    }

    private static <T extends Product> T createProduct(final Long id,
                                                       final String name,
                                                       final BigDecimal price,
                                                       final ProductCreator<T> productCreator) {
        if (id == null || id < 1L) {
            throw new IllegalArgumentException("The id must be a positive Long.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name is not given.");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) { // price <= ZERO
            throw new IllegalArgumentException("The price must be greater then 0.");
        }
        return productCreator.create(id, name, price);
    }
}

@FunctionalInterface
interface ProductCreator<T extends Product> {
    T create(Long id, String name, BigDecimal price);
}

@AllArgsConstructor
@Data
class Section {
    private int number;
}

@AllArgsConstructor
@Data
abstract class ProductOld {
    private Long id;
    private String name;
    private BigDecimal price;
}

class ProductA extends Product {
    public ProductA(final  Long id, final String name, final BigDecimal price){
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "A=" + super.toString();
    }
}

class ProductB extends Product {
    public ProductB(final  Long id, final String name, final BigDecimal price){
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "B=" + super.toString();
    }
}