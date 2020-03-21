package au.elegantmedia.basemvpjava.data.model.response;

import au.elegantmedia.basemvpjava.data.model.CurrentStatistics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getStatisticsResponse {

  @SerializedName("success")
  @Expose
  private boolean status;

  @SerializedName("message")
  @Expose
  private String message;

  @SerializedName("data")
  @Expose
  private CurrentStatistics statistics;

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public CurrentStatistics getStatistics() {
    return statistics;
  }

  public void setStatistics(CurrentStatistics statistics) {
    this.statistics = statistics;
  }
}
