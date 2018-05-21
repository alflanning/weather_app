package example.vincent.weather_app.presenters;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import example.vincent.weather_app.R;
import example.vincent.weather_app.adapters.RVForecastAdapter;
import example.vincent.weather_app.data.manager.DataManager;
import example.vincent.weather_app.data.network.res.GetDailyForecastRes;
import example.vincent.weather_app.interfaces.MainActivityInterface;
import example.vincent.weather_app.interfaces.base.BasePresenter;
import example.vincent.weather_app.utils.AppConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter extends BasePresenter<MainActivityInterface.View> implements MainActivityInterface.Presenter {

    private List<GetDailyForecastRes.List> list = new ArrayList<>();
    private RVForecastAdapter adapter;

    @Override
    public void getDailyForecastRequest(String city) {
        DataManager mDataManager = DataManager.getInstance();

        Call<GetDailyForecastRes> call = mDataManager.getDailyForecast(city, "metric", AppConfig.ApiKey);
        call.enqueue(new Callback<GetDailyForecastRes>() {
            @Override
            public void onResponse(@NonNull Call<GetDailyForecastRes> call, @NonNull Response<GetDailyForecastRes> response) {
                try {
                    if (adapter == null) {
                        list.addAll(response.body().getList());
                        adapter = new RVForecastAdapter(list);
                        getView().setArticlesToUI(adapter);
                    } else {
                        list.clear();
                        list.addAll(response.body().getList());
                        adapter.notifyDataSetChanged();
                    }
                } catch (NullPointerException e) {
                    getView().showMessage(R.string.incorrect_city);
                }
            }

            @Override
            public void onFailure(@NonNull Call<GetDailyForecastRes> call, @NonNull Throwable t) {
                getView().showMessage(R.string.request_error);
            }
        });
    }

    @Override
    public void restoreRV(Context context) {
        if (adapter != null) {
            getView().setArticlesToUI(adapter);
        }
    }
}
