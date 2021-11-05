package com.alain.cursos.mdcomponents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alain.cursos.mdcomponents.R;
import com.alain.cursos.mdcomponents.utils.Component;
import com.alain.cursos.mdcomponents.utils.Constants;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CardFragment extends Fragment {

    public CardFragment() {
        // Required empty public constructor
    }

    public static final String TAG = "Card";

    private static Component mInstance;
    Unbinder mUnbinder;

    public static Component getmInstance() {
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_card, container, false);
        mUnbinder = ButterKnife.bind( this, view);

        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop();
        Glide.with(this)
                .load("https://media-cdn.tripadvisor.com/media/photo-l/17/f5/39/f7/fooood-at-the-food-department.jpg")
                .apply(options)
                .into(imgCardLarge);

        chpSecond.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked){
                Toast.makeText(getActivity(),"Checked Chip", Toast.LENGTH_SHORT).show();
            }
        });

        chpThird.setOnCloseIconClickListener(view1 -> chpThird.setVisibility(View.GONE));



        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

}