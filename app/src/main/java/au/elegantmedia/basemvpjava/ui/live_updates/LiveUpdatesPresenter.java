package au.elegantmedia.basemvpjava.ui.live_updates;

import android.content.Context;
import au.elegantmedia.basemvpjava.data.DataManager;
import au.elegantmedia.basemvpjava.data.model.response.GetStatisticsResponse;
import au.elegantmedia.basemvpjava.ui.base.BasePresenter;
import au.elegantmedia.basemvpjava.util.RxUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class LiveUpdatesPresenter extends BasePresenter<LiveUpdateMvpView> {

  private final DataManager mDataManager;
  private Disposable mDisposable;
  private Context mContext;

  @Inject LiveUpdatesPresenter(DataManager dataManager) {
    this.mDataManager = dataManager;
  }

  @Override public void attachView(LiveUpdateMvpView mapView) {
    super.attachView(mapView);
    mContext = getContext();
  }

  void getData() {
    checkViewAttached();
    RxUtil.dispose(mDisposable);
    mDataManager.getStatistics()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Observer<GetStatisticsResponse>() {
          @Override public void onSubscribe(Disposable d) {
            mDisposable = d;
            getMvpView().startProgress();
          }

          @Override public void onNext(GetStatisticsResponse getStatisticsResponse) {
            getMvpView().endProgress();
            getMvpView().onSuccessGetData(getStatisticsResponse);
          }

          @Override public void onError(Throwable e) {
            getMvpView().endProgress();
          }

          @Override public void onComplete() {
            getMvpView().endProgress();
          }
        });
  }

  @Override public void detachView() {
    super.detachView();
    if (mDisposable != null) {
      mDisposable.dispose();
    }
  }
}
