package com.tropicgame.tinkoffnewstest.common.contract;

public interface InteractiveModelView <T> extends ModelView<T> {

    void setListener(InteractiveModelView.Listener var1);

    public interface Listener {
        void onModelAction(int var1, Object var2);
    }
}

