[1mdiff --git a/app/src/androidTest/java/com/google/android/espressodemo/MainActivityTest.kt b/app/src/androidTest/java/com/google/android/espressodemo/MainActivityTest.kt[m
[1mindex 44800ff..b866124 100644[m
[1m--- a/app/src/androidTest/java/com/google/android/espressodemo/MainActivityTest.kt[m
[1m+++ b/app/src/androidTest/java/com/google/android/espressodemo/MainActivityTest.kt[m
[36m@@ -7,6 +7,7 @@[m [mimport androidx.test.espresso.assertion.ViewAssertions.matches[m
 import androidx.test.espresso.matcher.ViewMatchers.*[m
 import androidx.test.ext.junit.rules.ActivityScenarioRule[m
 import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner[m
[32m+[m[32mimport junit.framework.Assert.assertEquals[m
 import org.junit.Rule[m
 import org.junit.Test[m
 import org.junit.runner.RunWith[m
[36m@@ -67,4 +68,13 @@[m [mclass MainActivityTest {[m
         onView(withId(R.id.parent_id))[m
             .check(matches(hasChildCount(2)))[m
     }[m
[32m+[m
[32m+[m[32m    @Test[m
[32m+[m[32m    fun textAssertion()[m
[32m+[m[32m    {[m
[32m+[m[32m        val expt = R.string.hey_welcome[m
[32m+[m[32m        val act = WaitSteps().getText(onView(withId(R.id.welcomeActivity)))[m
[32m+[m
[32m+[m[32m        assertEquals("exp!=act",expt,act)[m
[32m+[m[32m    }[m
 }[m
\ No newline at end of file[m
