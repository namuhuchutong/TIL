package jacocotest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
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
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);


        Constructor<?> constructor = bookClass.getConstructor(String.class, String.class, String.class); // 넘겨줄 파라미터 지정
        Book book2 = (Book) constructor.newInstance("a", "b", "c");

        Field a = Book.class.getDeclaredField("C");
        a.setAccessible(true);
        System.out.println(a.get(null));
        // Exception -> Can not set static final
//        a.set(null, "asdfasfsafds");
//        System.out.println(a.get(null));

        // 인스턴스가 생성되기 전에는 존재하지 않는 필드
        Field b = Book.class.getDeclaredField("a");
        b.setAccessible(true);
        // 생성된 인스턴스를 넣어준다.
        System.out.println(b.get(book2));

        // 메소드 실행
        Method c = Book.class.getDeclaredMethod("sum", int.class, int.class);
        c.setAccessible(true);
        int invoke = (int) c.invoke(book2, 1, 2);
        System.out.println("invoke = " + invoke);

    }
}