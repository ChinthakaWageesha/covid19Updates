package au.elegantmedia.basemvpjava.ui.hospital_updates;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HospitalUpdatesActivity extends BaseActivity {

  @BindView(R.id.toolbar_hospital_updates) Toolbar mToolbar;
  @BindView(R.id.sub_toolbar_title) TextView subToolbarTitle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hospital_updates);
    ButterKnife.bind(this);
    init();
  }

  private void init() {
    setSupportActionBar(mToolbar);
    subToolbarTitle.setText(getString(R.string.title_hospital_updates));
    getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_back));
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
