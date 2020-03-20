package au.elegantmedia.basemvpjava.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import au.elegantmedia.basemvpjava.BaseApplication;
import au.elegantmedia.basemvpjava.data.local.PreferenceHelper;
import au.elegantmedia.basemvpjava.injection.component.ActivityComponent;
import au.elegantmedia.basemvpjava.injection.component.ConfigPersistentComponent;
import au.elegantmedia.basemvpjava.injection.component.DaggerConfigPersistentComponent;
import au.elegantmedia.basemvpjava.injection.module.ActivityModule;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Wageesha Chinthaka on 2019-06-20.
 */
public class BaseActivity extends AppCompatActivity {

  private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
  private static final AtomicLong NEXT_ID = new AtomicLong(0);
  private static final LongSparseArray<ConfigPersistentComponent>
      sComponentsMap = new LongSparseArray<>();
  public String accessToken;
  private ActivityComponent mActivityComponent;
  private long mActivityId;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mActivityId = savedInstanceState != null ?
        savedInstanceState.getLong(KEY_ACTIVITY_ID) : NEXT_ID.getAndIncrement();

    ConfigPersistentComponent configPersistentComponent = sComponentsMap.get(mActivityId, null);

    if (configPersistentComponent == null) {
      configPersistentComponent = DaggerConfigPersistentComponent.builder()
          .applicationComponent(BaseApplication.get(this).getComponent())
          .build();
      sComponentsMap.put(mActivityId, configPersistentComponent);
    }
    mActivityComponent = configPersistentComponent.activityComponent(new ActivityModule(this));
    accessToken = "Bearer " + PreferenceHelper.getAccessToken(this);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putLong(KEY_ACTIVITY_ID, mActivityId);
  }

  @Override
  protected void onDestroy() {
    if (!isChangingConfigurations()) {
      sComponentsMap.remove(mActivityId);
    }
    super.onDestroy();
  }

  public ActivityComponent activityComponent() {
    return mActivityComponent;
  }

  public void showToast(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  /*public void showError(String message) {
    ViewDialog.showDialog(this, getString(R.string.label_error), message,
        getString(R.string.label_ok));
  }

  public void showDialog(String title, String message, String dismissText) {
    ViewDialog.showDialog(this, title, message, dismissText);
  }*/
}
