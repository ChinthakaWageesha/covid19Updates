package au.elegantmedia.basemvpjava.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.Window;
import au.elegantmedia.basemvpjava.R;
import au.elegantmedia.basemvpjava.data.local.PreferenceHelper;
import au.elegantmedia.basemvpjava.data.model.User;

/**
 * Created by Wageesha Chinthaka on 2019-06-20.
 */
public class BasePresenter<T extends MvpView> implements Presenter<T>{

  private T mMvpView;
  public User user;
  private Dialog progress;

  @Override public void attachView(T mapView) {
    mMvpView = mapView;
  }

  @Override public void detachView() {
    mMvpView = null;
  }

  public boolean isViewAttached() {
    return mMvpView != null;
  }

  public T getMvpView() {
    return mMvpView;
  }

  public void checkViewAttached() {
    if (!isViewAttached()) throw new MvpViewNotAttachedException();
  }

  public static class MvpViewNotAttachedException extends RuntimeException {
    public MvpViewNotAttachedException() {
      super("Please call Presenter.attachView(MvpView) before" +
          " requesting data to the Presenter");
    }
  }

  public Context getContext(){
    checkViewAttached();
    if(getMvpView() instanceof Fragment){
      return ((Fragment)getMvpView()).getContext();
    } else {
      return (Context) getMvpView();
    }
  }

  public User getUser() {
    this.user = PreferenceHelper.getUserObject(getContext().getApplicationContext());
    return user;
  }

  /*public void showWaiting(Context context) {

    if (progress == null) {
      progress = new Dialog(context, R.style.ProgressbarStyle);
      progress.requestWindowFeature(Window.FEATURE_NO_TITLE);
      progress.setContentView(R.layout.content_page_loader);
      progress.setCancelable(false);
    }

    if (!progress.isShowing()) {
      progress.show();
    }
  }

  public void dismissWaiting() {

    if (progress != null && progress.isShowing()) {
      progress.dismiss();
      progress = null;
    }
  }*/
}
