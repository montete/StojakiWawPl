package pl.waw.stojaki.android.stojakiwawpl;

/**
 * Created by Mon on 2015-02-05.
 */
public class InfoClass {
    String author;
    String website;
    String date;

    public InfoClass() {
        this.date = "mockDate";
        this.author = "mockAuthor";
        this.website = "mockWbesite";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }



}
