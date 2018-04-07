package com.tropicgame.tinkoffnewstest.network.response;

import com.tropicgame.tinkoffnewstest.common.modeles.BasePayLoad;
import com.tropicgame.tinkoffnewstest.modeles.NewsItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewsItemsResponse  extends BasePayLoad{
    List<NewsItem> payload;

    public List<NewsItem> getNewsItem() {
        return payload;
    }

    public void setNewsItem(List<NewsItem> newsItem) {
        this.payload= newsItem;
    }

    public void sortNewsByPublicationDateDes(){
        Collections.sort(payload,new ComparePayload());
    }
    class ComparePayload implements Comparator<NewsItem>{

        @Override
        public int compare(NewsItem left, NewsItem right) {
            Long l=right.getPublicationDate().getMilliseconds();
            Long r=left.getPublicationDate().getMilliseconds();
            return l.compareTo(r);
        }
    }
}
