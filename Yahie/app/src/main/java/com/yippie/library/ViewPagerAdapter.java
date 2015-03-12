package com.yippie.library;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

// Import requried Tab fragment
import com.yippie.MainMapFragment;
import com.yippie.CategoryFragment;
import com.yippie.EventFragment;
import com.yippie.OptionMenuFragment;

/**
 * Created by PaperGoat on 3/10/2015
 */
public class ViewPagerAdapter extends FragmentPagerAdapter
{
    public static final Integer MAIN_MAP_FRAG = 0;
    public static final Integer CATEGORY_FRAG = 1;
    public static final Integer EVENT_FRAG = 2;
    public static final Integer OPTION_MENU_FRAG = 3;
    public static final Integer TOTAL_FRAGMENT = 4;

    private final Resources resources;
    SparseArray<Fragment> fragmentList = new SparseArray<Fragment>(); // SparseArray that store fragment in a map

    public ViewPagerAdapter(FragmentManager fm, Resources resources)
    {
        super(fm);
        this.resources = resources;
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment currentFragment = null;

        // Main Map Fragment
        if(position == MAIN_MAP_FRAG)
        {
            currentFragment = new MainMapFragment();
        }
        // Category Fragment
        else if(position == CATEGORY_FRAG)
        {
            currentFragment = new CategoryFragment();
        }
        // Event Fragment
        else if(position == EVENT_FRAG)
        {
            currentFragment = new EventFragment();
        }
        // Option Menu Fragment
        else if(position == OPTION_MENU_FRAG)
        {
            currentFragment = new OptionMenuFragment();
        }

        return currentFragment;
    }

    @Override
    public int getCount()
    {
        return TOTAL_FRAGMENT;
    }

    /**
     * Store the fragment into the list using the reference. It will help us to retrieve the Fragment by position
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        // Get current fragment and put into the fragment list
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        fragmentList.put(position, fragment);
        return fragment;
    }

    /**
     * Removed the saved reference from the frgament list map
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        fragmentList.remove(position);
        super.destroyItem(container, position, object);
    }

    /**
     * Get the saved fragment from list
     * @param position
     * @return
     */
    public Fragment getSavedFragment(int position)
    {
        return fragmentList.get(position);
    }
}
