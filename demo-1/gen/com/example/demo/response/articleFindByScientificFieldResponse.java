
package com.example.demo.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.5
 * Thu Jan 10 00:44:18 CET 2019
 * Generated source version: 2.6.5
 */

@XmlRootElement(name = "articleFindByScientificFieldResponse", namespace = "http://webService.demo.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleFindByScientificFieldResponse", namespace = "http://webService.demo.example.com/")

public class articleFindByScientificFieldResponse {

    @XmlElement(name = "articles")
    private java.util.List<com.example.demo.model.Article> articles;

    public java.util.List<com.example.demo.model.Article> getArticles() {
        return this.articles;
    }

    public void setArticles(java.util.List<com.example.demo.model.Article> newArticles)  {
        this.articles = newArticles;
    }

}
