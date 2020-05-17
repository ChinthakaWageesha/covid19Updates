package au.em.corona.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import au.em.corona.BaseApplication;
import au.em.corona.R;
import au.em.corona.data.local.PreferenceHelper;
import au.em.corona.injection.component.ActivityComponent;
import au.em.corona.injection.component.ConfigPersistentComponent;
import au.em.corona.injection.component.DaggerConfigPersistentComponent;
import au.em.corona.injection.module.ActivityModule;
import java.util.concurrent.atomic.AtomicLong;

public class BaseFragment extends Fragment {

  private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
  private static final AtomicLong NEXT_ID = new AtomicLong(0);
  private static final LongSparseArray<ConfigPersistentComponent>
      sComponentsMap = new LongSparseArray<>();
  public Toolbar toolbar;
  private ActivityComponent mActivityComponent;
  private long mActivityId;
  private String accessToken;
  private Dialog mProgress;
  private Context mContext;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mContext = getActivity();

    mActivityId = savedInstanceState != null ?
        savedInstanceState.getLong(KEY_ACTIVITY_ID) : NEXT_ID.getAndIncrement();

    ConfigPersistentComponent configPersistentComponent = sComponentsMap.get(mActivityId, null);

    if (configPersistentComponent == null) {
      configPersistentComponent = DaggerConfigPersistentComponent.builder()
          .applicationComponent(BaseApplication.get(mContext).getComponent())
          .build();
      sComponentsMap.put(mActivityId, configPersistentComponent);
    }
    mActivityComponent =
        configPersistentComponent.activityComponent(new ActivityModule(getActivity()));

    accessToken = "Bearer " + PreferenceHelper.getAccessToken(mContext);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    toolbar = getActivity().findViewById(R.id.toolbar_live_updates);
    toolbar.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putLong(KEY_ACTIVITY_ID, mActivityId);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    if (toolbar != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      toolbar.setElevation(0);
    }
    sComponentsMap.remove(mActivityId);
  }

  public ActivityComponent activityComponent() {
    return mActivityComponent;
  }

  public void showToast(String message) {
    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
  }

  /*public void showError(String message) {
    ViewDialog.showDialog(mContext, getString(R.string.label_error), message,
        getString(R.string.label_ok));
  }*/

  /*public void showDialog(String title, String message, String dismissText) {
    ViewDialog.showDialog(mContext, title, message, dismissText);
  }*/

  public void showProgress() {
    try {
      if (mProgress == null) {
        mProgress = new Dialog(getContext(), R.style.ProgressbarStyle);
        mProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgress.setContentView(R.layout.content_page_loader);
        mProgress.setCancelable(false);
      }

      if (!mProgress.isShowing()) {
        mProgress.show();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void dismissProgress() {
    if (mProgress != null && mProgress.isShowing()) {
      mProgress.dismiss();
      mProgress = null;
    }
  }

  protected void setTitle(String title, int choose) {

    Typeface font = Typeface.SANS_SERIF;
    LayoutInflater inflator = LayoutInflater.from(getActivity());
    View v = inflator.inflate(R.layout.custom_text_view, null);

    //if you need to customize anything else about the text, do it here.
    //I'm using a custom TextView with a custom font in my layout xml so all I need to do is set title
    TextView textView = ((TextView) v.findViewById(R.id.title));
    textView.setTypeface(font);
    textView.setText(getActivity().getTitle());

    switch (choose) {
      case 1:
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
            .setHomeAsUpIndicator(R.drawable.ic_menu);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setCustomView(v);
        break;
      case 2:
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
            .setHomeAsUpIndicator(R.drawable.ic_back);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
            .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        break;
      case 3:
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
            .setHomeAsUpIndicator(R.drawable.ic_menu);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
            .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        break;
      case 4:
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
            .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        break;
    }
  }
}
