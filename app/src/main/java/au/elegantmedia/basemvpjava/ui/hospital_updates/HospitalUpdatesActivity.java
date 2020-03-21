package au.elegantmedia.basemvpjava.ui.hospital_updates;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.data.model.HospitalData;
import au.elegantmedia.basemvpjava.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;

public class HospitalUpdatesActivity extends BaseActivity implements HospitalUpdateMvpView{

  @Inject HospitalUpdatePresenter hospitalUpdatePresenter;

  @BindView(R.id.toolbar_hospital_updates) Toolbar mToolbar;
  @BindView(R.id.sub_toolbar_title) TextView subToolbarTitle;
  @BindView(R.id.rv_hospital_updates) RecyclerView rvHospitalUpdates;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hospital_updates);
    activityComponent().inject(this);
    hospitalUpdatePresenter.attachView(this);
    ButterKnife.bind(this);
    init();
  }

  private void init() {
    setSupportActionBar(mToolbar);
    subToolbarTitle.setText(getString(R.string.title_hospital_updates));
    getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_back));
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    hospitalUpdatePresenter.getStatistics();
  }

  @Override public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

  @Override public void startProgress() {
    showProgress();
  }

  @Override public void getData(List<HospitalData> hospitalDataList) {
    dismissProgress();
    hospitalUpdatePresenter.setUpAdapter(rvHospitalUpdates, hospitalDataList);

  }

  @Override public void onError(int errorCode) {
    dismissProgress();
    showToast("Network error!. Let's try again later.");

  }

  @Override public void endProgress() {
    dismissProgress();
  }
}
