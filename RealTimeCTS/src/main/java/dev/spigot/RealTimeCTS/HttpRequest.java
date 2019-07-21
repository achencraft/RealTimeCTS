package dev.spigot.RealTimeCTS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.URL;
import dev.spigot.RealTimeCTS.App;





public class HttpRequest {

  

    public  String readUrl(String urlString, final String Token) throws Exception {
       
        
        

        Authenticator.setDefault (new Authenticator() {
            

            protected PasswordAuthentication getPasswordAuthentication() {
                
                return new PasswordAuthentication (Token, "".toCharArray());
            }
        });


        
        URL url = new URL(urlString);
        String output = "";

        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String str;
        while ((str = in.readLine()) != null) {
        //System.out.println(str);
        output = output + str;
        }
        in.close();


        return output;

        
    }


    

        
}

