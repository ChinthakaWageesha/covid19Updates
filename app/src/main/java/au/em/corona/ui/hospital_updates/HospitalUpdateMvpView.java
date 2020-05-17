package au.em.corona.ui.hospital_updates;

import au.em.corona.data.model.HospitalData;
import au.em.corona.ui.base.MvpView;
import java.util.List;

public interface HospitalUpdateMvpView extends MvpView {

  void startProgress();

  void getData(List<HospitalData> hospitalDataList);

  void onError(int errorCode);

  void endProgress();
}
