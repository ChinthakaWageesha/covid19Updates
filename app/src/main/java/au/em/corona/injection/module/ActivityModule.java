package au.em.corona.injection.module;

import android.app.Activity;
import android.content.Context;
import au.em.corona.injection.ActivityContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@Module
public class ActivityModule {

  private Activity mActivity;

  public ActivityModule(Activity activity){mActivity = activity;}

  @Provides
  Activity provideActivity() {
    return mActivity;
  }

  @Provides
  @ActivityContext
  Context providesContext() {
    return mActivity;
  }
}
