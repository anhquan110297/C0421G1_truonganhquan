package email.models.bean;

public class Email {
    private String languages;
    private int page;
    private boolean filter;
    private String signature;

    public Email() {
    }

    public Email(String languages, int page, boolean filter, String signature) {
        this.languages = languages;
        this.page = page;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
