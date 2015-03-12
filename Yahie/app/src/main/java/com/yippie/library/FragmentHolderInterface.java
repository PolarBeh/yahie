package com.yippie.library;

/**
 * This is an interface to be used by the Activity that holds fragment.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public interface FragmentHolderInterface
{
    /**
     * Function that add fragment to the top of fragment stack should placed in this function.
     * @param newFragTag (String)- The tag name of new fragment.
     * @param newFrag (Fragment) - The fragment to be added to top of the stack.
     * @param removePreviousStacks (Boolean) - The flag that indicates to remove all previous fragment stacks
     */
    public void addFragment(String newFragTag, Fragment newFrag, Boolean removePreviousStacks);

    /**
     * Function that remove the top fragment from the fragment stack should placed in this function.
     */
    public void removeFragment();

    /**
     * Function to get most top fragment of the fragment stack.
     * @return Most top fragment.
     */
    public Fragment getTopFragment();

    /**
     * Function to get the fragment manager of fragment holder activity
     * @return fragment manager
     */
    public FragmentManager getCurrentFragmentManager();
}