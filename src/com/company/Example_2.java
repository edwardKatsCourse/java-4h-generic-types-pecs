package com.company;

public class Example_2 {

    public static void main(String[] args) {
        BaseClass<? super A> baseClass = new BaseClass<>();
        //A a = baseClass.get(); - compilation error

        A b = new B();

        baseClass.add(b);
    }
}

class A {}
class B extends A {}
class C extends B {}
class D extends C {}

class BaseClass<E> {

    private Object value;

    public E get() {
        return (E) value;
    }

    public void add(E e) {
        this.value = e;
    }
}
