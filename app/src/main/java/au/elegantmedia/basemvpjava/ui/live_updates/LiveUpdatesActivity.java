package au.elegantmedia.basemvpjava.ui.live_updates;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LiveUpdatesActivity extends BaseActivity {

  @BindView(R.id.toolbar_live_updates) Toolbar mToolbar;
  @BindView(R.id.sub_toolbar_title) TextView subToolbarTitle;
  @BindView(R.id.fl_updates_container) FrameLayout flUpdatesContainer;
  @BindView(R.id.tv_sri_lanka_updates) TextView tvSriLankaUpdates;
  @BindView(R.id.tv_world_updates) TextView tvWorldUpdates;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_live_updates);
    ButterKnife.bind(this);
    init();
  }

  private void init() {
    setSupportActionBar(mToolbar);
    subToolbarTitle.setText(getString(R.string.title_live_updates));
    getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_back));
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    onSelectSriLankaTab();
  }

  private void onSelectSriLankaTab() {
    tvSriLankaUpdates.setTextColor(getResources().getColor(R.color.colorWhite));
    tvSriLankaUpdates.setBackground(
        getResources().getDrawable(R.drawable.bg_green_left_corner_rounded));
    tvWorldUpdates.setTextColor(getResources().getColor(R.color.colorPuertoRico));
    tvWorldUpdates.setBackground(
        getResources().getDrawable(R.drawable.bg_white_green_stroke_right_corner_round));
    setFragment(new SLUpdatesFragment());
  }

  private void onSelectWorldTab() {
    tvSriLankaUpdates.setTextColor(getResources().getColor(R.color.colorPuertoRico));
    tvSriLankaUpdates.setBackground(
        getResources().getDrawable(R.drawable.bg_white_green_stroke_left_corner_round));
    tvWorldUpdates.setTextColor(getResources().getColor(R.color.colorWhite));
    tvWorldUpdates.setBackground(
        getResources().getDrawable(R.drawable.bg_green_right_corner_round));
    setFragment(new WWUpdatesFragment());
  }

  private void setFragment(Fragment fragment) {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.fl_updates_container, fragment)
        .commit();
  }

  @OnClick({R.id.tv_sri_lanka_updates, R.id.tv_world_updates})
  public void onViewClicked(View view) {
    switch (view.getId()) {
      case R.id.tv_sri_lanka_updates:
        onSelectSriLankaTab();
        break;
      case R.id.tv_world_updates:
        onSelectWorldTab();
        break;
    }
  }

  @Override public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
