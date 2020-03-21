package au.elegantmedia.basemvpjava.ui.hospital_updates;

import au.elegantmedia.basemvpjava.data.model.HospitalData;
import au.elegantmedia.basemvpjava.ui.base.MvpView;
import java.util.List;

public interface HospitalUpdateMvpView extends MvpView {

  void startProgress();

  void getData(List<HospitalData> hospitalDataList);

  void onError(int errorCode);

  void endProgress();
}
