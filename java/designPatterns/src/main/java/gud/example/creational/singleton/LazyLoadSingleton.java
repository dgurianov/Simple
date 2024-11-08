package gud.example.creational.singleton;

/*

https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom

This code initializes the instance on the first calling of getInstance(), and importantly doesn't need synchronization because of the contract of the class loader:

   - the class loader loads classes when they are first accessed (in this case Holder's only access is within the getInstance() method)
   - when a class is loaded, and before anyone can use it, all static initializers are guaranteed to be executed (that's when Holder's static block fires)
   - the class loader has its own synchronization built right in that make the above two points guaranteed to be threadsafe

It's a neat little trick that I use whenever I need lazy initialization. You also get the bonus of a final instance, even though it's created lazily. Also note how clean and simple the code is.

Edit: You should set all constructors as private or protected. Setting and empty private constructor will do the work

 */


public class LazyLoadSingleton {

    private LazyLoadSingleton() {}

    private static class Holder{
        private static final LazyLoadSingleton INSTANCE = new LazyLoadSingleton();
    }

    public static LazyLoadSingleton getInstance(){
        return Holder.INSTANCE;
    }
}
