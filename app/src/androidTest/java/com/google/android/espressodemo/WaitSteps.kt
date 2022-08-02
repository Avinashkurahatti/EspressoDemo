package com.google.android.espressodemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Assert.assertTrue

class WaitSteps {
    fun isDisplayed(): Boolean {
        return try {
            onView(withId(R.id.btnSecondActivity)).check(matches(ViewMatchers.isDisplayed()))
            true
        } catch (e: Throwable) {
            false
        }
    }

    fun waitForElement() {
        var count = 0
        if (!isDisplayed()) {
            while (!isDisplayed()) {
                Thread.sleep(1000)
                if (count == 5) {
                    break
                }
                count++
            }
            assertTrue(" Element is Not Found in The View ", count <  5)
        }
    }
}