var a = {};

a.PlayerLoginEvent = function(evt) {
	print('%s logged in!'.replace('%s', evt.getName()));
};

a.test = function() {
	return 123123;
};