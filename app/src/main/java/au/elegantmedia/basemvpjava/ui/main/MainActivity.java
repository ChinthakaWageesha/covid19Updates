package au.elegantmedia.basemvpjava.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.ui.base.BaseActivity;
import au.elegantmedia.basemvpjava.ui.hospital_updates.HospitalUpdatesActivity;
import au.elegantmedia.basemvpjava.ui.live_updates.LiveUpdatesActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

  @BindView(R.id.main_toolbar) Toolbar toolbar;
  @BindView(R.id.toolbar_title) TextView toolbarTitle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    init();
  }

  private void init() {
    setSupportActionBar(toolbar);
    toolbarTitle.setText(getString(R.string.title_home));
    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    getSupportActionBar().setHomeButtonEnabled(false);
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
    finishAffinity();
  }

  @OnClick({R.id.btn_hospital_updates, R.id.btn_live_updates})
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.btn_hospital_updates:
        startActivity(new Intent(this, HospitalUpdatesActivity.class));
        break;
      case R.id.btn_live_updates:
        startActivity(new Intent(this, LiveUpdatesActivity.class));
        break;
    }
  }
}
