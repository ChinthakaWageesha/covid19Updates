package au.elegantmedia.basemvpjava.ui.live_updates;

import au.elegantmedia.basemvpjava.data.model.response.GetStatisticsResponse;
import au.elegantmedia.basemvpjava.ui.base.MvpView;

public interface LiveUpdateMvpView extends MvpView {

  void startProgress();

  void onSuccessGetData(GetStatisticsResponse getStatisticsResponse);

  void onError(int errorCode);

  void endProgress();
}
