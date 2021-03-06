
package com.example.demo.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.5
 * Thu Jan 10 00:44:19 CET 2019
 * Generated source version: 2.6.5
 */

@XmlRootElement(name = "articleFindByTextRequest", namespace = "http://webService.demo.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleFindByTextRequest", namespace = "http://webService.demo.example.com/", propOrder = {"text", "searchType"})

public class articleFindByTextRequest {

    @XmlElement(name = "text")
    private java.lang.String text;
    @XmlElement(name = "searchType")
    private com.example.demo.lucene.SearchType searchType;

    public java.lang.String getText() {
        return this.text;
    }

    public void setText(java.lang.String newText)  {
        this.text = newText;
    }

    public com.example.demo.lucene.SearchType getSearchType() {
        return this.searchType;
    }

    public void setSearchType(com.example.demo.lucene.SearchType newSearchType)  {
        this.searchType = newSearchType;
    }

}

