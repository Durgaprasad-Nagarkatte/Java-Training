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
        rawTypeTest();

        List<String> strList1 = Arrays.asList("a", "b", "c", "d");
        List<String> strList2 = Arrays.asList("c", "d", "e", "f");
        int count = getCommonElementsCount(strList1, strList2);
        System.out.println("The common elements in the list are : " + count);

        // Invalid use of type parameter
        List<Integer> list1 = Arrays.asList(1 ,2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = new ArrayList<>();
        //invalidAdditionToListOperation(list1, list2, list3);

        // Invariance and Covariance
        //go(new ArrayList<Integer>());

        //go(new Integer[1]);
    }

    //Covariance property throwing runtime exception
//    private static void go(Number[] integers) {
//        integers[0] = 24.0;
//    }

    // Invariance property comes into picture
//    private static void go(ArrayList<Number> integers) {
//    }

//    private static void invalidAdditionToListOperation(List<?> list1,
//                                                       List<?> list2, List<?> list3) {
//        list3.addAll(list1);
//        list3.addAll(list2);
//    }

    // Using bounded wild cards
    private static int getCommonElementsCount(List<?> strList1,
                                               List<?> strList2) {
        int count = 0;
        for(Object o : strList1){
            if(strList2.contains(o)){
                count++;
            }
        }
        return count;
    }

    public static void rawTypeTest(){
        System.out.println("\n Inside raw type test \n");
        int ISBN = 134546454;

        List<Double> prices = new ArrayList<>();
        HalfIntegrator.getPrice(ISBN, prices);
        Double price = prices.get(0);
        System.out.println("Price is : " + price);
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

class HalfIntegrator {
//    Not a good practice to use raw type test
//    public static void getPrice(int ISBN, List prices){
//        prices.add(45);
//    }

    public static void getPrice(int ISBN, List<Double> prices){
        prices.add(45.0);
    }
}
