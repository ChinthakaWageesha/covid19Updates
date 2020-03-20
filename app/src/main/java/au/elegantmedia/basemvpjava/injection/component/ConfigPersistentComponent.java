package au.elegantmedia.basemvpjava.injection.component;

import au.elegantmedia.basemvpjava.injection.ConfigPersistent;
import au.elegantmedia.basemvpjava.injection.module.ActivityModule;
import dagger.Component;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {
  ActivityComponent activityComponent(ActivityModule activityModule);
}
