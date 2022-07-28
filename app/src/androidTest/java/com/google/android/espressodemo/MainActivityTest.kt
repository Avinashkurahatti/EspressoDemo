package com.google.android.espressodemo

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    // main activity will launch before class and closes after all testcases got executed

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun checkTextVisibility() {
        onView(withId(R.id.welcomeActivity))
            .check(matches(isDisplayed()))

        // checking if button is displayed
        onView(withId(R.id.btnMainActivity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun textValidation() {
        onView(withId(R.id.welcomeActivity)).check(matches(withText(R.string.hey_welcome)))
    }

    @Test
    fun navigate2NextPage() {
        // import androidx.test.espresso.action.ViewActions.click
        onView(withId(R.id.btnMainActivity)).perform(click())

        // checking good bye activity
        onView(withId(R.id.tvSecondActivity)).check(matches(isDisplayed()))
    }

    @Test
    fun testBackButton() {
        onView(withId(R.id.btnMainActivity))
            .perform(click()) // for navigating to the second page

        onView(withId(R.id.tvSecondActivity))
            .check(matches(isDisplayed()))

        Espresso.pressBack()

        // after clicking on back button main activity should be visible
        onView(withId(R.id.welcomeActivity))
            .check(matches(isDisplayed()))

    }
}