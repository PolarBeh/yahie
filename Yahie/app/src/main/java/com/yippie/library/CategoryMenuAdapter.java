package com.yippie.library;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yippie.CategoryFragment.CategoryItems;
import com.yippie.R;

import java.util.List;

public class CategoryMenuAdapter extends BaseAdapter
{
    private Activity activity;
    private List<CategoryItems> data;
    private LayoutInflater inflater;

    // Constructor
    public CategoryMenuAdapter(Activity act, List<CategoryItems> list)
    {
        activity = act;
        data = list;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Custom baseAdapter function. This will return the category object.
    public CategoryItems getCurrentCategory(int position){
        return data.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // In here, we will construct the custom view for the BaseAdapter.
        // We will be using a class to store the view of current cell.
        // Note: BaseAdapter involve in recycling the cell/view once the cell/view is out of screen.
        //		 Which mean you will notice the view display in wrong position of the list.
        //		 To counter this, we MUST use a tag to identify the cell.
        ViewHolder holder = null;

        if(convertView==null)
        {
            holder = new ViewHolder();

            // Assign category menu list items design
            convertView = inflater.inflate(R.layout.category_items, null);

            // Import Design
            holder.categoryIcon = (ImageView) convertView.findViewById(R.id.categoryIcon);
            holder.categoryName = (TextView) convertView.findViewById(R.id.categoryName);
        }
        else
        {
            // View already exists
            // Retrieve existing view using Tag.
            holder = (ViewHolder) convertView.getTag();
        }

        // Get current category items
        CategoryItems curCategoryItems = getCurrentCategory(position);
        // Get Category Icon & Name
        int icon = curCategoryItems.getCategoryIcon();
        String name = curCategoryItems.getCategoryName();

        // Set Category Icon
        holder.categoryIcon.setImageResource(icon);
        // Set Category Name
        holder.categoryName.setText(name);

        return convertView;
    }

    // Create a ViewHolder class
    // Note: This class is used to store the list view cell
    public static class ViewHolder
    {
        ImageView categoryIcon;
        TextView categoryName;
    }

}
