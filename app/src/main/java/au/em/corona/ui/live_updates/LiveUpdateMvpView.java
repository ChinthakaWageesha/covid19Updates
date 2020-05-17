package au.em.corona.ui.live_updates;

import au.em.corona.data.model.response.GetStatisticsResponse;
import au.em.corona.ui.base.MvpView;

public interface LiveUpdateMvpView extends MvpView {

  void startProgress();

  void onSuccessGetData(GetStatisticsResponse getStatisticsResponse);

  void onError(int errorCode);

  void endProgress();
}
