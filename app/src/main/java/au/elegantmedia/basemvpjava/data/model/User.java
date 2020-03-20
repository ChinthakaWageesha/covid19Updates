package au.elegantmedia.basemvpjava.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
public class User {

  @SerializedName("access_token")
  @Expose
  private String accessToken;

  @SerializedName("id")
  @Expose
  private int userId;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
