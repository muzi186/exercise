package com.gl.redis.voting.rao;

import com.gl.redis.JedisFactory;
import com.gl.redis.util.RedisUtil;
import com.gl.redis.voting.vo.Article;

import redis.clients.jedis.Jedis;

public class ArticleRao {
	private JedisFactory jf = JedisFactory.getInstance();

	public void insertOne(Article article) {
		Jedis j = jf.getJedis();
		String hashKey = RedisUtil.calculateKeyFromClass(Article.class, article.getId());
		j.hset(hashKey, "title", article.getTitle());
		j.hset(hashKey, "link", article.getLink());
		j.hset(hashKey, "poster",
				RedisUtil.calculateKeyFromClass(article.getAuthor().getClass(), article.getAuthor().getId()));
		j.hset(hashKey, "votes", "0");
		
		String amountKey = RedisUtil.calculateKeyFromClass(Article.class, "amount");
		j.incr(amountKey);
		
		System.out.println("Added - "+ hashKey);
		
		jf.closeJedis(j);

	}
	
	public int countArticles(){
		Jedis jedis = jf.getJedis();
		String key = RedisUtil.calculateKeyFromClass(Article.class, "amount");
		String amount = jedis.get(key);
		
		if(amount == null){
			//jedis.set(key, "0");
			return 0;
		}
		
		return Integer.valueOf(amount);
	}

}
