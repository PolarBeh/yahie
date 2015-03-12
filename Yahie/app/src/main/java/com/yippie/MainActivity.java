package com.yippie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import java.util.Stack;
import com.yippie.library.FragmentHolderInterface;
import com.yippie.library.FragmentInterface;

public class MainActivity extends ActionBarActivity implements FragmentHolderInterface
{
    public static Activity curActivity;

    public static Stack<String>fragmentStackIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Temporary disable tab feature.
        this.setContentView(R.layout.activity_main);

        // Setup ActionBar Menu

        fragmentStackIDs = new Stack<String>();

        // For future development purpose:
        // This activity will now hold product list fragment, if we need to add more fragment in this activity
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment newFragment = new MainMapFragment();
        fragmentTransaction.add(R.id.content_frame, newFragment, MainMapFragment.FRAGMENT_TAG);
        fragmentStackIDs.add(MainMapFragment.FRAGMENT_TAG);
        fragmentTransaction.commit();
    }

    /**
     * This is a function to add new fragment on top of fragment stack.
     * @param newFragTag
     * @param newFrag
     */
    @Override
    public void addFragment(String newFragTag, Fragment newFrag, Boolean removePreviousStacks)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Check if we need to remove the previous stack.
        if(removePreviousStacks)
        {
            // Remove all fragment except first fragment (PickedProductList)
            Integer stackCount = fragmentManager.getBackStackEntryCount();
            while(stackCount > 0)
            {
                fragmentStackIDs.pop();
                fragmentManager.popBackStack();

                stackCount--;
            }
        }
        // Get the top fragment tag name
        String topFragmentTagName = fragmentStackIDs.peek();
        // Set the fragment animation
        // This animation will result in new fragment slide from left to right, while old fragment will slide from from right to outer screen
        // Upon press removing the fragment, the removed fragment will slide from right to left, and previous fragment will slide in from right to left
//        fragmentTransaction.setCustomAnimations(R.anim.pop_enter, R.anim.pop_exit, R.anim.pop_enter, R.anim.pop_exit);
        fragmentTransaction.add(R.id.content_frame, newFrag, newFragTag);
        fragmentStackIDs.add(newFragTag);
        fragmentTransaction.addToBackStack(topFragmentTagName);
        fragmentTransaction.commit();
    }

    /**
     * Function to remove the top fragment from the stack, and switch back to previous fragment.
     */
    @Override
    public void removeFragment()
    {
        // Get the Fragment Manager and check if the BackStackEntry is empty, if it is not empty
        // upon pressing the back button, we should pop/remove current fragment
        // Else, we will quit the application.
        FragmentManager fragmentManager = getSupportFragmentManager();

        if(fragmentManager.getBackStackEntryCount() < 1)
        {
            // Close
            finish();
        }
        else
        {
            fragmentStackIDs.pop();
            fragmentManager.popBackStack();
        }
    }

    /**
     * This is a function the top fragment of the fragment stack
     * @return currFragment (Fragment) - The top fragment of current fragment stack.
     */
    @Override
    public Fragment getTopFragment()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();

        String topFragmentTag = fragmentStackIDs.peek();
        Fragment currFragment = fragmentManager.findFragmentByTag(topFragmentTag);

        return currFragment;
    }

    @Override
    public FragmentManager getCurrentFragmentManager()
    {
        return getSupportFragmentManager();
    }
}
