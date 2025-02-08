package be.vinci.magic;

import be.vinci.magic.jpa.Repository;
import be.vinci.magic.models.Car;
import be.vinci.magic.models.Student;

public class Main {
    public static void main(String[] args) {
        var student = new Student("Bob", "Dylan");
        var car = new Car("Toyota", "Corolla", 2020, 20000.0, 4.5);

        System.out.println(student);

        var repository = new Repository();

        System.out.println(repository.selectAll(Student.class));

        var classProperties = repository.getClassProperties(Student.class);
        System.out.println(classProperties);

        var properties = repository.getProperties(student);
        System.out.println(properties);

        System.out.println(repository.insertRow(student));
        System.out.println(repository.insertRow(car));
    }
}