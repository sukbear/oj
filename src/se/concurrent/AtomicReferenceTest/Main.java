package se.concurrent.AtomicReferenceTest;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author sukbear
 * @create 2018-12-15 14:18
 */
public class Main {
    public static void main(String[] args) {
        // AtomicReference
        AtomicReference<Person> atomicReferencePerson = new AtomicReference<>();
        Person person = new Person("Jack",20);
        atomicReferencePerson.set(person);
        Person updatePerson = new Person("Tom",22);
        atomicReferencePerson.compareAndSet(person,updatePerson);
        System.out.println(atomicReferencePerson.get().getName()+" "+atomicReferencePerson.get().getAge());

        //
        AtomicStampedReference<Person> asr = new AtomicStampedReference<>(person,1);

        asr.set(person, 2);
        asr.weakCompareAndSet(person,updatePerson,2,1);
        System.out.println(asr.getReference().toString());
        System.out.println(asr.getReference().toString());
        System.out.println(asr.getStamp());
    }


static   class Person{
        private int age;
        private String name;

        public Person( String name,int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name+": "+this.age;
        }
    }
}
