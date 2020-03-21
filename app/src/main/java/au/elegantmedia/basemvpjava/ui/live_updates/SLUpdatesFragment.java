package au.elegantmedia.basemvpjava.ui.live_updates;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.data.model.response.GetStatisticsResponse;
import au.elegantmedia.basemvpjava.ui.base.BaseFragment;
import au.elegantmedia.basemvpjava.ui.hospital_updates.HospitalUpdatesActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import javax.inject.Inject;

public class SLUpdatesFragment extends BaseFragment implements LiveUpdateMvpView {

  @Inject LiveUpdatesPresenter liveUpdatesPresenter;

  @BindView(R.id.tv_new_cases) TextView tvNewCases;
  @BindView(R.id.tv_total_cases) TextView tvTotalCases;
  @BindView(R.id.tv_new_deaths) TextView tvNewDeaths;
  @BindView(R.id.tv_total_deaths) TextView tvTotalDeaths;
  @BindView(R.id.tv_recovered) TextView tvRecovered;
  @BindView(R.id.tv_all_in_hospital) TextView tvAllInHospital;
  @BindView(R.id.cl_sl_base) ConstraintLayout clSlBase;
  @BindView(R.id.tv_update_time) TextView tvUpdateTime;
  Unbinder unbinder;

  public SLUpdatesFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_slupdates, container, false);
    activityComponent().inject(this);
    unbinder = ButterKnife.bind(this, view);
    liveUpdatesPresenter.attachView(this);
    return view;
  }

  @SuppressLint("SetTextI18n") private void setData(GetStatisticsResponse data) {
    clSlBase.setVisibility(View.VISIBLE);
    tvNewCases.setText(": " + data.getStatistics().getLocalNewCases());
    tvTotalCases.setText(": " + data.getStatistics().getLocalTotalCasesConfirmed());
    tvNewDeaths.setText(": " + data.getStatistics().getLocalNewDeaths());
    tvTotalDeaths.setText(": " + data.getStatistics().getLocalDeaths());
    tvRecovered.setText(": " + data.getStatistics().getLocalRecovered());
    tvAllInHospital.setText(": " + data.getStatistics().getLocalTotalCasesInHospitals());
    tvUpdateTime.setText(data.getStatistics().getUpdateTime());
  }

  @Override public void onResume() {
    super.onResume();
    liveUpdatesPresenter.getData();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  @Override public void startProgress() {
    showProgress();
  }

  @Override public void onSuccessGetData(GetStatisticsResponse getStatisticsResponse) {
    setData(getStatisticsResponse);
  }

  @Override public void onError(int errorCode) {
    showToast("Network error!. Let's try again later.");
  }

  @Override public void endProgress() {
    dismissProgress();
  }

  @OnClick(R.id.tv_goto_hospital_data) public void onViewClicked() {
    startActivity(new Intent(getContext(), HospitalUpdatesActivity.class));
  }
}
