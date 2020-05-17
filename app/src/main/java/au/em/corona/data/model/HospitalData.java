package au.em.corona.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HospitalData {

  @SerializedName("id")
  @Expose
  private int id;

  @SerializedName("hospital_id")
  @Expose
  private int hospitalId;

  @SerializedName("cumulative_local")
  @Expose
  private int cumulativeLocal;

  @SerializedName("cumulative_foreign")
  @Expose
  private int cumulativeForeign;

  @SerializedName("treatment_local")
  @Expose
  private int localPatients;

  @SerializedName("treatment_foreign")
  @Expose
  private int foreignPatients;

  @SerializedName("created_at")
  @Expose
  private String createdAt;

  @SerializedName("updated_at")
  @Expose
  private String updatedAt;

  @SerializedName("deleted_at")
  @Expose
  private String deletedAt;

  @SerializedName("cumulative_total")
  @Expose
  private int cumulativeTotal;

  @SerializedName("treatment_total")
  @Expose
  private int totalPatients;

  @SerializedName("hospital")
  @Expose
  private Hospital hospital;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getHospitalId() {
    return hospitalId;
  }

  public void setHospitalId(int hospitalId) {
    this.hospitalId = hospitalId;
  }

  public int getCumulativeLocal() {
    return cumulativeLocal;
  }

  public void setCumulativeLocal(int cumulativeLocal) {
    this.cumulativeLocal = cumulativeLocal;
  }

  public int getCumulativeForeign() {
    return cumulativeForeign;
  }

  public void setCumulativeForeign(int cumulativeForeign) {
    this.cumulativeForeign = cumulativeForeign;
  }

  public int getLocalPatients() {
    return localPatients;
  }

  public void setLocalPatients(int localPatients) {
    this.localPatients = localPatients;
  }

  public int getForeignPatients() {
    return foreignPatients;
  }

  public void setForeignPatients(int foreignPatients) {
    this.foreignPatients = foreignPatients;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(String deletedAt) {
    this.deletedAt = deletedAt;
  }

  public int getCumulativeTotal() {
    return cumulativeTotal;
  }

  public void setCumulativeTotal(int cumulativeTotal) {
    this.cumulativeTotal = cumulativeTotal;
  }

  public int getTotalPatients() {
    return totalPatients;
  }

  public void setTotalPatients(int totalPatients) {
    this.totalPatients = totalPatients;
  }

  public Hospital getHospital() {
    return hospital;
  }

  public void setHospital(Hospital hospital) {
    this.hospital = hospital;
  }
}
