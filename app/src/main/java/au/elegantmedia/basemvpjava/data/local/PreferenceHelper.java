package au.elegantmedia.basemvpjava.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import au.elegantmedia.basemvpjava.BeFitConstants;
import au.elegantmedia.basemvpjava.data.model.User;
import au.elegantmedia.basemvpjava.injection.ApplicationContext;
import com.google.gson.Gson;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Wageesha Chinthaka on 2019-06-19.
 */
@Singleton
public class PreferenceHelper {

  private static final String PREF_FILE_NAME = "beFit_file";

  private final SharedPreferences mPref;

  @Inject
  public PreferenceHelper(@ApplicationContext Context context) {
    mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
  }

  public static void saveToPreferences(Context context, User user, boolean userLoggedInState) {
    final SharedPreferences preferences = context.getSharedPreferences(
        BeFitConstants.PREFERENCES, Context.MODE_PRIVATE);
    final SharedPreferences.Editor editor = preferences.edit();

    try {
      editor.putString(
          BeFitConstants.PREF_KEY_ACCESS_TOKEN, user.getAccessToken()
      );
      editor.putInt(BeFitConstants.PREF_KEY_USER_ID, user.getUserId()
      );

      editor.putBoolean(
          BeFitConstants.PREF_KEY_USER_LOGGED_IN_STATE, userLoggedInState
      );

      editor.apply();
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  public static void saveUser(Context context, User user) {
    final SharedPreferences preferences = context.getSharedPreferences(
        BeFitConstants.PREFERENCES, Context.MODE_PRIVATE);
    final SharedPreferences.Editor editor = preferences.edit();

    Gson gson = new Gson();
    String userJson = gson.toJson(user);
    editor.putString(BeFitConstants.PREF_KEY_USER, userJson);
    editor.apply();
  }

  public static boolean getUserLoggedInState(Context context) {
    final SharedPreferences prefs = getPreferences(context);

    return prefs.getBoolean(BeFitConstants.PREF_KEY_USER_LOGGED_IN_STATE, false);
  }

  public static String getAccessToken(Context context) {
    final SharedPreferences prefs = getPreferences(context);

    return  prefs.getString(BeFitConstants.PREF_KEY_ACCESS_TOKEN, "");
  }

  private static SharedPreferences getPreferences(Context context) {
    return context.getSharedPreferences(BeFitConstants.PREFERENCES, Context.MODE_PRIVATE);
  }

  public static void removePreferences(Context context) {
    SharedPreferences preferences =
        context.getSharedPreferences(BeFitConstants.PREFERENCES, Context.MODE_PRIVATE);

    preferences.edit().remove(BeFitConstants.PREF_KEY_ACCESS_TOKEN).apply();
    preferences.edit().remove(BeFitConstants.PREF_KEY_USER_ID).apply();
    preferences.edit().putBoolean(BeFitConstants.PREF_KEY_USER_LOGGED_IN_STATE, false).apply();
  }

  public static void removeUser(Context context) {
    SharedPreferences preferences =
        context.getSharedPreferences(BeFitConstants.PREFERENCES, Context.MODE_PRIVATE);

    preferences.edit().remove(BeFitConstants.PREF_KEY_USER).apply();
  }

  public static User getUserObject(Context context) {
    final SharedPreferences prefs = getPreferences(context);
    String jsonString = prefs.getString(BeFitConstants.PREF_KEY_USER, "");

    Gson gson = new Gson();

    User userObj = gson.fromJson(jsonString, User.class);

    return userObj;
  }
}
