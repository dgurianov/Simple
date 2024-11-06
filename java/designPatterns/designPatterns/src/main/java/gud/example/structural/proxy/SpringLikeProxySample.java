package gud.example.structural.proxy;


public class SpringLikeProxySample {
}

class TrueObject{
    private String someField;
    public void someAction(){
        System.out.println("I do some action");
    }
}

class ProxyOfTrueObject {
    private TrueObject object;

    public ProxyOfTrueObject(TrueObject object) {
        this.object = object;
    }

    public void someAction(){
        //Lazy loading
        if(this.object == null){
            this.object = new TrueObject();
        }
        //Preparation actions
        doBeforeSomeImportantStuff();
        //Call of read object
        object.someAction();
        //Post true object execution calls
        doAfterSomeImportantStuff();

    }

    private void doBeforeSomeImportantStuff(){
        System.out.println("Before true object is being involved, some important stuff is being done");
    }
    private void doAfterSomeImportantStuff(){
        System.out.println("After true object is being involved, some important stuff is being done");
    }


}



