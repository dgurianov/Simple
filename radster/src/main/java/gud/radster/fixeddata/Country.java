package gud.radster.fixeddata;

public enum Country{
        DE("Germany","DE"),
        US("United States", "US"),
        DK("Denmark", "DK"),
        GB("Great Britain", "GB"),
        FR("France", "FR")
    ;

    private String name;
    private String iso2code;


    Country(String name, String iso2code) {
        this.name = name;
        this.iso2code = iso2code;
    }

    public String getName() {
        return name;
    }

    public String getIso2code() {
        return iso2code;
    }
}
