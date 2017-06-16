package com.example.testapp2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by smccullough on 6/15/2017.
 */

public class CharactersListAdapter extends ArrayAdapter{

    private Context context;
    private boolean useList = true;

    public CharactersListAdapter(Context context, List items){
        super(context, android.R.layout.simple_list_item_1, items);
        this.context = context;
    }

    //Holder for list items
    private class ViewHolder{
        TextView titleText;
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @SuppressLint("WrongViewCast")
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        CharactersListItem item = (CharactersListItem)getItem(position);
        View viewToUse = null;

        //This block inflates the settings list item conditionally, based on when the list or grid view is supported
        LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            if (useList) {
                viewToUse = mInflater.inflate(R.layout.characters_list_item, null);
            } else {
                viewToUse = mInflater.inflate(R.layout.characters_grid_item, null);
            }

            holder = new ViewHolder();
            holder.titleText = (TextView) viewToUse.findViewById(R.id.titleTextView);
            viewToUse.setTag(holder);
        }
        else{
            viewToUse = convertView;
            holder = (ViewHolder) viewToUse.getTag();
        }

        holder.titleText.setText(item.getItemTitle());
        return viewToUse;



    }

}
