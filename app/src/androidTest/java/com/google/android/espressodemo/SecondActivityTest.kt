package com.google.android.espressodemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SecondActivityTest
{


    // ActivityScenarioRule launches a given activity before the test starts and closes after the test

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun checkActivity() {
        onView(withId(R.id.tvSecondActivity)).check(matches(isDisplayed()))
    }


    fun testButton() {
        onView(withId(R.id.btnSecondActivity)).check(matches(isDisplayed())) // checking its visible or not
        onView(withId(R.id.btnSecondActivity)).perform(click())  // perform if it is visible
    }

    @Test
    fun validateText() {
        onView(withId(R.id.tvSecondActivity)).check(matches(withText("Good Bye")))
    }
}