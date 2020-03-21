package au.elegantmedia.basemvpjava.data.remote;

import au.elegantmedia.basemvpjava.data.model.response.GetStatisticsResponse;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
public interface ApiService {

  String ENDPOINT = "https://hpb.health.gov.lk/api/";

  @Headers({
      "Accept: application/json"
  })
  @GET("get-current-statistical")
  Observable<GetStatisticsResponse> getStats();

  class Creator {

    private static final long TIME_OUT_DURATION = 20;

    public static ApiService newApiService() {

      HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

      OkHttpClient.Builder builder = new OkHttpClient.Builder()
          .connectTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
          .writeTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
          .readTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS)
          .addInterceptor(httpLoggingInterceptor);

      OkHttpClient client = builder.build();

      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(ApiService.ENDPOINT)
          .client(client)
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build();

      return retrofit.create(ApiService.class);
    }
  }
}
