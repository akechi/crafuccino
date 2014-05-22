package io.github.akechi.crafuccino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Function;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class CrafuccinoPlugin extends JavaPlugin implements Listener {
  Context cx;
  Scriptable scope;
  java.util.logging.Logger log;

    //
    // String s = "a.test()";
    // result = cx.evaluateString(scope, s, "<cmd>", 1, null);
    //
    // System.out.print(result);

  @Override
  public void onEnable() {
    this.cx = Context.enter();
    this.scope = this.cx.initStandardObjects();
    this.log = this.getLogger();

    try {
      java.io.Reader in = new java.io.FileReader(new java.io.File("js/a.js"));
      Object result = cx.evaluateReader(
          this.scope, in, "js/a.js", 1, null);
      System.out.println(result);
    } catch (java.io.FileNotFoundException e) {
      e.printStackTrace();
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }


    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(this, this);
    System.out.println("ok!");
    this.scope.put("log", this.scope, this.log);

    Scriptable a = (Scriptable)this.scope.get("a", this.scope);
    Function f = (Function)a.get("test", a);
    Object[] args = {};
    System.out.println(f.call(this.cx, a, a, args));
  }

  @EventHandler
  public void onPlayerLoginEvent(org.bukkit.event.player.PlayerLoginEvent evt) {
    System.out.println("(java) hi, " + evt.getPlayer().getName() + "!");

    Scriptable a = (Scriptable)this.scope.get("a", this.scope);
    Object[] args = {evt};
    Function f = (Function)a.get("PlayerLoginEvent", a);
    System.out.println(f.call(this.cx, a, a, args));
  }
}
