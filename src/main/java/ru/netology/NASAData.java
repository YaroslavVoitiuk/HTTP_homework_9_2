package ru.netology;

public class NASAData {

    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public NASAData() {
    }

    public String getCopyright() {
        return copyright;
    }

    public String getService_version() {
        return service_version;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NASAData {" +
                " \n copyright = " + copyright +
                ",\n date = " + date +
                ",\n explanation = " + explanation +
                ",\n hdurl = " + hdurl +
                ",\n media_type = " + media_type +
                ",\n service_version = " + service_version +
                ",\n title = " + title +
                ",\n url = " + url +
                "\n}";
    }
}
