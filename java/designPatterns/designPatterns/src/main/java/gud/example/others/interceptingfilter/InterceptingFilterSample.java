package gud.example.others.interceptingfilter;


/*
The intercepting filter design pattern is used when we want to do some pre-processing / post-processing with request or response of the application. Filters are defined and applied on the request before passing the request to actual target application. Filters can do the authentication/ authorization/ logging or tracking of request and then pass the requests to corresponding handlers. Following are the entities of this type of design pattern.
    Filter - Filter which will performs certain task prior or after execution of request by request handler.
    Filter Chain - Filter Chain carries multiple filters and help to execute them in defined order on target.
    Target - Target object is the request handler
    Filter Manager - Filter Manager manages the filters and Filter Chain.
    Client - Client is the object who sends request to the Target object.
 */

import java.util.ArrayList;
import java.util.List;

public class InterceptingFilterSample {
    public static void main(String[] args) {

        FilterManager filterManager = new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
        //Use the Client to demonstrate Intercepting Filter Design Pattern.
        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("HOME");
    }
}

//Filter Interface
interface Filter {
    public void execute(String request);
}
//Filters
class AuthenticationFilter implements Filter {
    public void execute(String request){  System.out.println("Authenticating request: " + request);  }
}
class DebugFilter implements Filter {
    public void execute(String request){
        System.out.println("request log: " + request);
    }
}
//Target

class Target {
    public void execute(String request){
        System.out.println("Executing request: " + request);
    }
}

//Filter chain
class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private Target target;

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target){
        this.target = target;
    }
}

//Filter manager
class FilterManager {
    FilterChain filterChain;

    public FilterManager(Target target){
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request){
        filterChain.execute(request);
    }
}

//Client
class Client {
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendRequest(String request){
        filterManager.filterRequest(request);
    }
}
