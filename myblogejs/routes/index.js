var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'MyBlog',username: 'Gavin Li' });
});

//Added by Gavin
router.get('/u/:user',function(req,res,next){
	res.send('U');
});

router.post('/post',function(req.res.next){
	res.send('post');
});

router.get('/reg', function(req, res,next){
	res.send('reg');
});

router.post('/reg', function(req, res, next){
	res.send('reg post');
});


router.get('/login',function(req,res,next){
    res.send("Login Page");
});

router.post('/login', function(req, res, next){
	res.send('login');
});

router.get('/logout', function(req, res, next){
	res.send('logout');
});


module.exports = router;
