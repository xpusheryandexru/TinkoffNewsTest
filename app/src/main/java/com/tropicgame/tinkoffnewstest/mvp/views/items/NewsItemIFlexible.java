package com.tropicgame.tinkoffnewstest.mvp.views.items;

import com.tropicgame.tinkoffnewstest.R;
import com.tropicgame.tinkoffnewstest.modeles.NewsItem;
import com.tropicgame.tinkoffnewstest.common.view.BaseFlexibleItem;
import com.tropicgame.tinkoffnewstest.mvp.views.widget.NewsItemWidget;

public class NewsItemIFlexible extends BaseFlexibleItem<NewsItem, NewsItemWidget>{

    public NewsItemIFlexible(NewsItem newsItem){
        setModel(newsItem);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.widget_item_payload;
    }
}
