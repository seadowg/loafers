package roboshoes;

public class Popup {
  public final String text;

  public Popup(String text) {
    this.text = text;
  }

  public void show() {
    App.show(this);
  }
}
