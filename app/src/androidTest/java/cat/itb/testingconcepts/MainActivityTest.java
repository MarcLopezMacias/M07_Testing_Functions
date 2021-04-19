package cat.itb.testingconcepts;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static final String USER_TO_BE_TYPED = "NotUsername", PASSWORD_TO_BE_TYPED = "Password";


    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);


    // ACTIVITY 2
    // 1
    @Test
    public void view_elements_are_displayed_properly() {
        onView(withId(R.id.titleTextView))
                .check(matches(isDisplayed()));
        onView(withId(R.id.mainButton))
                .check(matches(isDisplayed()));
    }

    // 2
    @Test
    public void texts_are_correct() {
        onView(withId(R.id.titleTextView))
                .check(matches(withText(R.string.main_activity_title)));
        onView(withId(R.id.mainButton))
                .check(matches(withText(R.string.next)));
    }

    // 3
    @Test
    public void button_is_clickable_and_once_clicked_text_is_correct() {
        onView(withId(R.id.mainButton))
                .check(matches(isClickable()));
        onView(withId(R.id.mainButton))
                .perform(click());
        onView(withId(R.id.mainButton))
                .check(matches(withText(R.string.back)));
    }

    // ACTIVITY 3
    @Test
    public void login_form_behaviour() {
        // a
        onView(withId(R.id.usernameEditText)).perform(typeText(USER_TO_BE_TYPED));
        onView(withId(R.id.usernameEditText)).perform(closeSoftKeyboard());

        // b
        onView(withId(R.id.passwordEditText)).perform(typeText(PASSWORD_TO_BE_TYPED));
        onView(withId(R.id.passwordEditText)).perform(closeSoftKeyboard());

        // c
        onView(withId(R.id.mainButton)).perform(click());
        // ONCE THE FOLLOWING EXERCISES ARE COMPLETED, THIS NEXT CALL MAKES THE TESTS FAIL, SINCE THE VIEW DOESN'T EXIST ANYMORE ONCE THE BUTTON IS CLICKED.
        // onView(withId(R.id.mainButton)).check(matches(withText(R.string.logged)));

    }

    // ACTIVITY 4

    // 1
    @Test
    public void activity_changed() {
        login_form_behaviour();
        onView(withId(R.id.welcomeBackActivity)).check(matches(isDisplayed()));
    }

    // 2 & 3
    @Test
    public void activity_changed_2_n_3() {
        // USE OF UI BUTTON
        activity_changed();
        onView(withId(R.id.welcomeButton)).perform(click());
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));

        // USE OF ANDROID BUTTON
        activity_changed();
        onView(withId(R.id.welcomeBackActivity)).perform(pressBack());
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));
    }

    // ACTIVITY 5
    @Test
    public void activity5() {
        // 1, 2, 3 & 4
        activity_changed();

        // 5
        onView(withId(R.id.welcomeBackTextView)).check(matches(withText("Welcome Back" + " " + USER_TO_BE_TYPED)));

        // 6
        onView(withId(R.id.welcomeButton)).perform(click());

        // 7
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()));

        // 8
        onView(withId(R.id.usernameEditText)).check(matches(withText("")));
        onView(withId(R.id.passwordEditText)).check(matches(withText("")));

    }

    // BARISTA COPIED FUNCTION
//    clickOn(R.id.button)
//    clickOn("Next")
//    clickMenu(R.id.menu_item)
//    writeTo(R.id.edittext, "A great text")
//    clickListItemChild(R.id.list, 3, R.id.row_button)
//    clickDialogPositiveButton()

}
