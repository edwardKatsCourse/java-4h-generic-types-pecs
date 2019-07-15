package com.company;

import java.util.ArrayList;
import java.util.List;

public class Example_1 {

    public static void main(String[] args) {
        //invariant - non variant (by default)
        List<Animal> list = new ArrayList<Animal>();
        //read from list
        //write to list

//        Animal a = list.add(0);

        list.add(new Animal());
        list.add(new CatLike());
        list.add(new Lion());
        list.add(new Cat());
        //Кот - это кот. Кот - это не животное, а именно кот
        //Животное - это животное. Кот - это не животное

        //read only
        //Producer | covariance

        //Животное - это кот
        List<? extends CatLike> list_2 = new ArrayList<>();
        //list_2.add(new Cat()); compilation error
        //list_2.add(new Lion()); compilation error
        //list_2.add(new CatLike()); compilation error

        CatLike catLike = list_2.get(0);

        Animal animal = new Cat();

        List<? super Number> numbers = new ArrayList<>();
        numbers.add(1);     //1
        numbers.add(11.99); //11.99


        //Кот - это животное
        //Write only!
        //Consumer
        List<? super CatLike> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Lion());

        //CatLike catLike1 = cats.get(0); - compilation error


        //Covariance - Producer (ничего не добавить, кого угодно получить)
        //Только читать (или генерировать информацию внутри класса)
        //<? extends CatLike> - любой, кто наследует CatLike

        //Contravariance - Consumer (все слушает, ничего не отдает)
        //Только записывать, но не получать
        //<? super CatLike> - любой, у кого предок CatLike

        //Invariance - 99%
        //Писать и читать - никаких ограничений
        //<CatLike>

    }

    private static void readList(List<? extends CatLike> list) {
//        list.add(new Cat());
        list.stream()
                .forEach(x -> System.out.println(x));
    }
}

                        class Animal {}

                class CatLike extends Animal {}

class Cat extends CatLike{}     class Lion extends CatLike {}
