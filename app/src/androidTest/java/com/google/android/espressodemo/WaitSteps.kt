package com.google.android.espressodemo

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher
import org.junit.Assert.assertTrue
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
class WaitSteps {
    fun isDisplayed(id: Int): Boolean {
        return try {
            onView(withId(id)).check(matches(ViewMatchers.isDisplayed()))
            true
        } catch (e: Throwable) {
            false
        }
    }

    fun waitForElement(id: Int) {
        var count = 0
        if (!isDisplayed(id)) {
            while (!isDisplayed(id)) {
                Thread.sleep(1000)
                if (count == 5) {
                    break
                }
                count++
            }
            assertTrue(" Element is Not Found in The View ", count < 5)
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------
    fun getText(viewInteraction: ViewInteraction):String
    {
        lateinit var text:String

        viewInteraction.perform(object: ViewAction{
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(TextView::class.java)
            }

            override fun getDescription(): String {
                return "text view is not found"
            }

            override fun perform(uiController: UiController?, view: View?) {
                val textView=view as TextView
                text = textView.text.toString()
            }

        })
        return text
    }

}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------

data class User(
    var email  : String = "avinashkurahatti919@gmail.com",
    var pwd : String =  "avinash@1998"
 )

//--------------------------------------------------------------------------------------------------------------------------------------------------------------