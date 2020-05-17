package au.em.corona.injection.component;

import android.app.Application;
import android.content.Context;
import au.em.corona.data.DataManager;
import au.em.corona.data.local.PreferenceHelper;
import au.em.corona.data.remote.ApiService;
import au.em.corona.injection.ApplicationContext;
import au.em.corona.injection.module.ApplicationModule;
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
