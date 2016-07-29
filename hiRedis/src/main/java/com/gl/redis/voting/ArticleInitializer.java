package com.gl.redis.voting;

import java.util.Random;

import com.gl.redis.voting.service.ArticleService;
import com.gl.redis.voting.vo.Article;
import com.gl.redis.voting.vo.User;

public class ArticleInitializer {

	ArticleService service = new ArticleService();
	//UserService userService = new UserService();
	boolean amountInitialized = false;
	int maxAmount = 0;
	
	static final int MAX_SIZE = 50000;

	public static void main(String[] args) {
		System.err.println("ST add Article - amount " + MAX_SIZE );
		long st = System.currentTimeMillis();
		ArticleInitializer initializer = new ArticleInitializer();
		initializer.addTestArticles(MAX_SIZE);
		long ed = System.currentTimeMillis();
		System.err.println("ED add Article - amount " + MAX_SIZE + " eclapse : "+ ((ed -st)/1000.0));
	}
	
	public void addTestArticles(int maxSize){
		for(int i=0; i < maxSize; i++){
			Article a = genArticle();
			service.addArticle(a);
		}
	}
	
	private Article genArticle(){
		int id = genId();
		String title = genTitle(id);
		String link = "http://sina.com.cn";
//		int userAmount = userService.count();
		int userAmount = 10000;
		int userId = new Random().nextInt(userAmount);
		User u = new User(userId, null);
		
		Article a = new Article();
		a.setId(id);
		a.setAuthor(u);
		a.setLink(link);
		a.setTitle(title);
		
		return a;
	}
	
	private int genId(){
		initialMaxAmount();
		return ++maxAmount;
	}
	
	private String genTitle(int id){
		return "test-title-"+id;
	}

	private void initialMaxAmount() {
		if (!amountInitialized) {
			maxAmount = service.count();
			amountInitialized = true;
		}

	}

}
