package com.gl.redis.voting.service;

import com.gl.redis.voting.rao.ArticleRao;
import com.gl.redis.voting.vo.Article;

public class ArticleService {
	ArticleRao articleRao = new ArticleRao();
	
	public void addArticle(Article a){
		articleRao.insertOne(a);
	}
	
	public int count(){
		return articleRao.countArticles();
	}
}
