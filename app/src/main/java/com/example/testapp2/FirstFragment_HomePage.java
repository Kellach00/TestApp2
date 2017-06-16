package com.example.testapp2;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by smccullough on 6/7/2017.
 */

public class FirstFragment_HomePage extends Fragment {

    private OnFragmentInteractionListener mListener;
    View myView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout, container, false);
        return myView;
    }

    //Nesting a fragment within the current fragment's frame_layout
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }
        else{
            throw new RuntimeException(context.toString() +
                    " must implement onFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener{
        // TODO: Update argument type and name
        void messageFromParentFragment(Uri uri);
    }
}

