import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.developer.android.tip.time.MainActivity
import com.developer.android.tip.time.R
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    /*
     * Android test library annotation.
     * should execute before every test in the class
     */
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip() {
        /*
         * Use expresso to add value to edittext
         */
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard()) // Close keyboard

        /*
         * Click button
         */
        onView(withId(R.id.calculate_button))
            .perform(click())

        /*
         * Check if string matches
         */
        onView(withId(R.id.tip_result))
                // Content of textView
            .check(matches(withText(containsString("$10.00"))))
    }
}