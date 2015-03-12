package com.yippie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yippie.library.HttpRequestInterface;
import com.yippie.library.FragmentInterface;
import com.yippie.library.HttpReturnObject;


public class MainMapFragment extends Fragment implements HttpRequestInterface, FragmentInterface
{
    // Set a tag for this fragment. This var is static, can be referene cia MainMapFragment.FRAGMENT_TAG
    public static final String FRAGMENT_TAG = "MAIN_MAP";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // In fragment, we cannot set content view in main, we can only set interface view in onCreateView
        // Set layout
        View view = inflater.inflate(R.layout.main_map, container, false);



        return view;
    }


    @Override
    public Boolean onBackPressedEvent(Fragment currentFragment, FragmentManager fragmentManager) {
        return null;
    }

    @Override
    public void HttpRequestPreExecuteDelegate() {

    }

    @Override
    public void HttpRequestDoInBackgroundDelegate(HttpReturnObject response) {

    }

    @Override
    public void HttpRequestDoInBackgroundErrorDelegate(HttpReturnObject response) {

    }

    @Override
    public void HttpRequestProgressUpdateDelegate(HttpReturnObject response) {

    }

    @Override
    public void HttpRequestOnPostExecuteUpdateDelegate(HttpReturnObject response) {

    }
}
