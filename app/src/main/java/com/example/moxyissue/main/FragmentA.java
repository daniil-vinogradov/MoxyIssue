package com.example.moxyissue.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.moxyissue.R;
import com.example.moxyissue.view.CustomWidget;


public class FragmentA extends MvpAppCompatFragment implements FragmentAView {

    @InjectPresenter
    FragmentAPresenter mPresenter;

    private CustomWidget mCustomWidget;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mCustomWidget = view.findViewById(R.id.custom_widget);
        mCustomWidget.init(getMvpDelegate());
        view.findViewById(R.id.bt_goto_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).openFragmentB();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Moxy", "onDestroyView");

//        TODO Moxy CustomView workaround
//        try {
//            Field field = MvpDelegate.class.getDeclaredField("mChildDelegates");
//            field.setAccessible(true);
//            List<MvpDelegate> childDelegates = (List<MvpDelegate>) field.get(getMvpDelegate());
//            childDelegates.remove(mCustomWidget.getMvpDelegate());
//        } catch (Throwable ignored) {
//            // do nothing
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Moxy", "onDestroy");
    }

    @Override
    public void showCustomView(@NonNull String text) {
        ((TextView) getView().findViewById(R.id.text_view)).setText(text);
    }
}
