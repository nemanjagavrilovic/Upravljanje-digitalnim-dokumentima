
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.example.demo.webService;
import javax.jws.WebService;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2019-01-10T00:44:26.539+01:00
 * Generated source version: 2.6.5
 * 
 */
@WebService(endpointInterface = "com.example.demo.webService.ArticleWebService", serviceName = "ArticleWebService")                      
public class ArticleWebServiceImpl implements ArticleWebService {

    public java.util.List<com.example.demo.model.Article> findByAbstract(java.lang.String arg0,com.example.demo.lucene.SearchType arg1) {  
        System.out.println(arg0);        System.out.println(arg1);    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.Article> findAll() {  
    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.Article> findByKeywords(java.util.List<java.lang.String> arg0) {  
        System.out.println(arg0);    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.Article> findByMagazineName(java.lang.String arg0,com.example.demo.lucene.SearchType arg1) {  
        System.out.println(arg0);        System.out.println(arg1);    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.Article> findByTitle(java.lang.String arg0,com.example.demo.lucene.SearchType arg1) {  
        System.out.println(arg0);        System.out.println(arg1);    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.Article> findByNameAndSurname(java.lang.String arg0,java.lang.String arg1,com.example.demo.lucene.SearchType arg2) {  
        System.out.println(arg0);        System.out.println(arg1);        System.out.println(arg2);    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.Article> findByText(java.lang.String arg0,com.example.demo.lucene.SearchType arg1) {  
        System.out.println(arg0);        System.out.println(arg1);    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public com.example.demo.model.Article save(com.example.demo.model.Article arg0) {  
        System.out.println(arg0);    
        try {
            com.example.demo.model.Article _return = new com.example.demo.model.Article();
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.Article> booleanQuery(java.util.List<com.example.demo.lucene.QueryModel> arg0,java.lang.String arg1,com.example.demo.lucene.SearchType arg2) {  
        System.out.println(arg0);        System.out.println(arg1);        System.out.println(arg2);    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.User> findByDistance(com.example.demo.model.Article arg0) {  
        System.out.println(arg0);    
        try {
            java.util.List<com.example.demo.model.User> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.Article> findByScientificField(java.lang.String arg0,com.example.demo.lucene.SearchType arg1) {  
        System.out.println(arg0);        System.out.println(arg1);    
        try {
            java.util.List<com.example.demo.model.Article> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }


    public java.util.List<com.example.demo.model.User> moreLikeThis(java.lang.String arg0) {  
        System.out.println(arg0);    
        try {
            java.util.List<com.example.demo.model.User> _return = null;
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
 
    }

}