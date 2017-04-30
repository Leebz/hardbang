package com.sukaiyi.hardbang.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.sukaiyi.hardbang.R;
import com.sukaiyi.hardbang.UserDetailInfoActivity;
import com.sukaiyi.hardbang.systemConfig;

import cn.bmob.newim.BmobIM;
import cn.bmob.v3.BmobUser;
import in.myinnos.awesomeimagepicker.activities.AlbumSelectActivity;
import in.myinnos.awesomeimagepicker.helpers.ConstantsCustomGallery;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainMenuFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private BootstrapButton mExitBtn;
    private View mUserInfoBar;
    private View mSystemConfigBar;

    public MainMenuFragment() {
        // Required empty public constructor
    }

    public static MainMenuFragment newInstance(OnFragmentInteractionListener listener) {
        MainMenuFragment fragment = new MainMenuFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);
//        mExitBtn = (BootstrapButton) rootView.findViewById(R.id.exit);
//        mExitBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                BmobUser user = BmobUser.getCurrentUser(getContext());
//                if(user!=null){
//                    BmobIM.getInstance().disConnect();
//                    user.logOut(getContext());
//                    if (mListener != null) {
//                        Bundle bundle = new Bundle();
//                        bundle.putInt("action",OnFragmentInteractionListener.ACTION_LOGOUT);
//                        mListener.onFragmentInteraction(bundle);
//                    }
//                }
//            }
//        });

        mUserInfoBar = rootView.findViewById(R.id.user_info_bar);
        mUserInfoBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UserDetailInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("user",BmobUser.getCurrentUser(getContext()));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mSystemConfigBar = rootView.findViewById(R.id.systemconfigbar);
        mSystemConfigBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),systemConfig.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
