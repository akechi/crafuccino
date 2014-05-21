var a = {};
var Bukkit = org.bukkit.Bukkit;

a.PlayerLoginEvent = function(evt) {
	var player = evt.getPlayer()
	Bukkit.broadcastMessage('%s logged in!'.replace('%s', player.getName()));
};

a.test = function() {
	return 123123;
};
