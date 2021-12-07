package android.example.autodata.car.datasets.composition;

import android.example.autodata.car.CarDataModel;
import android.example.autodata.car.CarDataPresenterInt;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CompositionPresenter extends RecyclerView.Adapter<CompositionPresenter.ViewHolder> implements CarDataPresenterInt {

    private CarDataModel dataModel = null;
    private DataSetCompositionActivity view;

    public CompositionPresenter(DataSetCompositionActivity view) {
        dataModel = CarDataModel.getModel();
        this.view = (DataSetCompositionActivity) view;
    }

    @Override
    public void DataSetChange() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
