package com.alain.cursos.mdcomponents.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.snackbar.Snackbar;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class SnackBarFragment extends Fragment {


    public static final String TAG = "SnackBar";

    private static Component mInstance;
    Unbinder mUnbinder;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_singleline_action);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public SnackBarFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_snack_bar, container, false);

        mUnbinder = ButterKnife.bind( this, view);

        Snackbar.make(container, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAction("volver", view1 ->getActivity().finish())
                .show();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

}