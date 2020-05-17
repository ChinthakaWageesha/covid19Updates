package au.em.corona.injection.component;

import au.em.corona.injection.PerActivity;
import au.em.corona.injection.module.ActivityModule;
import au.em.corona.ui.SplashActivity;
import au.em.corona.ui.hospital_updates.HospitalUpdatesActivity;
import au.em.corona.ui.live_updates.SLUpdatesFragment;
import au.em.corona.ui.live_updates.WWUpdatesFragment;
import dagger.Subcomponent;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(SplashActivity splashActivity);

  void inject(HospitalUpdatesActivity hospitalUpdatesActivity);

  void inject(SLUpdatesFragment slUpdatesFragment);

  void inject(WWUpdatesFragment wwUpdatesFragment);
}
