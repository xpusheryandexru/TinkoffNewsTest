package com.tropicgame.tinkoffnewstest.common.view;

import android.view.View;

import com.tropicgame.tinkoffnewstest.common.contract.InteractiveModelView;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

public class ModelViewHolder<V extends View> extends FlexibleViewHolder {
    public final V view;
    private InteractiveModelView.Listener listener;

    public ModelViewHolder(View view, FlexibleAdapter adapter) {
        super(view, adapter);
        this.view = (V) view;
    }

    public void setListener(InteractiveModelView.Listener listener) {
        this.listener = listener;
        if (listener != null && this.view instanceof InteractiveModelView) {
            ((InteractiveModelView)this.view).setListener(listener);
        }

    }
}
