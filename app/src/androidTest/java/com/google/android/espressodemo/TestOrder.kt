package com.google.android.espressodemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// testcases execute based on ASCII values
@RunWith(AndroidJUnit4::class)
class TestOrder
{
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun cFun()
    {
        onView(withId(R.id.btnMainActivity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun bFun()
    {
        onView(withId(R.id.welcomeActivity))
            .check(matches(isDisplayed()))
    }

    @Test
    fun aFun()
    {
        onView(withId(R.id.btnMainActivity))
            .perform(click())

        Thread.sleep(2000)
    }
}