package au.em.corona.data.model;

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

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public int getLocalNewCases() {
    return localNewCases;
  }

  public void setLocalNewCases(int localNewCases) {
    this.localNewCases = localNewCases;
  }

  public int getLocalTotalCasesConfirmed() {
    return localTotalCasesConfirmed;
  }

  public void setLocalTotalCasesConfirmed(int localTotalCasesConfirmed) {
    this.localTotalCasesConfirmed = localTotalCasesConfirmed;
  }

  public int getLocalTotalCasesInHospitals() {
    return localTotalCasesInHospitals;
  }

  public void setLocalTotalCasesInHospitals(int localTotalCasesInHospitals) {
    this.localTotalCasesInHospitals = localTotalCasesInHospitals;
  }

  public int getLocalDeaths() {
    return localDeaths;
  }

  public void setLocalDeaths(int localDeaths) {
    this.localDeaths = localDeaths;
  }

  public int getLocalNewDeaths() {
    return localNewDeaths;
  }

  public void setLocalNewDeaths(int localNewDeaths) {
    this.localNewDeaths = localNewDeaths;
  }

  public int getLocalRecovered() {
    return localRecovered;
  }

  public void setLocalRecovered(int localRecovered) {
    this.localRecovered = localRecovered;
  }

  public int getGlobalNewCases() {
    return globalNewCases;
  }

  public void setGlobalNewCases(int globalNewCases) {
    this.globalNewCases = globalNewCases;
  }

  public int getGlobalTotalCases() {
    return globalTotalCases;
  }

  public void setGlobalTotalCases(int globalTotalCases) {
    this.globalTotalCases = globalTotalCases;
  }

  public int getGlobalDeaths() {
    return globalDeaths;
  }

  public void setGlobalDeaths(int globalDeaths) {
    this.globalDeaths = globalDeaths;
  }

  public int getGlobalNewDeaths() {
    return globalNewDeaths;
  }

  public void setGlobalNewDeaths(int globalNewDeaths) {
    this.globalNewDeaths = globalNewDeaths;
  }

  public int getGlobalRecovered() {
    return globalRecovered;
  }

  public void setGlobalRecovered(int globalRecovered) {
    this.globalRecovered = globalRecovered;
  }

  public List<HospitalData> getHospitalData() {
    return hospitalData;
  }

  public void setHospitalData(
      List<HospitalData> hospitalData) {
    this.hospitalData = hospitalData;
  }
}
