package com.google.android.espressodemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms.*
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyWebActivityTest {

    @get:Rule
    var launch = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun getWebView()
    {
        onView(withId(R.id.btnMainActivity)).perform(click())
        onView(withId(R.id.tvSecondActivity)).perform(click())
    }

    @Test
    fun gmailSignIn() {

        onWebView()
            .withElement(findElement(Locator.XPATH, "//a[contains(text(),'Sign in')]"))
            .perform(webClick())

        Thread.sleep(2000)

        onWebView()
            .withElement(findElement(Locator.XPATH, "//input[@type='email']"))
            .perform(webKeys(User().email))

        onWebView()
            .withElement(findElement(Locator.XPATH, "//span[contains(.,'Next')]"))
            .perform(webClick())

        Thread.sleep(2000)

        onWebView()
            .withElement(findElement(Locator.XPATH, "//input[@type='password']"))
            .perform(webKeys(User().pwd))

        Thread.sleep(2000)

        onWebView()
            .withElement(findElement(Locator.XPATH, "//span[contains(.,'Next')]"))
            .perform(webClick())

        Thread.sleep(2000)

        onWebView()
            .withElement(findElement(Locator.XPATH, "//div[contains(text(),'Tap')]"))
            .perform(webClick())

    }

    @After
    fun tearDown()
    {
        Thread.sleep(5000*2)

        onWebView()
            .inWindow(selectFrameByIdOrName("account"))
            .withElement(findElement(Locator.XPATH,"//a[@class='gb_A gb_La gb_f']"))
            .perform(webClick())

        Thread.sleep(3000)

        onWebView()
            .inWindow(selectFrameByIdOrName("account"))
            .withElement(findElement(Locator.XPATH,"//div[contains(text(),'Sign out')]"))
            .perform(webClick())

        Thread.sleep(10000)

    }
}
