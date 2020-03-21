package au.elegantmedia.basemvpjava.injection.component;

import au.elegantmedia.basemvpjava.injection.PerActivity;
import au.elegantmedia.basemvpjava.injection.module.ActivityModule;
import au.elegantmedia.basemvpjava.ui.SplashActivity;
import au.elegantmedia.basemvpjava.ui.hospital_updates.HospitalUpdatesActivity;
import dagger.Subcomponent;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(SplashActivity splashActivity);

  void inject(HospitalUpdatesActivity hospitalUpdatesActivity);
}
