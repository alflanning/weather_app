package example.vincent.weather_app.interfaces.base;

public abstract class BasePresenter <T extends BaseInterfaceView> implements BaseInterfacePresenter<T> {

    private T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void viewIsReady() {

    }

    public T getView() {
        return view;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismisProgressDialog() {

    }
}
