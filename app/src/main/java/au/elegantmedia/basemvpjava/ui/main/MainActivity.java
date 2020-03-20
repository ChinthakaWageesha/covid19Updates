package au.elegantmedia.basemvpjava.ui.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }

  private void setFragment(final Fragment fragment, final Bundle bundle) {

    new Handler().postDelayed(new Runnable() {
      @Override public void run() {
        if (bundle != null) {
          fragment.setArguments(bundle);
        }

        MainActivity.this.getSupportFragmentManager().beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit();
      }
    }, 450);
  }
  @Override public void onBackPressed() {
    super.onBackPressed();
    finishAffinity();
  }
}
