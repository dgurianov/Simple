package gud.example.others.businessdelegate;

/*
Business Delegate Pattern is used to decouple presentation tier and business tier. It is basically use to reduce communication or remote lookup functionality to business tier code in presentation tier code.
In business tier we have following entities.
    Client - Presentation tier code may be JSP, servlet or UI java code.
    Business Delegate - A single entry point class for client entities to provide access to Business Service methods.
    LookUp Service - Lookup service object is responsible to get relative business implementation and provide business object access to business delegate object.
    Business Service - Business Service interface. Concrete classes implement this business service to provide actual business implementation logic.
 */
public class BusinessDelegateSample {
    public static void main(String[] args) {
        //Use BusinessDelegate and Client classes to demonstrate Business Delegate pattern.
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }
}

interface BusinessService {
    public void doProcessing();
}
//Concrete service classes
class EJBService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
class JMSService implements BusinessService {

    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}
//Business lookup service
class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType){

        if(serviceType.equalsIgnoreCase("EJB")){
            return new EJBService();
        }
        else {
            return new JMSService();
        }
    }
}

//Business delegate
class BusinessDelegate {
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public void doTask(){
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
//Client
class Client {

    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService){
        this.businessService  = businessService;
    }

    public void doTask(){
        businessService.doTask();
    }
}
