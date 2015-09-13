import org.example.groovy.*;
import org.example.java.*;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Parrot parrot = new Parrot();

        System.out.println("The cat says '" + cat.hello() + "'");
        System.out.println("The parrot says '" + parrot.hello() + "'");
    }
}
