package au.elegantmedia.basemvpjava.ui.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

  @BindView(R.id.main_toolbar) Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    init();
  }

  private void init(){
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Home");
    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    getSupportActionBar().setHomeButtonEnabled(false);
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
    finishAffinity();
  }
}
