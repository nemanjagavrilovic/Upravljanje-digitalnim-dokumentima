
package com.example.demo.request;

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

@XmlRootElement(name = "articleFindByKeywordsRequest", namespace = "http://webService.demo.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleFindByKeywordsRequest", namespace = "http://webService.demo.example.com/")

public class articleFindByKeywordsRequest {

    @XmlElement(name = "keywords")
    private java.util.List<java.lang.String> keywords;

    public java.util.List<java.lang.String> getKeywords() {
        return this.keywords;
    }

    public void setKeywords(java.util.List<java.lang.String> newKeywords)  {
        this.keywords = newKeywords;
    }

}

