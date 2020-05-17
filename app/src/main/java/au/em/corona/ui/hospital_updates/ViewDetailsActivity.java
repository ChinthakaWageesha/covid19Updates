package au.em.corona.ui.hospital_updates;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import au.em.corona.BeFitConstants;
import au.em.corona.R;
import au.em.corona.ui.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewDetailsActivity extends BaseActivity {

  @BindView(R.id.toolbar_view_details) Toolbar mToolbar;
  @BindView(R.id.sub_toolbar_title) TextView subToolbarTitle;
  @BindView(R.id.tv_hospital_name) TextView tvHospitalName;
  @BindView(R.id.tv_local_patient_count) TextView tvLocalPatientCount;
  @BindView(R.id.tv_foreign_patient_count) TextView tvForeignPatientCount;
  @BindView(R.id.tv_total_patient_count) TextView tvTotalPatientCount;

  private String hospitalName;
  private int localPatients;
  private int foreignPatients;
  private int totalPatients;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_details);
    ButterKnife.bind(this);
    init();
    setData();
  }

  private void init() {
    setSupportActionBar(mToolbar);
    subToolbarTitle.setText(getString(R.string.title_hospital_details));
    getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_back));
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
  }

  @SuppressLint("SetTextI18n") private void setData() {
    int defaultValue = -9;
    if (getIntent() != null) {
      hospitalName = getIntent().getStringExtra(BeFitConstants.HOSPITAL_NAME);
      localPatients = getIntent().getIntExtra(BeFitConstants.LOCAL_COUNT, defaultValue);
      foreignPatients = getIntent().getIntExtra(BeFitConstants.FOREIGN_COUNT, defaultValue);
      totalPatients = localPatients + foreignPatients;
    }

    if (!hospitalName.isEmpty()) {
      tvHospitalName.setText(": " + hospitalName);
    }
    if (localPatients != defaultValue) {
      tvLocalPatientCount.setText(": " + localPatients);
    }

    if (foreignPatients != defaultValue) {
      tvForeignPatientCount.setText(": " + foreignPatients);
    }

    if (localPatients != defaultValue && foreignPatients != defaultValue){
      tvTotalPatientCount.setText(": " + totalPatients);
    }
  }

  @Override public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}
