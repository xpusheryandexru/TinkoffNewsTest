package com.tropicgame.tinkoffnewstest.common.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tropicgame.tinkoffnewstest.TinkoffNewsApp;
import com.tropicgame.tinkoffnewstest.dagger.components.PresentersComponent;
import com.tropicgame.tinkoffnewstest.dagger.modules.PresentersModule;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        init();
        attachPresenter(
                TinkoffNewsApp
                        .getInstance()
                        .getApplicationComponent()
                        .plus(new PresentersModule(this))
        );
    }

    protected abstract void init();
    protected abstract void attachPresenter(PresentersComponent presentersComponent);
}
