package com.example.demo.converter;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Article;
import com.example.demo.model.ArticleEL;
import com.example.demo.pdf.PDFHandler;

@Component
public class ArticlesToArticleEL implements Converter<Article,ArticleEL>{

	@Autowired
	private UserToReviewerConverter userToReviewerConverter;
	
	@Autowired
	private PDFHandler pdfHandler;
	
	//private static String DATA_DIR_PATH;

	/*static {
		ResourceBundle rb = ResourceBundle.getBundle("application");
		DATA_DIR_PATH = rb.getString("dataDir");
	}*/

	@Override
	public ArticleEL convert(Article arg0) {
		// TODO Auto-generated method stub
		try {
			String fileName = saveUploadedFile(arg0.getFile(),arg0.getFilename());
			if(fileName != null) {
				ArticleEL article = pdfHandler.getIndexUnit(new File(fileName));
				article.setAbstracts(arg0.getAbstracts());
				article.setAuthors(userToReviewerConverter.convertList(arg0.getAuthors()));
				article.setKeywords(arg0.getKeywords());
				article.setMagazineName(arg0.getMagazineName());
				article.setReviewers(userToReviewerConverter.convertList(arg0.getReviewers()));
				article.setTitle(arg0.getTitle());
				article.setFilename(arg0.getFilename());
				return article;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	private File getResourceFilePath(String path) {
//		URL url = this.getClass().getClassLoader().getResource(path);
//		File file = null;
//		try {
//			file = new File(url.toURI());
//		} catch (URISyntaxException e)s {
//			file = new File(url.getPath());
//		}
//		return file;
//	}

	private String saveUploadedFile(String file, String filename) throws IOException {
		String retVal = null;
		DataOutputStream os;
		try {
			byte[] bytes = Base64.getDecoder().decode(file);
			Path path = Paths.get("D:\\Fakultet\\6 semestar\\Web\\WEB-work\\maven.1545762530237\\demo-1\\src\\main\\webapp\\files" + File.separator +filename);
	          
			os = new DataOutputStream(new FileOutputStream("D:\\Fakultet\\6 semestar\\Web\\WEB-work\\maven.1545762530237\\demo-1\\src\\main\\webapp\\files"+File.separator+filename));
			os.write(bytes);
			os.close();
			retVal = path.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

}
