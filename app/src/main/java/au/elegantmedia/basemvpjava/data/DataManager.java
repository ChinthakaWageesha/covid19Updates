package au.elegantmedia.basemvpjava.data;

import au.elegantmedia.basemvpjava.data.remote.ApiService;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@Singleton
public class DataManager {

  private ApiService mApiService;

  @Inject
  public DataManager(ApiService apiService){this.mApiService = apiService;}
}
