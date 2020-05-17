package au.em.corona.ui.live_updates;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import au.em.corona.R;
import au.em.corona.data.model.response.GetStatisticsResponse;
import au.em.corona.ui.base.BaseFragment;
import au.em.corona.util.NetworkUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import javax.inject.Inject;

public class WWUpdatesFragment extends BaseFragment implements LiveUpdateMvpView {

  @Inject LiveUpdatesPresenter liveUpdatesPresenter;

  @BindView(R.id.tv_new_cases) TextView tvNewCases;
  @BindView(R.id.tv_total_cases) TextView tvTotalCases;
  @BindView(R.id.tv_new_deaths) TextView tvNewDeaths;
  @BindView(R.id.tv_total_deaths) TextView tvTotalDeaths;
  @BindView(R.id.tv_recovered) TextView tvRecovered;
  @BindView(R.id.tv_update_time) TextView tvUpdateTime;
  @BindView(R.id.cl_ww_base) ConstraintLayout clWwBase;
  @BindView(R.id.tv_no_internet) TextView tvNoInternet;
  @BindView(R.id.tv_active_cases) TextView tvActiveCases;
  Unbinder unbinder;

  private Context mContext;
  private int totalActiveCases;

  public WWUpdatesFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_wwupdates, container, false);
    activityComponent().inject(this);
    unbinder = ButterKnife.bind(this, view);
    liveUpdatesPresenter.attachView(this);
    mContext = getContext();
    return view;
  }

  @SuppressLint("SetTextI18n") private void setData(GetStatisticsResponse data) {
    totalActiveCases =
        data.getStatistics().getGlobalTotalCases() - (data.getStatistics().getGlobalRecovered()
            + data.getStatistics().getGlobalDeaths());

    clWwBase.setVisibility(View.VISIBLE);
    tvNewCases.setText(": " + data.getStatistics().getGlobalNewCases());
    tvTotalCases.setText(": " + data.getStatistics().getGlobalTotalCases());
    tvNewDeaths.setText(": " + data.getStatistics().getGlobalNewDeaths());
    tvTotalDeaths.setText(": " + data.getStatistics().getGlobalDeaths());
    tvRecovered.setText(": " + data.getStatistics().getGlobalRecovered());
    tvUpdateTime.setText(data.getStatistics().getUpdateTime());
    tvActiveCases.setText(": " + totalActiveCases);
  }

  @Override public void onResume() {
    super.onResume();
    if (NetworkUtil.isNetworkConnected(mContext)) {
      tvNoInternet.setVisibility(View.GONE);
      liveUpdatesPresenter.getData();
    } else {
      clWwBase.setVisibility(View.GONE);
      tvNoInternet.setVisibility(View.VISIBLE);
    }
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
    clWwBase.setVisibility(View.GONE);
    tvNoInternet.setVisibility(View.VISIBLE);
    tvNoInternet.setText(getString(R.string.label_network_error));
  }

  @Override public void endProgress() {
    dismissProgress();
  }
}
