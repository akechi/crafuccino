package io.github.akechi.crafuccino;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class CrafuccinoPlugin extends JavaPlugin implements Listener {
  Context cx;

    //
    // String s = "a.test()";
    // result = cx.evaluateString(scope, s, "<cmd>", 1, null);
    //
    // System.out.print(result);

  @Override
  public void onEnable() {
    this.cx = Context.enter();
    Scriptable scope = this.cx.initStandardObjects();

    try {
      java.io.Reader in = new java.io.FileReader(new java.io.File("js/a.js"));
      Object result = cx.evaluateReader(
          scope, in, "js/a.js", 1, null);
      System.out.println(result);
    } catch (java.io.FileNotFoundException e) {
      e.printStackTrace();
    } catch (java.io.IOException e) {
      e.printStackTrace();
    }


    PluginManager pm = Bukkit.getPluginManager();
    pm.registerEvents(this, this);
    System.out.println("ok!");
  }

  @EventHandler
  public void onPlayerLoginEvent(org.bukkit.event.player.PlayerLoginEvent evt) {
    System.out.println("(java) hi, " + evt.getPlayer().getName() + "!");
  }
}
