package example.vincent.weather_app.views;

import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.vincent.weather_app.R;
import example.vincent.weather_app.adapters.RVForecastAdapter;
import example.vincent.weather_app.data.network.res.GetDailyForecastRes;
import example.vincent.weather_app.interfaces.MainActivityInterface;
import example.vincent.weather_app.presenters.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements MainActivityInterface.View {

    MainActivityPresenter presenter;

    @BindView(R.id.idToolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.root_layout)
    CoordinatorLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initToolbar();

        presenter = (MainActivityPresenter) getLastCustomNonConfigurationInstance();
    }

    private void initPresenter(){
        presenter = new MainActivityPresenter();
        presenter.attachView(this);
        showMessage(R.string.select_city);

    }

    protected void attachView() {
        if(presenter != null){
            if(!presenter.isViewAttached()){
                presenter.attachView(this);
                presenter.restoreRV(this);
            }
        }else{
            initPresenter();
        }
    }

    protected void detachView() {
        if(presenter != null){
            if(presenter.isViewAttached()) {
                presenter.detachView();
            }
        }
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        attachView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detachView();
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        showEditCityDialog();
        return super.onOptionsItemSelected(item);
    }

    private void showEditCityDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.edit_city);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setPadding(50, 50, 50, 50);
        input.setHint(R.string.press_to_edit_city);
        input.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        builder.setView(input);
        builder.setNegativeButton(R.string.cencel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String city  = input.getText().toString();
                if (city.length() > 0) {
                    city = city.trim().toLowerCase();
                    presenter.getDailyForecastRequest(city);
                }
            }
        });
        builder.show();
    }

    @Override
    public void setArticlesToUI(RVForecastAdapter adapter) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showMessage(int messageResId) {
        Snackbar snackbar = Snackbar.make(rootView, messageResId, Snackbar.LENGTH_LONG);
        snackbar.setDuration(1500);
        snackbar.show();
    }
}
