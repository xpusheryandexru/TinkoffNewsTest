package com.tropicgame.tinkoffnewstest.common.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.ButterKnife;

/**
 * Created by xpusher on 4/6/2018.
 */

public abstract class BaseItemWiget extends LinearLayout {
    public BaseItemWiget(Context context) {
        super(context);

    }

    public BaseItemWiget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public BaseItemWiget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public BaseItemWiget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

}
