package com.tropicgame.tinkoffnewstest.modeles;

/**
 * Created by xpusher on 4/6/2018.
 */

public class NewsDetails {

    /**
     * title : {"id":"10024","name":"20122017-tinkoff-bank-x-mgu","text":"Тинькофф Банк начинает сотрудничество с кафедрой математических и компьютерных методов анализа мехмата МГУ","publicationDate":{"milliseconds":1513767691000},"bankInfoTypeId":2}
     * creationDate : {"milliseconds":1513758286000}
     * lastModificationDate : {"milliseconds":1513758286000}
     * content : <p>Москва, Россия&nbsp;&mdash; 20 декабря 2017&nbsp;г.<br />
     Тинькофф Банк продолжает расширять партнерство с&nbsp;ведущими университетами страны и&nbsp;сообщает о&nbsp;начале сотрудничества с&nbsp;кафедрой математических и&nbsp;компьютерных методов анализа <nobr>механико-математического</nobr> факультета Московского государственного университета имени <nobr>М. В. Ломоносова</nobr>.</p>

     <p>Заведует кафедрой декан факультета профессор <nobr>В. Н. Чубариков</nobr>.</p>

     <p>Вместе с&nbsp;преподавателями МГУ делиться знаниями и&nbsp;опытом со&nbsp;студентами кафедры будут <nobr>топ-менеджеры</nobr> и&nbsp;аналитики Тинькофф Банка, которые подготовили специальные курсы для учебной программы.</p>

     <p>В&nbsp;процессе обучения студенты повысят свою квалификацию в&nbsp;таких областях, как программирование, машинное обучение, <nobr>бизнес-аналитика</nobr>, принципы работы с&nbsp;большими данными. В&nbsp;учебную программу будут интегрированы реальные <nobr>бизнес-кейсы</nobr> Тинькофф Банка.</p>

     <p>Декан <nobr>механико-математического</nobr> факультета, профессор Владимир Николаевич Чубариков, отметил: &laquo;Наша корпоративная кафедра была создана более десяти лет назад, и&nbsp;ее&nbsp;основной задачей стало обучение наших студентов по&nbsp;расширенной программе с&nbsp;учетом пожеланий будущего работодателя в&nbsp;дополнение к&nbsp;классическому математическому образованию&raquo;.</p>

     <p>Константин Маркелов, <nobr>вице-президент</nobr> Тинькофф Банка по&nbsp;<nobr>бизнес-технологиям</nobr>, прокомментировал: &laquo;Скорость изменений сейчас огромная, и&nbsp;чем раньше студенты начинают применять свои знания на&nbsp;реальных <nobr>бизнес-кейсах</nobr>, тем лучше они подготовлены для работы на&nbsp;рынке. В&nbsp;группе &bdquo;Тинькофф&ldquo; работают многие выпускники мехмата, часть из&nbsp;них&nbsp;&mdash; на&nbsp;позициях <nobr>топ-менеджеров</nobr>. Мы&nbsp;не&nbsp;понаслышке знакомы с&nbsp;высоким уровнем подготовки этих специалистов, в&nbsp;связи с&nbsp;чем приняли решение начать сотрудничество. Мы&nbsp;со&nbsp;своей стороны приложим все усилия, чтобы повысить качество подготовки специалистов, которые будут востребованы как в&nbsp;компаниях группы &bdquo;Тинькофф&ldquo;, так и&nbsp;в&nbsp;других технологических компаниях мира&raquo;.</p>

     <p>Как правило, набор студентов проходит весной. В&nbsp;<nobr>2018</nobr> году прием на&nbsp;кафедру составит до&nbsp;20 человек.</p>

     <p>Обучение продлится 2&ndash;3 года и&nbsp;будет бесплатным.</p>
     * bankInfoTypeId : 2
     * typeId : usual
     */

    private TitleBean title;
    private CreationDateBean creationDate;
    private LastModificationDateBean lastModificationDate;
    private String content;
    private int bankInfoTypeId;
    private String typeId;

    public NewsDetails(){

    }

    public NewsDetails(String content){
        this.content = content;
    }

    public TitleBean getTitle() {
        return title;
    }

    public void setTitle(TitleBean title) {
        this.title = title;
    }

    public CreationDateBean getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(CreationDateBean creationDate) {
        this.creationDate = creationDate;
    }

    public LastModificationDateBean getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(LastModificationDateBean lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(int bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public static class TitleBean {
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

    public static class CreationDateBean {
        /**
         * milliseconds : 1513758286000
         */

        private long milliseconds;

        public long getMilliseconds() {
            return milliseconds;
        }

        public void setMilliseconds(long milliseconds) {
            this.milliseconds = milliseconds;
        }
    }

    public static class LastModificationDateBean {
        /**
         * milliseconds : 1513758286000
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
