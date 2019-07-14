package se.other.generic;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author sukbear
 * @create 2018-12-17 8:58
 */
public class Main {
    static class Food {
        private String name;

        public Food(String name) {
            this.name = name;
        }
        public Food(){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Fruit extends Food {
    }

    static class Apple extends Fruit {
        private String colour;

        public Apple(String colour) {
            this.colour = colour;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }
    }

    static class Plate<T> {
        private T item;

        public Plate(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple("red"));
        Apple apple = (Apple) p.getItem();
        System.out.println(apple.getColour());
        Plate<? super Fruit> plate = new Plate<>(new Fruit());
        plate.setItem(new Apple("green"));
        AbstractMap<Integer,String> map = new HashMap<>(16);

        ArrayList<? super Food> list = new ArrayList<>();
        list.add(new Apple("red"));

        Food f = (Food)list.get(0);
        System.out.println(f.getName());
    }
}
