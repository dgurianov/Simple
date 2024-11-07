package gud.example;


import com.sun.net.httpserver.SimpleFileServer;

import java.net.InetSocketAddress;
import java.nio.file.Path;

public class Java18 {
    //UTF-8 by default
    //Java 18 makes UTF-8 the default character set for the `String` class, file I/O, and other APIs, ensuring consistent behavior across different platforms.

    //Simple web server
    public static void main(String[] args) {
        var server = SimpleFileServer.createFileServer(new InetSocketAddress(8000), Path.of("/var/serverroot"), SimpleFileServer.OutputLevel.INFO);
    }

}
