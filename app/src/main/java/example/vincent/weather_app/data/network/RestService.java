package example.vincent.weather_app.data.network;

import example.vincent.weather_app.data.network.res.GetDailyForecastRes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestService {

    @GET("forecast/daily")
    Call<GetDailyForecastRes> getDailyForecast (@Query("q") String city,
                                                @Query("units") String units,
                                                @Query("appid") String apiKey);

}
