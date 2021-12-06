package android.example.autodata.car.datasets;

import android.app.Activity;
import android.content.Context;
import android.example.autodata.car.CarDataModel;
import android.example.autodata.car.CarDataPresenterInt;
import android.view.View;

public class FormPresenter implements CarDataPresenterInt {

    private CarDataModel model = null;
    private DataSetActivity view;

    public FormPresenter (Activity view) {
        model = CarDataModel.getModel();
        this.view = (DataSetActivity)view;
    }

    @Override
    public void DataSetChange() {

    }

    public void onFormStart() {
        view.setTvDefaultTerm(model.getDefaultForm());
    }

}
