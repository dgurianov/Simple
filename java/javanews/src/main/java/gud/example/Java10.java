package gud.example;

import java.net.MalformedURLException;
import java.net.URL;

public class Java10 {
    //Local variable Type Inference
    public static void main(String[] args) {
        try {
            //Before
            URL url = new URL("http://void.net");
            var urlNew = new URL("http://void.net");

        }catch (MalformedURLException e){
            e.printStackTrace();
        }


    }
}