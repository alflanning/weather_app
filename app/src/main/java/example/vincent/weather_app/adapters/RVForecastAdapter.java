package example.vincent.weather_app.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import example.vincent.weather_app.R;
import example.vincent.weather_app.data.network.res.GetDailyForecastRes;

public class RVForecastAdapter extends RecyclerView.Adapter<RVForecastAdapter.CardViewHolder>{

    class CardViewHolder extends RecyclerView.ViewHolder  {
        CardView cv;
        TextView date, temp, pressure, humidity;

        CardViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card);
            date = itemView.findViewById(R.id.item_date);
            temp = itemView.findViewById(R.id.item_temp);
            pressure = itemView.findViewById(R.id.item_pressure);
            humidity = itemView.findViewById(R.id.item_humidity);
        }
    }

    private List<GetDailyForecastRes.List> list;
    public RVForecastAdapter(List<GetDailyForecastRes.List> list){
        this.list = list;

    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_weather_list, viewGroup, false);
        CardViewHolder cvh = new CardViewHolder(v);

        return cvh;
    }

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder cardViewHolder, int i) {

        GetDailyForecastRes.List item = list.get(i);

        cardViewHolder.date.setText(new java.text.SimpleDateFormat("dd.MM").format(new Date(item.getDt() * 1000)));
        cardViewHolder.temp.setText("Температура : " + ((int) item.getTemp().getDay()) + " °C");
        cardViewHolder.pressure.setText("Давление : " + ((int) (item.getPressure() * 0.7501)) + " мм рт. ст.");
        cardViewHolder.humidity.setText("Влажность : " + item.getHumidity() + " %");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
