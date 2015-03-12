package com.yippie.library;

/**
 * Listview Adapter for Option Menu Fragment
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yippie.OptionMenuFragment.OptionMenuItems;
import com.yippie.R;

import java.util.List;

public class OptionMenuAdapter extends BaseAdapter
{
    private Activity activity;
    private List<OptionMenuItems> data;
    private LayoutInflater inflater;

    // Constructor
    public OptionMenuAdapter(Activity act, List<OptionMenuItems> list)
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

    // Custom baseAdapter function. This will return the option menu object.
    public OptionMenuItems getCurrentMenu(int position){
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

            // Assign menu menu list items design
            convertView = inflater.inflate(R.layout.option_menu_items, null);

            // Import Design
            holder.menuIcon = (ImageView) convertView.findViewById(R.id.menuIcon);
            holder.menuName = (TextView) convertView.findViewById(R.id.menuName);
        }
        else
        {
            // View already exists
            // Retrieve existing view using Tag.
            holder = (ViewHolder) convertView.getTag();
        }

        // Get current menu items
        OptionMenuItems curMenu = getCurrentMenu(position);
        // Get Menu Icon & Name
        int icon = curMenu.getMenuIcon();
        String name = curMenu.getMenuName();

        // Set Menu Icon
        holder.menuIcon.setImageResource(icon);
        // Set Menu Name
        holder.menuName.setText(name);

        return convertView;
    }

    // Create a ViewHolder class
    // Note: This class is used to store the list view cell
    public static class ViewHolder
    {
        ImageView menuIcon;
        TextView menuName;
    }

}
