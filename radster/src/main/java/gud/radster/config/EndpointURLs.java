package gud.radster.config;

public class EndpointURLs {

    //Root
    public static final String TEMPLATE = "/data/get";

    //Endpoints
    public static final String ADDRESS = TEMPLATE + "/address";

    public static String getUrls(){
        return String.join("\n",
                ADDRESS
        );
    }

}
