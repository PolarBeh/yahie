package com.yippie.library;

/**
 * This is the interface that sued by used by all fragment in this application.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface FragmentInterface
{
    // Function called when the fragment is newly attached to the top of fragment stack.
    public void onAttach(Activity act);

    // Function called when the fragment is created, all non UI function should placed in here.
    public void onCreate(Bundle savedInstanceState);

    // Function called when the fragment is created, all UI action must be done in here.
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * Function called when back button is pressed.
     * This function will be used when:
     * 1. You need extra confirmation when user leave the page.
     * Beware of the return type!
     * True/Null if safe to remove fragment
     * False if avoid remove fragment.
     */
    public Boolean onBackPressedEvent(Fragment currentFragment, FragmentManager fragmentManager);
}
