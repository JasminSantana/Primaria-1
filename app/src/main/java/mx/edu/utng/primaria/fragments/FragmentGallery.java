package mx.edu.utng.primaria.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.edu.utng.primaria.R;

/**
 * Created by Alumno on 24/01/2017.
 */
public class FragmentGallery extends Fragment {
    private OnFragmentInteractionListener listener;
    public FragmentGallery(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_gallery, container, false);
    }
    public void onButtonPressed(Uri uri){
        if (listener!=null){
            listener.onFragmentInteraction(uri);

        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

        } catch (ClassCastException e){
            throw  new ClassCastException(activity.toString()+"must implement OnFragmentInteractionListener");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(Uri uri);
    }
}
