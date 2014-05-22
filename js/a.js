var a = {};
var Bukkit = org.bukkit.Bukkit;

a.PlayerLoginEvent = function(evt) {
	var player = evt.getPlayer()
	Bukkit.broadcastMessage('%s logged in!'.replace('%s', player.getName()));
	log.info('log info from js!');
	log.warning('log warning from js!');
};

a.test = function() {
	return 123123;
};
