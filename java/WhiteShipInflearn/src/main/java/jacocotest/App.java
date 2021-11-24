package jacocotest;

import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException{
        Class<Book> bookClass = Book.class;

        // or from instance
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        // or from FQCN
        Class<?> aClass1 = Class.forName("jacocotest.Book");

        // only return public fields
        // Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        // return all fields
        //Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        // get Field's values
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try{
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);

    }
}
