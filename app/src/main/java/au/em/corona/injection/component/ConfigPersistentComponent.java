package au.em.corona.injection.component;

import au.em.corona.injection.ConfigPersistent;
import au.em.corona.injection.module.ActivityModule;
import dagger.Component;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {
  ActivityComponent activityComponent(ActivityModule activityModule);
}
