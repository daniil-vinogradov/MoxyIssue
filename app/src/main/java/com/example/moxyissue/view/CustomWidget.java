package com.example.moxyissue.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.presenter.InjectPresenter;


public class CustomWidget extends FrameLayout implements CustomView {

    private MvpDelegate mParentDelegate;
    private MvpDelegate<CustomWidget> mMvpDelegate;

    private TextView mTextView;

    @InjectPresenter
    CustomWidgetPresenter mPresenter;

    public CustomWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, this, true);

        mTextView = findViewById(android.R.id.text1);
    }

    public void init(MvpDelegate parentDelegate) {
        mParentDelegate = parentDelegate;

        getMvpDelegate().onCreate();
        getMvpDelegate().onAttach();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        mTextView = null;

        getMvpDelegate().onSaveInstanceState();
        getMvpDelegate().onDetach();
    }

    public MvpDelegate<CustomWidget> getMvpDelegate() {
        if (mMvpDelegate != null) {
            return mMvpDelegate;
        }

        mMvpDelegate = new MvpDelegate<>(this);
        mMvpDelegate.setParentDelegate(mParentDelegate, String.valueOf(getId()));
        return mMvpDelegate;
    }

    @Override
    public void showText(@NonNull String text) {
        Log.d("Moxy", "CustomWidget::showText, hashCode = " + hashCode());
        mTextView.setText(text);
    }
}
