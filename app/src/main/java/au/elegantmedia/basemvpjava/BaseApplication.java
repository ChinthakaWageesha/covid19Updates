package au.elegantmedia.basemvpjava;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import au.elegantmedia.basemvpjava.injection.component.ApplicationComponent;
import au.elegantmedia.basemvpjava.injection.component.DaggerApplicationComponent;
import au.elegantmedia.basemvpjava.injection.module.ApplicationModule;

/**
 * Created by Wageesha Chinthaka on 2019-06-20.
 */
public class BaseApplication extends Application {

  ApplicationComponent mApplicationComponent;

  public static BaseApplication get(Context context) {
    return (BaseApplication) context.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();
  }

  @Override protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }

  public ApplicationComponent getComponent() {
    if (mApplicationComponent == null) {
      mApplicationComponent = DaggerApplicationComponent.builder()
          .applicationModule(new ApplicationModule(this))
          .build();
    }
    return mApplicationComponent;
  }

  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}
