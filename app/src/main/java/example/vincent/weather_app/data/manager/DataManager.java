package example.vincent.weather_app.data.manager;

import example.vincent.weather_app.data.network.RestService;
import example.vincent.weather_app.data.network.ServiceGenerator;
import example.vincent.weather_app.data.network.res.GetDailyForecastRes;
import retrofit2.Call;

public class DataManager {

    private static DataManager INSTANCE = null;
    private RestService mRestService;

    public DataManager(){
        this.mRestService = ServiceGenerator.createService(RestService.class);
    }

    public static DataManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }

    public Call<GetDailyForecastRes> getDailyForecast(String city, String units, String appid) {
        return mRestService.getDailyForecast(city, units, appid);
    }

}
