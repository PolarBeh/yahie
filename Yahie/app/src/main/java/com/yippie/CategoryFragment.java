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

import com.yippie.library.CategoryMenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment
{
    // Set a tag for this fragment. This var is static, can be referene cia MainMapFragment.FRAGMENT_TAG
    public static final String FRAGMENT_TAG = "CATEGORY";
    public static final String FOOD_BEVERAGE_TAG = "FOOD_BEVERAGE";
    public static final String TOURISM_HOTSPOT_TAG = "TOURISM_HOTSPOT";
    public static final String HOTEL_INN_TAG = "HOTEL_INN";
    public static final String SHOPPING_TAG = "SHOPPING";
    public static final String PETROL_STATION_TAG = "PETROL_STATION";

    // Array list that store list of category
    Activity activity;
    CategoryMenuAdapter adapter;
    List<CategoryItems> categoryItemsList;
    ListView categoryListView;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get category list
        categoryItemsList = getCategoryMenuList();

        // Setup List View Adapter
        adapter = new CategoryMenuAdapter(activity, categoryItemsList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // In fragment, we cannot set content view in main, we can only set interface view in onCreateView
        // Set layout
        View view = inflater.inflate(R.layout.category, container, false);

        // Import asset
        categoryListView = (ListView) view.findViewById(R.id.categoryList);

        categoryListView.setAdapter(adapter);

        // Handle category items click event
        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // Get clicked category object
                CategoryItems curCategoryObj = categoryItemsList.get(position);
                String menuTag = curCategoryObj.getCategoryTag();

                switch(menuTag)
                {
                    // When food & beverage category item is selected
                    case FOOD_BEVERAGE_TAG:
                        String msg0 = "Food & Beverage Clicked";
                        Toast.makeText(activity.getApplicationContext(), msg0, Toast.LENGTH_SHORT).show();
                        break;

                    // When tourism hotspot category item is selected
                    case TOURISM_HOTSPOT_TAG:
                        String msg1 = "Tourism Hotpsot Clicked";
                        Toast.makeText(activity.getApplicationContext(), msg1, Toast.LENGTH_SHORT).show();
                        break;

                    // When hotel inn category item is selected
                    case HOTEL_INN_TAG:
                        String msg2 = "Hotel Inn Clicked";
                        Toast.makeText(activity.getApplicationContext(), msg2, Toast.LENGTH_SHORT).show();
                        break;

                    // When shopping category item is selected
                    case SHOPPING_TAG:
                        String msg3 = "Shopping Complex Clicked";
                        Toast.makeText(activity.getApplicationContext(), msg3, Toast.LENGTH_SHORT).show();
                        break;

                    // When petrol station category item is selected
                    case PETROL_STATION_TAG:
                        String msg4 = "Petrol Station Clicked";
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
    public List<CategoryItems> getCategoryMenuList()
    {
        List<CategoryItems> category_Items_list = new ArrayList<CategoryItems>();

        // Add Food & Beverage Category
        int foodBeverageIcon = R.drawable.icon_explorer;
        String foodBeverageName = "Food & Beverage";
        category_Items_list.add(new CategoryItems(FOOD_BEVERAGE_TAG,foodBeverageName,foodBeverageIcon));

        // Add Tourism Hotspot Category
        int tourismHotspotIcon = R.drawable.icon_explorer;
        String tourismHotspotName = "Tourism Hotspot";
        category_Items_list.add(new CategoryItems(TOURISM_HOTSPOT_TAG,tourismHotspotName,tourismHotspotIcon));

        // Add Hotel & INN Category
        int hotelInnIcon = R.drawable.icon_explorer;
        String hotelInnName = "Hotel & Inn";
        category_Items_list.add(new CategoryItems(HOTEL_INN_TAG,hotelInnName,hotelInnIcon));

        // Add Shopping Category
        int shoppingIcon = R.drawable.icon_explorer;
        String shoppingName = "Shopping Complex";
        category_Items_list.add(new CategoryItems(SHOPPING_TAG,shoppingName,shoppingIcon));

        // Add Petrol Station Category
        int petrolStationIcon = R.drawable.icon_explorer;
        String petrolStationName = "Petrol Station";
        category_Items_list.add(new CategoryItems(PETROL_STATION_TAG,petrolStationName,petrolStationIcon));

        return category_Items_list;
    }

    /**
     * Category class to use in Category Tab List View
     */
    public static class CategoryItems
    {
        Integer categoryId;
        String categoryTag;
        String categoryName;
        int categoryIcon;

        // Constructor
        public CategoryItems(String catTag, String catName, int catIcon)
        {
            categoryTag = catTag;
            categoryName = catName;
            categoryIcon = catIcon;
        }

        // Getter
        public Integer getCategoryId(){
            return categoryId;
        }

        public String getCategoryTag(){
            return categoryTag;
        }

        public String getCategoryName(){
            return categoryName;
        }

        public Integer getCategoryIcon(){
            return categoryIcon;
        }

        // Setter
        public void setCategoryId(Integer catId){
            categoryId = catId;
        }

        public void setCategoryTag(String catTag){
            categoryTag = catTag;
        }

        public void setCategoryName(String catName){
            categoryName = catName;
        }

        public void setCategoryIcon(int catIcon){
            categoryIcon = catIcon;
        }
    }
}
