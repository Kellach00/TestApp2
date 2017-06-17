package com.example.testapp2.View;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.testapp2.R;

/**
 * Created by smccullough on 6/7/2017.
 */

public class FirstFragment_HomePage extends Fragment implements java.io.Serializable{

    private ListView characterListView;
    View myView;

    public FirstFragment_HomePage (){

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout, container, false);
        return myView;

    }

    //Populate xml ListView with character data
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

    }

    public void onClickSaveCharacter(){

        //TODO: implement an onclick function for the save button that calls to the service started in MainActivity


    }

}

