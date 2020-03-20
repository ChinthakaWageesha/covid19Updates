package au.elegantmedia.basemvpjava.injection.module;

import android.app.Application;
import android.content.Context;
import au.elegantmedia.basemvpjava.data.remote.ApiService;
import au.elegantmedia.basemvpjava.injection.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@Module
public class ApplicationModule {

  private final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  Application provideApplication() {
    return mApplication;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }

  @Provides
  @Singleton
  ApiService provideService() {
    return ApiService.Creator.newApiService();
  }
}
