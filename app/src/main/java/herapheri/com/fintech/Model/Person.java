package herapheri.com.fintech.Model;

import java.util.ArrayList;
import java.util.List;

import herapheri.com.fintech.R;

/**
 * Created by codyj on 11/4/2017.
 */

class Person {
    String name;
    String age;
    int photoId;

    Person(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }
    private List<Person> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_action_name));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_action_name));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_action_name));
    }
}

