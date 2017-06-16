package com.example.testapp2;

/**
 * Created by smccullough on 6/15/2017.
 */

public class CharactersListItem {

    private String itemTitle;

    public String getItemTitle(){
        
        return itemTitle;
    }

    public void setItemTitle(String itemTitle){
        
        this.itemTitle = itemTitle;
    }

    public CharactersListItem(String title){
        
        this.itemTitle = title;
    }
}
