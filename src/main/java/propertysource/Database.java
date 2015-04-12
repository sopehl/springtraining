package propertysource;

/**
 * Created by semih on 12.04.2015.
 */
public class Database {

    String url;

    public Database(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
