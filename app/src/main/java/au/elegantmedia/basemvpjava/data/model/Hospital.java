package au.elegantmedia.basemvpjava.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hospital {

  @SerializedName("id")
  @Expose
  private int id;

  @SerializedName("name")
  @Expose
  private String hospitalName;

  @SerializedName("name_si")
  @Expose
  private String hospitalNameSinhala;

  @SerializedName("name_ta")
  @Expose
  private String hospitalNameTamil;

  @SerializedName("created_at")
  @Expose
  private String createdAt;

  @SerializedName("updated_at")
  @Expose
  private String updatedAt;

  @SerializedName("deleted_at")
  @Expose
  private String deletedAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getHospitalNameSinhala() {
    return hospitalNameSinhala;
  }

  public void setHospitalNameSinhala(String hospitalNameSinhala) {
    this.hospitalNameSinhala = hospitalNameSinhala;
  }

  public String getHospitalNameTamil() {
    return hospitalNameTamil;
  }

  public void setHospitalNameTamil(String hospitalNameTamil) {
    this.hospitalNameTamil = hospitalNameTamil;
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
}
