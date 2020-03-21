package au.elegantmedia.basemvpjava.data;

import au.elegantmedia.basemvpjava.data.model.response.GetStatisticsResponse;
import au.elegantmedia.basemvpjava.data.remote.ApiService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
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

  public Observable<GetStatisticsResponse> getStatistics(){
    return mApiService.getStats()
        .map(new Function<GetStatisticsResponse, GetStatisticsResponse>() {
          @Override public GetStatisticsResponse apply(GetStatisticsResponse getStatisticsResponse)
              throws Exception {
            return getStatisticsResponse;
          }
        });
  }
}
