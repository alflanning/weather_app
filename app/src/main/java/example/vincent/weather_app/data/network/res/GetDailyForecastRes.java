package example.vincent.weather_app.data.network.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDailyForecastRes {

    @SerializedName("city")
    @Expose
    public City city;
    @SerializedName("cod")
    @Expose
    public String cod;
    @SerializedName("message")
    @Expose
    public float message;
    @SerializedName("cnt")
    @Expose
    public int cnt;
    @SerializedName("list")
    @Expose
    public java.util.List<List> list = null;

    public City getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public float getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public class City {

        @SerializedName("id")
        @Expose
        public int id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("coord")
        @Expose
        public Coord coord;
        @SerializedName("country")
        @Expose
        public String country;
        @SerializedName("population")
        @Expose
        public int population;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Coord getCoord() {
            return coord;
        }

        public String getCountry() {
            return country;
        }

        public int getPopulation() {
            return population;
        }
    }

    public class Coord {

        @SerializedName("lon")
        @Expose
        public float lon;
        @SerializedName("lat")
        @Expose
        public float lat;

        public float getLon() {
            return lon;
        }

        public float getLat() {
            return lat;
        }
    }

    public class List {

        @SerializedName("dt")
        @Expose
        public long dt;
        @SerializedName("temp")
        @Expose
        public Temp temp;
        @SerializedName("pressure")
        @Expose
        public float pressure;
        @SerializedName("humidity")
        @Expose
        public int humidity;
        @SerializedName("weather")
        @Expose
        public java.util.List<Weather> weather = null;
        @SerializedName("speed")
        @Expose
        public float speed;
        @SerializedName("deg")
        @Expose
        public int deg;
        @SerializedName("clouds")
        @Expose
        public int clouds;
        @SerializedName("rain")
        @Expose
        public float rain;

        public long getDt() {
            return dt;
        }

        public Temp getTemp() {
            return temp;
        }

        public float getPressure() {
            return pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public java.util.List<Weather> getWeather() {
            return weather;
        }

        public float getSpeed() {
            return speed;
        }

        public int getDeg() {
            return deg;
        }

        public int getClouds() {
            return clouds;
        }

        public float getRain() {
            return rain;
        }
    }

    public class Temp {

        @SerializedName("day")
        @Expose
        public float day;
        @SerializedName("min")
        @Expose
        public float min;
        @SerializedName("max")
        @Expose
        public float max;
        @SerializedName("night")
        @Expose
        public float night;
        @SerializedName("eve")
        @Expose
        public float eve;
        @SerializedName("morn")
        @Expose
        public float morn;

        public float getDay() {
            return day;
        }

        public float getMin() {
            return min;
        }

        public float getMax() {
            return max;
        }

        public float getNight() {
            return night;
        }

        public float getEve() {
            return eve;
        }

        public float getMorn() {
            return morn;
        }
    }

    public class Weather {

        @SerializedName("id")
        @Expose
        public int id;
        @SerializedName("main")
        @Expose
        public String main;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("icon")
        @Expose
        public String icon;

        public int getId() {
            return id;
        }

        public String getMain() {
            return main;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }

}
