package com.privalia.albert.challenge.presentation.ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import com.privalia.albert.challenge.presentation.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.object.HasToString.hasToString;
import static org.junit.Assert.assertThat;

/**
 * Created by albert on 25/1/18.
 */

@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        activityRule.launchActivity(new Intent());
    }

    @Test
    public void hideOrderAndPerformFilterOnType() throws Exception {
        onView((withId(R.id.text_search))).perform(typeText("test"));

        onView(withId(R.id.loading)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_order)).check(matches(not(isDisplayed())));
    }

    @Test
    public void hideOrderAndPerformFilterWhenNoQuery() throws Exception {
        onView((withId(R.id.text_search))).perform(typeText(""));

        onView(withId(R.id.loading)).check(matches(isDisplayed()));
        onView(withId(R.id.layout_order)).check(matches(isDisplayed()));
    }

    @Test
    public void loadWhenOrderChange() throws Exception {
        onView(withId(R.id.layout_order)).check(matches(not(isDisplayed())));
        onView(withId(R.id.sort_value)).perform(click());
        onData(hasToString(is("original_title"))).perform(click());
        onView(withId(R.id.sort_value))
                .check(matches(withSpinnerText(containsString("original_title"))));

        onView(withId(R.id.loading)).check(matches(isDisplayed()));

        assertThat(getRecyclerViewCount(), is(0));
    }

    @Test
    public void fetchDataWhenScrollBottom() throws Exception {
        onView(withId(R.id.loading)).check(matches(not(isDisplayed())));
        onView(withId(R.id.recycler_movies))
                .perform(RecyclerViewActions.scrollToPosition(getRecyclerViewCount() - 1));
        onView(withId(R.id.loading)).check(matches(isDisplayed()));
    }

    @Test
    public void orderChangedWhenOrderButtonClicked() throws Exception {
        onView(withId(R.id.loading)).check(matches(not(isDisplayed())));
        Drawable drawableBeforeClick =
                ((ImageButton)this.activityRule.getActivity().findViewById(R.id.sort_direction))
                        .getDrawable();

        onView(withId(R.id.sort_direction)).perform(click());

        Drawable drawableAfterClick =
                ((ImageButton)this.activityRule.getActivity().findViewById(R.id.sort_direction))
                        .getDrawable();


        if (drawableAfterClick != null && drawableAfterClick.getConstantState() != null) {
            assertThat(drawableBeforeClick,
                    is(not(drawableAfterClick
                            .getConstantState()
                            .equals(drawableBeforeClick.getConstantState()))));
        }
    }

    private int getRecyclerViewCount(){
        RecyclerView recyclerView =
                (RecyclerView) this.activityRule.getActivity().findViewById(R.id.recycler_movies);
        return recyclerView.getAdapter().getItemCount();
    }
}