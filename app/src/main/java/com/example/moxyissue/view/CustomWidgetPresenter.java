package com.example.moxyissue.view;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;


@InjectViewState
public class CustomWidgetPresenter extends MvpPresenter<CustomView> {

    @Override
    protected void onFirstViewAttach() {
        getViewState().showText("CustomWidget");
    }

}
