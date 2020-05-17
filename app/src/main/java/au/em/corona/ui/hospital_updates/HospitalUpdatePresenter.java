package au.em.corona.ui.hospital_updates;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import au.em.corona.data.DataManager;
import au.em.corona.data.model.HospitalData;
import au.em.corona.data.model.response.GetStatisticsResponse;
import au.em.corona.ui.base.BasePresenter;
import au.em.corona.util.RxUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class HospitalUpdatePresenter extends BasePresenter<HospitalUpdateMvpView> {

  private final DataManager mDtDataManager;
  private Disposable mDisposable;
  private Context mContext;

  @Inject HospitalUpdatePresenter(DataManager dataManager) {
    this.mDtDataManager = dataManager;
  }

  @Override public void attachView(HospitalUpdateMvpView mvpView) {
    super.attachView(mvpView);
    mContext = getContext();
  }

  void getStatistics() {
    checkViewAttached();
    RxUtil.dispose(mDisposable);
    mDtDataManager.getStatistics()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Observer<GetStatisticsResponse>() {
          @Override public void onSubscribe(Disposable d) {
            mDisposable = d;
            getMvpView().startProgress();
          }

          @Override public void onNext(GetStatisticsResponse getStatisticsResponse) {
            getMvpView().getData(getStatisticsResponse.getStatistics().getHospitalData());
          }

          @Override public void onError(Throwable e) {
            getMvpView().onError(7999);
          }

          @Override public void onComplete() {
            getMvpView().endProgress();
          }
        });
  }

  void setUpAdapter(RecyclerView recyclerView, List<HospitalData> hospitalDataList) {
    HospitalUpdatesAdapter updatesAdapter = new HospitalUpdatesAdapter(mContext, hospitalDataList);
    LinearLayoutManager manager =
        new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(manager);
    recyclerView.setAdapter(updatesAdapter);
  }

  @Override public void detachView() {
    super.detachView();
    if (mDisposable != null) {
      mDisposable.dispose();
    }
  }
}
