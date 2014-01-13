package roboshoes;

/**
 * Created by seadowg on 11/01/2014.
 */
public abstract class Button {
  public abstract void click();

  public final String text;

  public Button(String text) {
    this.text = text;

    App.add(this);
  }
}
