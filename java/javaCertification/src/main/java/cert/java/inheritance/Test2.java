package cert.java.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public interface Animal{
        String name="Animaaaal";
        String makeNoise();
    }
    public interface Dog extends Animal{
    }
    public interface Cat extends Animal{

    }

    public static void main(String[] args) {
        Animal animal = () -> "MiaGuau";
        Dog dog = () -> "Guau";
        Cat cat = () -> "Miau";
        Animal a1 = null;
        System.out.println(a1.name);

        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(dog);
        animals.add(cat);

        for (Animal oneAnimal : animals) {
            System.out.println(oneAnimal.makeNoise());
        }
    }
}
