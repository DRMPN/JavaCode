package IntensiveCourse.Lesson1;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        System.out.println("START");
        
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        
        // add test
        System.out.println(list.size() == 5);
        System.out.println(list.get(4) == 4);
        
        // add at index test
        list.add(4,777);
        System.out.println(list.size() == 6);
        System.out.println(list.get(4) == 777);

        // set test
        list.set(4, 666);
        System.out.println(list.size() == 6);
        System.out.println(list.get(4) == 666);

        // index of test
        System.out.println(list.indexOf(666) == 4);

        // remove by index test
        System.out.println(list.remove(4) == 666);
        System.out.println(list.size() == 5);

        // remove object that exist test
        list.add(2,777);
        System.out.println(list.remove((Object) 777));
        System.out.println(list.get(2) == 2);
        System.out.println(list.size() == 5);

        // remove object that doesn't exist test
        System.out.println(!list.remove((Object) 777));
        System.out.println(list.get(2) == 2);
        System.out.println(list.size() == 5);

        System.out.println("DONE");
    }
}
