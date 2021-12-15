package android.example.autodata.car.datasets.options;

import android.app.Activity;
import android.example.autodata.car.CarDataModel;

public class DataSellOptionsPresenter {

    private CarDataModel model = null;
    private DataSellOptionsActivity view;

    public DataSellOptionsPresenter(Activity view) {
        model = CarDataModel.getModel();
        this.view = (DataSellOptionsActivity) view;
    }

    public void onOptionsStart() {

        view.setPrices();
    }
}
