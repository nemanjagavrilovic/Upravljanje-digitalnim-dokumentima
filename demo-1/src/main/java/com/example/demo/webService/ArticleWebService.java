package com.example.demo.webService;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.example.demo.lucene.QueryModel;
import com.example.demo.lucene.SearchType;
import com.example.demo.model.Article;
import com.example.demo.model.ArticleEL;
import com.example.demo.model.User;

@WebService(targetNamespace = "http://webService.demo.example.com/", name = "ArticleWebService")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ArticleWebService {

	@WebResult(name="article")
	@RequestWrapper(localName="articleSaveRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleSaveRequest")
	@WebMethod(operationName="save",action="http://webService.demo.example.com/save")
	@ResponseWrapper(localName="articleSaveResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleSaveResponse")
	public ArticleEL save(@WebParam (name="article") Article article);
	
	@WebResult(name="articles")
	@RequestWrapper(localName="articleFindAllRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleFindAllRequest")
	@WebMethod(operationName="findAll",action="http://webService.demo.example.com/findAll")
	@ResponseWrapper(localName="articleFindAllResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleFindAllResponse")
	public List<ArticleEL> findAll();
	
	@WebResult(name="articles")
	@RequestWrapper(localName="articleMoreLikeThisRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleMoreLikeThisRequest")
	@WebMethod(operationName="moreLikeThis",action="http://webService.demo.example.com/moreLikeThis")
	@ResponseWrapper(localName="articleMoreLikeThisResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleMoreLikeThisResponse")
	public List<User> moreLikeThis(@WebParam (name="text") String text);
	
	@WebResult(name="articles")
	@RequestWrapper(localName="articleFindByMagazineRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleFindByMagazineRequest")
	@WebMethod(operationName="findByMagazineName",action="http://webService.demo.example.com/findByMagazineName")
	@ResponseWrapper(localName="articleFindByMagazineResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleFindByMagazineResponse")
	public List<ArticleEL> findByMagazineName(@WebParam (name="magazineName") String magazineName,
											  @WebParam (name="searchType") SearchType searchType);
	
	@WebResult(name="articles")
	@RequestWrapper(localName="articleFindByTitleRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleFindByTitleRequest")
	@WebMethod(operationName="findByTitle",action="http://webService.demo.example.com/findByTitle")
	@ResponseWrapper(localName="articleFindByTitleResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleFindByTitleResponse")
	public List<ArticleEL> findByTitle(@WebParam (name="title") String title,@WebParam (name="searchType") SearchType searchType);
	
	@WebResult(name="articles")
	@RequestWrapper(localName="articleFindByKeywordsRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleFindByKeywordsRequest")
	@WebMethod(operationName="findByKeywords",action="http://webService.demo.example.com/findByKeywords")
	@ResponseWrapper(localName="articleKeywordsResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleKeywordsResponse")
	public List<ArticleEL> findByKeywords(@WebParam (name="keywords") List<String> keywords);
	
	@WebResult(name="articles")
	@RequestWrapper(localName="articleFindByScientificFieldRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleFindByScientificFieldRequest")
	@WebMethod(operationName="findByScientificField",action="http://webService.demo.example.com/findByScientificField")
	@ResponseWrapper(localName="articleFindByScientificFieldResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleFindByScientificFieldResponse")
	public List<ArticleEL> findByScientificField(@WebParam (name="scientificField") String scientificField,
												 @WebParam (name="searchType") SearchType searchType);
	
	@WebResult(name="articles")
	@RequestWrapper(localName="articleBooleanQueryRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleBooleanQueryRequest")
	@WebMethod(operationName="booleanQuery",action="http://webService.demo.example.com/booleanQuery")
	@ResponseWrapper(localName="articleBooleanQuerydResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleBooleanQueryResponse")
	public List<ArticleEL> booleanQuery(@WebParam (name="queries") List<QueryModel> queryFields,
										@WebParam (name="operation") String operation,
										@WebParam (name="searchType") SearchType searchType);
	
	@WebResult(name="articles")
	@RequestWrapper(localName="articleFindByAbstractFieldRequest",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.request.articleFindByAbstractFieldRequest")
	@WebMethod(operationName="findByAbstract",action="http://webService.demo.example.com/findByAbstract")
	@ResponseWrapper(localName="articleFindByAbstractResponse",
	targetNamespace="http://webService.demo.example.com/",
	className="com.example.demo.response.articleFindByAbstractResponse")
	public List<ArticleEL> findByAbstract(@WebParam (name="abstract") String abstracts,
												 @WebParam (name="searchType") SearchType searchType);
	
}
