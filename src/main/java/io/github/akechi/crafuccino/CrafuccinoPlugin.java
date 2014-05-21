package io.github.akechi.crafuccino.CrafuccinoPlugin;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class CrafuccinoPlugin {
  Context cx;

  public static void main(String[] args) {
    try {
      new CrafuccinoPlugin().f();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // just for now
  public void f() throws java.io.FileNotFoundException, java.io.IOException {
    this.cx = Context.enter();
    Scriptable scope = this.cx.initStandardObjects();

    java.io.Reader in = new java.io.FileReader(new java.io.File("js/a.js"));
    Object result = cx.evaluateReader(
        scope, in, "js/a.js", 1, null);
    System.out.print(result);

    String s = "a.test()";
    result = cx.evaluateString(scope, s, "<cmd>", 1, null);

    System.out.print(result);
  }
}
