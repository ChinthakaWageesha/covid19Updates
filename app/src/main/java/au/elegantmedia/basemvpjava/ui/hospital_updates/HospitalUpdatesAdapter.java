package au.elegantmedia.basemvpjava.ui.hospital_updates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import au.elegantmedia.basemvpjava.R;
import butterknife.ButterKnife;

public class HospitalUpdatesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private Context mContext;

  @NonNull @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    View view =
        LayoutInflater.from(mContext).inflate(R.layout.item_hospital_update, viewGroup, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

  }

  @Override public int getItemCount() {
    return 0;
  }

  private class ViewHolder extends RecyclerView.ViewHolder {

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
