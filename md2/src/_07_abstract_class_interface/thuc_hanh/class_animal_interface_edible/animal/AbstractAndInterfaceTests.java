package _07_abstract_class_interface.thuc_hanh.class_animal_interface_edible.animal;

import _07_abstract_class_interface.thuc_hanh.class_animal_interface_edible.animal.Animal;
import _07_abstract_class_interface.thuc_hanh.class_animal_interface_edible.animal.Chicken;
import _07_abstract_class_interface.thuc_hanh.class_animal_interface_edible.animal.Tiger;
import _07_abstract_class_interface.thuc_hanh.class_animal_interface_edible.animal.fruit.Apple;
import _07_abstract_class_interface.thuc_hanh.class_animal_interface_edible.animal.fruit.Fruit;
import _07_abstract_class_interface.thuc_hanh.class_animal_interface_edible.animal.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
