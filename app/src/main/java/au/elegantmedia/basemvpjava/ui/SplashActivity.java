package au.elegantmedia.basemvpjava.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import au.elegantmedia.basemvpjava.ui.main.MainActivity;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    loadMain();
  }

  private void loadMain(){
    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
      }
    }, 2000);
  }
}
