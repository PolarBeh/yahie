package com.yippie;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yippie.library.OptionMenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class OptionMenuFragment extends Fragment
{
    // Set a tag for this fragment. This var is static, can be referene cia MainMapFragment.FRAGMENT_TAG
    public static final String FRAGMENT_TAG = "OPTIONMENU";
    public static final String ACCOUNT_INFO_TAG = "ACCOUNT_INFO";
    public static final String FEEDBACK_TAG = "FEEDBACK";
    public static final String CONTACT_US_TAG = "CONTACT_US";
    public static final String LOGOUT_TAG = "LOGOUT";

    // Array list that store list of category
    Activity activity;
    OptionMenuAdapter adapter;
    List<OptionMenuItems> menuItemsList;
    ListView menuListView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get category list
        menuItemsList = getCategoryMenuList();

        // Setup List View Adapter
        adapter = new OptionMenuAdapter(activity, menuItemsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // In fragment, we cannot set content view in main, we can only set interface view in onCreateView
        // Set layout
        View view = inflater.inflate(R.layout.option_menu, container, false);

        // Import asset
        menuListView = (ListView) view.findViewById(R.id.optionMenuList);

        // Set the adapter for listview
        menuListView.setAdapter(adapter);

        // Handle option menu click event
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // get clicked option menu object
                OptionMenuItems curMenuItem = menuItemsList.get(position);
                String menuTag = curMenuItem.getMenuTag();

                switch(menuTag)
                {
                    // When account info menu item is selected
                    case ACCOUNT_INFO_TAG:
                        String msg1 = "Account Info Clicked";
                        Toast.makeText(activity.getApplicationContext(), msg1, Toast.LENGTH_SHORT).show();
                        break;

                    // When contact us menu item is selected
                    case CONTACT_US_TAG:
                        String msg2 = "Contact Us Clicked";
                        Toast.makeText(activity.getApplicationContext(), msg2, Toast.LENGTH_SHORT).show();
                        break;

                    // When feedback menu item is selected
                    case FEEDBACK_TAG:
                        String msg3 = "Feedback Clicked";
                        Toast.makeText(activity.getApplicationContext(), msg3, Toast.LENGTH_SHORT).show();
                        break;

                    // When logout menu item is selected
                    case LOGOUT_TAG:
                        String msg4 = "LOGOUT Clicked";
                        Toast.makeText(activity.getApplicationContext(), msg4, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity act)
    {
        super.onAttach(act);
        activity = act;
    }

    /**
     * Function to get the list of category item
     */
    public List<OptionMenuItems> getCategoryMenuList()
    {
        List<OptionMenuItems> menu_items_list = new ArrayList<OptionMenuItems>();

        // Add User Info Menu Item
        int accDetailIcon = R.drawable.icon_explorer;
        String accDetailName = "Account Information";
        menu_items_list.add(new OptionMenuItems(ACCOUNT_INFO_TAG,accDetailName,accDetailIcon));

        // Add Feedback menu Item
        int feedbackIcon = R.drawable.icon_explorer;
        String feedbackName = "Feedback";
        menu_items_list.add(new OptionMenuItems(FEEDBACK_TAG,feedbackName,feedbackIcon));

        // Add Contact Us Menu Item
        int contactUsIcon = R.drawable.icon_explorer;
        String contactUsName = "Contact Us";
        menu_items_list.add(new OptionMenuItems(CONTACT_US_TAG,contactUsName,contactUsIcon));

        // Add Logout
        int logoutIcon = R.drawable.icon_explorer;
        String logoutName = "Log Out";
        menu_items_list.add(new OptionMenuItems(LOGOUT_TAG,logoutName,logoutIcon));

        return menu_items_list;
    }

    /**
     * Option Menu Class 
     */
    public static class OptionMenuItems
    {
        String menuTag;
        String menuName;
        int menuIcon;

        // Constructor
        public OptionMenuItems(String catTag, String catName, int catIcon)
        {
            menuTag = catTag;
            menuName = catName;
            menuIcon = catIcon;
        }

        // Getter
        public String getMenuTag(){
            return menuTag;
        }

        public String getMenuName(){
            return menuName;
        }

        public Integer getMenuIcon(){
            return menuIcon;
        }

        // Setter
        public void setMenuTag(String catTag){
            menuTag = catTag;
        }

        public void setMenuName(String catName){
            menuName = catName;
        }

        public void setMenuIcon(int catIcon){
            menuIcon = catIcon;
        }
    }
}
