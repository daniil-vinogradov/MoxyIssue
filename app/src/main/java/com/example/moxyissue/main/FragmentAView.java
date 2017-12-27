package com.example.moxyissue.main;


import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface FragmentAView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showCustomView(@NonNull String text);
}
