package cert.java.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Test3 {


    public static void main(String[] args) {
        Animal animal = new Dog();
        Animal animal2 = new Cat();
        Animal animal3 = new Animal() {
            @Override
            String makeNoise() {
                return "MiauGuau";
            }
        };

        int s  = 10;
        Cat cat = new Cat();
        Dog dog = new Dog();

        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(dog);
        animals.add(cat);

        for (Animal oneAnimal : animals) {
            System.out.println(oneAnimal.makeNoise());
        }
    }
}

abstract class Animal{
    abstract String makeNoise();
}

class Dog extends Animal{
    @Override
    String makeNoise() {
        return "Guau";
    }
}

class Cat extends Animal{
    @Override
    String makeNoise() {
        return "Miau";
    }
}