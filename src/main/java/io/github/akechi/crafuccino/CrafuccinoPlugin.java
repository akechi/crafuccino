package io.github.akechi.crafuccino.CrafuccinoPlugin;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class CrafuccinoPlugin {
  Context cx;

  public static void main(String[] args) {
    new CrafuccinoPlugin().f();
  }

  // just for now
  public void f() {
    this.cx = Context.enter();
    Scriptable scope = this.cx.initStandardObjects();
    String s = "(function(x, y) { return x + 2 * y; })(10, 20)";
    Object result = cx.evaluateString(scope, s, "<cmd>", 1, null);
    System.out.print(result);
  }
}
