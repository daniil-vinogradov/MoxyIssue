package com.example.moxyissue.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class FragmentAPresenter extends MvpPresenter<FragmentAView> {

    @Override
    protected void onFirstViewAttach() {
        getViewState().showCustomView("FragmentA with CustomView");
    }
}
