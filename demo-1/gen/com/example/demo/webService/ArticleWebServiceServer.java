
package com.example.demo.webService;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2019-01-10T00:44:26.580+01:00
 * Generated source version: 2.6.5
 * 
 */
 
public class ArticleWebServiceServer{

    protected ArticleWebServiceServer() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new com.example.demo.webService.ArticleWebServiceImpl();
        String address = "http://localhost:9090/ArticlePort";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws Exception { 
        new ArticleWebServiceServer();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
 
 