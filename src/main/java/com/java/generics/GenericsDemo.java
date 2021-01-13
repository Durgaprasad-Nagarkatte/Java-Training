package com.java.generics;

import java.util.*;

public class GenericsDemo <T extends List<String>> {
    private T t;

    public static void main(String[] args){
        Container<String> stringStore = new Store<>();
        stringStore.set("Generics in Java");
        System.out.println(stringStore.get());

        // Provides compile time safety
        // stringStore.set(1);

        Container<Integer> integerStore = new Store<>();
        integerStore.set(1);
        System.out.println(integerStore.get());

        Container<List<Integer>> listStore = new Store<>();
        listStore.set(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(listStore.get());

        // Primitive types are not allowed
        //Container<int> primitiveIntStore = new Store<>();

        List<Number> list = new ArrayList<>();
        // Subtypes of number
        list.add(1);
        list.add(22.0);

        // Throws an error at runtime;
//        List[] array = new ArrayList[2];
//        array[0] = new ArrayList();
//        array[1] = new LinkedList();

        GenericsDemo<List<String>> genericsDemo = new GenericsDemo<>();

//        Not possible due to type erasure
//        GenericsDemo<Collection<String>> collectionGenericsDemo = new
//                GenericsDemo<Collection<String>>();
    }

    public void add(String a){
        // This is possible due to bounded parameter
        t.add(a);
    }


}

interface Container<T>{
    void set(T a);
    T get();
}

class Store<T> implements Container<T>{
    // Static variable is also not possible
    // private static T staticA;

    private T a;

    @Override
    public void set(T a) {
        this.a = a;
    }

    @Override
    public T get() {
        return this.a;
    }
}
