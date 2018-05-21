package example.vincent.weather_app.interfaces;

import android.content.Context;

import example.vincent.weather_app.adapters.RVForecastAdapter;
import example.vincent.weather_app.data.network.res.GetDailyForecastRes;
import example.vincent.weather_app.interfaces.base.BaseInterfacePresenter;
import example.vincent.weather_app.interfaces.base.BaseInterfaceView;

public interface MainActivityInterface {
    interface View extends BaseInterfaceView {
        void setArticlesToUI(RVForecastAdapter adapter);
        void showMessage(int messageResId);
    }

    interface Presenter extends BaseInterfacePresenter<View> {
        void getDailyForecastRequest(String city);
        void restoreRV(Context context);
    }
}
