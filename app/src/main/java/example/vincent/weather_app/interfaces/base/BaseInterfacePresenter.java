package example.vincent.weather_app.interfaces.base;

public interface BaseInterfacePresenter <V extends BaseInterfaceView> {
    void attachView(V view);

    void viewIsReady();

    void detachView();

    void destroy();

    void showProgressDialog();

    void dismisProgressDialog();
}
