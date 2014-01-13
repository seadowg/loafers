package roboshoes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.R;

public abstract class App extends Activity {
  private static App activity;

  public abstract void open();

  public static void add(final Button button) {
    android.widget.Button androidButton = new android.widget.Button(App.activity);
    androidButton.setText(button.text);
    androidButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        button.click();
      }
    });

    getLayout().addView(androidButton);
  }

  public static void add(Input input) {
    android.widget.EditText editText = new EditText(App.activity);
    getLayout().addView(editText);
  }

  public static void show(Popup popup) {
    AlertDialog.Builder builder = new AlertDialog.Builder(App.activity);
    builder.setTitle(popup.text);
    builder.create().show();
  }

  private static LinearLayout getLayout() {
    return (LinearLayout) App.activity.findViewById(R.id.layout);
  }

  protected String title = "Loafers";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.deckard);

    App.activity = this;
    open();
    setTitle(title);
  }
}
