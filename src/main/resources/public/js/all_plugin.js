[
	'/js/js_lib/vue.js',
	'/js/js_lib/vue-router.js',
	'/js/js_lib/axios.min.js',
	'/js/js_lib/jquery-3.2.1.js',
	'/js/js_lib/bootstrap.js',
	'/js/js_lib/bootstrap.min.js'
	
].map((jsFileSrc)=>{
	document.write('<script src="'+jsFileSrc+'" type="text/javascript"></script>');
});

[
	'/css/bootstrap.css',
	'/css/bootstrap.min.css',
	'/css/bootstrap-theme.min.css',
	'/css/bootstrap-theme.css'
	
].map((cssFileSrc)=>{
	document.write('<link rel="stylesheet" type="text/css" href="'+cssFileSrc+'">');
});
