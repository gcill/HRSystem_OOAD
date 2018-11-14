
package hr.system;

public class UIbus {
    private static UIbus instance = null;
    public int id;
    public int passsword;
    private UIbus() {
      // Exists only to defeat instantiation.
    }
    public static UIbus getInstance() {
      if(instance == null) {
         instance = new UIbus();
      }
      return instance;
    }
}
