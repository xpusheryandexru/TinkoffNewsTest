package com.tropicgame.tinkoffnewstest.mvp.views.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.tropicgame.tinkoffnewstest.R;
import com.tropicgame.tinkoffnewstest.common.view.BaseItemWiget;
import com.tropicgame.tinkoffnewstest.modeles.NewsItem;
import com.tropicgame.tinkoffnewstest.common.contract.InteractiveModelView;

import butterknife.BindView;

public class NewsItemWidget extends BaseItemWiget implements InteractiveModelView<NewsItem> {

    @BindView(R.id.widget_item_news_text) TextView payload_text;

    private Listener listener;
    private NewsItem model;

    public NewsItemWidget(Context context) {
        super(context);
    }

    public NewsItemWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NewsItemWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NewsItemWidget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void setModel(NewsItem newsItem) {
        model= newsItem;
        payload_text.setText(newsItem.getText());
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onModelAction(0,model);
            }
        });
    }

    @Override
    public NewsItem getModel() {
        return null;
    }
}
