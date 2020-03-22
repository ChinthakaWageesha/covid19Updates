package au.elegantmedia.basemvpjava.ui.hospital_updates;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.data.model.HospitalData;
import au.elegantmedia.basemvpjava.ui.base.BaseActivity;
import au.elegantmedia.basemvpjava.util.NetworkUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;

public class HospitalUpdatesActivity extends BaseActivity implements HospitalUpdateMvpView {

  @Inject HospitalUpdatePresenter hospitalUpdatePresenter;

  @BindView(R.id.toolbar_hospital_updates) Toolbar mToolbar;
  @BindView(R.id.sub_toolbar_title) TextView subToolbarTitle;
  @BindView(R.id.rv_hospital_updates) RecyclerView rvHospitalUpdates;
  @BindView(R.id.tv_no_internet) TextView tvNoInternet;

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

    if (NetworkUtil.isNetworkConnected(this)) {
      rvHospitalUpdates.setVisibility(View.VISIBLE);
      tvNoInternet.setVisibility(View.GONE);
      hospitalUpdatePresenter.getStatistics();
    } else {
      rvHospitalUpdates.setVisibility(View.GONE);
      tvNoInternet.setVisibility(View.VISIBLE);
    }
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
    rvHospitalUpdates.setVisibility(View.GONE);
    tvNoInternet.setVisibility(View.VISIBLE);
    tvNoInternet.setText(getString(R.string.label_network_error));
  }

  @Override public void endProgress() {
    dismissProgress();
  }
}
