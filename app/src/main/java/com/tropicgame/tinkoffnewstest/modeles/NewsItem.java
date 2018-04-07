package com.tropicgame.tinkoffnewstest.modeles;

import java.util.Comparator;

public class NewsItem {

    /**
     * id : 10024
     * name : 20122017-tinkoff-bank-x-mgu
     * text : Тинькофф Банк начинает сотрудничество с кафедрой математических и компьютерных методов анализа мехмата МГУ
     * publicationDate : {"milliseconds":1513767691000}
     * bankInfoTypeId : 2
     */

    private String id;
    private String name;
    private String text;
    private PublicationDateBean publicationDate;
    private int bankInfoTypeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public PublicationDateBean getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(PublicationDateBean publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(int bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public static class PublicationDateBean {
        /**
         * milliseconds : 1513767691000
         */

        private long milliseconds;

        public long getMilliseconds() {
            return milliseconds;
        }

        public void setMilliseconds(long milliseconds) {
            this.milliseconds = milliseconds;
        }
    }
}
