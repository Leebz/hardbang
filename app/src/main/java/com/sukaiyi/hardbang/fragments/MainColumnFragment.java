package com.sukaiyi.hardbang.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shehabic.droppy.DroppyClickCallbackInterface;
import com.shehabic.droppy.DroppyMenuItem;
import com.shehabic.droppy.DroppyMenuPopup;
import com.sukaiyi.hardbang.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainColumnFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainColumnFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public MainColumnFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static MainColumnFragment newInstance(OnFragmentInteractionListener listener) {
        MainColumnFragment fragment = new MainColumnFragment();
        fragment.mListener = listener;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_column, container, false);
        // Assume we have a button in our Layout as follows
        Button anchor = (Button) rootView.findViewById(R.id.button);

        DroppyMenuPopup.Builder droppyBuilder = new DroppyMenuPopup.Builder(getContext(), anchor);

        // Add normal items (text only)
        droppyBuilder.addMenuItem(new DroppyMenuItem("test1"))
                .addMenuItem(new DroppyMenuItem("test2"))
                .addSeparator();
        // Add Item with icon
        droppyBuilder.addMenuItem(new DroppyMenuItem("test3", R.mipmap.ic_launcher));
        // Set Callback handler
        droppyBuilder.setOnClick(new DroppyClickCallbackInterface() {
            @Override
            public void call(View v, int id) {
                Log.d("Clicked on ", String.valueOf(id));
            }
        });

        DroppyMenuPopup droppyMenu = droppyBuilder.build();

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
