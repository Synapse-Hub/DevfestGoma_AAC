package com.example.david.devfestgoma_aac;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;

@RunWith(AndroidJUnit4.class)
public class PersonneCreationTest {
    @Rule
 public    ActivityTestRule<MainActivity> mPersonneActivityRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void createNewPerson(){
        onView(withId(R.id.add_person)).perform(click());
        onView(withId(R.id.name)).perform(typeText("David"),
                closeSoftKeyboard());
        onView(withId(R.id.masculin_rb)).perform(click());
        Espresso.pressBack();


    }
}