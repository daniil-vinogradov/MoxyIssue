package com.example.moxyissue.view;


import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface CustomView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showText(@NonNull String text);

}
