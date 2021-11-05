package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.PopupMenu;


import androidx.fragment.app.Fragment;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;
import com.google.android.material.button.MaterialButton;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MenuFragment extends Fragment {

    public static final String TAG = "Menu";

    private static Component mInstance;

    Unbinder mUmbinder;


    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mUmbinder = ButterKnife.bind(this, view);


        View btnMenuPopup;
        btnMenuPopup.setOnClickListener(view1 -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(),view1);
            popupMenu.getMenuInflater().inflate(R.menu.menu_bottom_nav,popupMenu.getMenu());
            popupMenu.show();
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mUmbinder.unbind();
    }
}