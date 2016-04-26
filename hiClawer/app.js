/**
surf http://gavin2lee.iteye.com/admin/blogs and then retrieve the
list of blogs and then store them in {"title":"","publish-time":"","category":""}

http://gavin2lee.iteye.com/
*/

'use strict'

var superagent = require('superagent');
var observe = require('observe.js');
var cheerio = require('cheerio');

var path = require('path');
var url = require('url');
var fs = require('fs');

var dirName = "blogList";
var fileName = "bloglist.txt";

var blogListUrl = "http://gavin2lee.iteye.com/";
var blogListSelector = "div[class=blog_title] h3 a";
var blogContentSelector = "div[class=blog_content] div[class=iteye-blog-content-contain] *";

if(!fs.existsSync(dirName)){
  fs.mkdirSync(dirName);
}

var cwd = process.cwd();

var reptile = observe({});

reptile.on({
  url:function(url){
    console.log('this:'+this);
    console.log('URL:'+url);
    var that = this;
    superagent
      .get(url)
      .query(this.query)
      .end(function(err, response){
        if(err){
          console.log(err);
        }else{
          //console.log("text:" + response.text);
          that.text = response.text;
        }
      });
  },

  text:function(text){
    var that = this;
    var $ = cheerio.load(text);
    var blogList = [];

    $(blogListSelector).each(function(){
      blogList.push({
        title: $(this).text(),
        url: path.join(url.parse(that.url).hostname, $(this).attr('href'))
      });
    });

    this.blogList = blogList;
    this.blogItem = blogList.shift();
  },

  blogItem:function(blogItem){
    console.log(blogItem.url);
    var that = this;
    superagent.get(blogItem.url)
      .end(function(err, res){
        if(err){
          console.log(err);
        }else{
          that.content = {
            filename: path.join(cwd, dirName, blogItem.title+".txt"),
            title:blogItem.title,
            text:res.text
          }
        }
      });
  },

  content:function(content){
    var that = this;
    var $ = cheerio.load(content.text);
    var data = '';
    $(blogContentSelector).each(function(){
      data += $(this).text() + '\n';
    });

    fs.writeFile(content.filename, data, function(err){
      if(err){
        console.log(err);
      }else if(that.blogList.length){
        that.blogItem = that.blogList.shift();
      }
    });

  }
});

reptile.url = blogListUrl;
