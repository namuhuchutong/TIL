package jacocotest;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class Magician {

    public static void main(String[] args) {
//        ClassLoader classLoader = Magician.class.getClassLoader();
//        TypePool typePool = TypePool.Default.of(classLoader);
//
//        try {
//            new ByteBuddy().redefine(
//                    typePool.describe("jacocotest.Moja").resolve(),
//                            ClassFileLocator.ForClassLoader.of(classLoader))
//                    .method(named("pull")).intercept(FixedValue.value("Rabbit12312312"))
//                    .make().saveIn(new File("/Users/hoyeonjang/MyProjects/Basic/java/WhiteShipInflearn/target/classes/"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Moja moja = new Moja();
        System.out.println(moja.pull());
    }
}
