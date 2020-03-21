package au.elegantmedia.basemvpjava.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CurrentStatistics {

  @SerializedName("update_date_time")
  @Expose
  private String updateTime;

  @SerializedName("local_new_cases")
  @Expose
  private int localNewCases;

  @SerializedName("local_total_cases")
  @Expose
  private int localTotalCasesConfirmed;

  @SerializedName("local_total_number_of_individuals_in_hospitals")
  @Expose
  private int localTotalCasesInHospitals;

  @SerializedName("local_deaths")
  @Expose
  private int localDeaths;

  @SerializedName("local_new_deaths")
  @Expose
  private int localNewDeaths;

  @SerializedName("local_recovered")
  @Expose
  private int localRecovered;

  @SerializedName("global_new_cases")
  @Expose
  private int globalNewCases;

  @SerializedName("global_total_cases")
  @Expose
  private int globalTotalCases;

  @SerializedName("global_deaths")
  @Expose
  private int globalDeaths;

  @SerializedName("global_new_deaths")
  @Expose
  private int globalNewDeaths;

  @SerializedName("global_recovered")
  @Expose
  private int globalRecovered;

  @SerializedName("hospital_data")
  @Expose
  private List<HospitalData> hospitalData;




}
