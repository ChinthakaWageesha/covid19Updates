package au.em.corona.ui.hospital_updates;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import au.em.corona.BeFitConstants;
import au.em.corona.R;
import au.em.corona.data.model.Hospital;
import au.em.corona.data.model.HospitalData;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;

public class HospitalUpdatesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private Context mContext;
  private List<HospitalData> hospitalDataList;

  HospitalUpdatesAdapter(Context context, List<HospitalData> list){
    this.mContext = context;
    this.hospitalDataList = list;
  }

  @NonNull @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    View view =
        LayoutInflater.from(mContext).inflate(R.layout.item_hospital_update, viewGroup, false);
    return new ViewHolder(view);
  }

  @SuppressLint("SetTextI18n") @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
    final ViewHolder holder = (ViewHolder) viewHolder;
    final HospitalData hospitalData = hospitalDataList.get(position);
    final Hospital hospital= hospitalData.getHospital();

    holder.tvHospitalName.setText(hospital.getHospitalNameSinhala());
    holder.tvTotalCases.setText(String.valueOf(hospitalData.getTotalPatients()));

    holder.clHospitalBase.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent viewDetails = new Intent(mContext, ViewDetailsActivity.class);
        viewDetails.putExtra(BeFitConstants.HOSPITAL_NAME, hospital.getHospitalNameSinhala());
        viewDetails.putExtra(BeFitConstants.LOCAL_COUNT, hospitalData.getLocalPatients());
        viewDetails.putExtra(BeFitConstants.FOREIGN_COUNT, hospitalData.getForeignPatients());
        mContext.startActivity(viewDetails);
      }
    });
  }

  @Override public int getItemCount() {
    return hospitalDataList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_hospital_name) TextView tvHospitalName;
    @BindView(R.id.tv_total_cases) TextView tvTotalCases;
    @BindView(R.id.cl_hospital_base) ConstraintLayout clHospitalBase;

    ViewHolder(@NonNull View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
