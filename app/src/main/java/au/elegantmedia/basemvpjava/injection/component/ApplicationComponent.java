package au.elegantmedia.basemvpjava.injection.component;

import android.app.Application;
import android.content.Context;
import au.elegantmedia.basemvpjava.data.DataManager;
import au.elegantmedia.basemvpjava.data.local.PreferenceHelper;
import au.elegantmedia.basemvpjava.data.remote.ApiService;
import au.elegantmedia.basemvpjava.injection.ApplicationContext;
import au.elegantmedia.basemvpjava.injection.module.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  @ApplicationContext
  Context context();

  Application application();

  ApiService apiService();

  DataManager dataManager();

  PreferenceHelper preferenceHelper();
}
