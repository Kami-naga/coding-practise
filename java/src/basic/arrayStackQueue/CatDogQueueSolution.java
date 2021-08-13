package basic.arrayStackQueue;

//实现一种狗猫队列的结构，要求如下：
//用户可以调用add方法将cat类或dog类的实例放入队列中；
//用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
//用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
//用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
//用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
//用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
//用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueueSolution {

    public static class Pet{
        private String type;
        public Pet(String type) { this.type = type; }
        public String getPetType() { return this.type; }
    }

    public static class Dog extends Pet { public Dog() { super("dog"); } }
    public static class Cat extends Pet { public Cat() { super("cat"); } }

    public static class PetEntry{
        private Pet pet;
        private Integer id;

        public PetEntry(Pet pet, int id){
            this.pet = pet;
            this.id = id;
        }

        public Pet getPet(){
            return this.pet;
        }

        public Integer getID(){
            return this.id;
        }

        public String getPetType(){
            return this.pet.type;
        }
    }

    public static class CatDogQueue{
        private Queue<PetEntry> cats;
        private Queue<PetEntry> dogs;
        private int count;

        public CatDogQueue(){
            cats = new LinkedList<>();
            dogs = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet){
            if(pet.getPetType().equals("cat")){
                cats.offer(new PetEntry(pet, count++));
            }else if(pet.getPetType().equals("dog")){
                dogs.offer(new PetEntry(pet, count++));
            }else{
                throw new RuntimeException("unknown pet!");
            }
        }

        public Pet pollAll(){
            if(cats.isEmpty() && dogs.isEmpty()) {
                throw new RuntimeException("nothing to poll");
            }
            else if(cats.isEmpty()){
                return dogs.poll().getPet();
            }else if(dogs.isEmpty()){
                return cats.poll().getPet();
            }else{
                return cats.peek().getID() < dogs.peek().getID() ? cats.poll().getPet() : dogs.poll().getPet();
            }
        }

        public Cat pollCat(){
            if(cats.isEmpty()) {
                throw new RuntimeException("no cats to poll");
            }
            return (Cat) cats.poll().getPet();
        }

        public Dog pollDog(){
            if(dogs.isEmpty()) {
                throw new RuntimeException("no dogs to poll");
            }
            return (Dog) dogs.poll().getPet();
        }

        public Boolean isEmpty(){
            return cats.isEmpty() && dogs.isEmpty();
        }

        public Boolean isCatEmpty(){
            return cats.isEmpty();
        }

        public Boolean isDogEmpty(){
            return dogs.isEmpty();
        }
    }

    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
