package android.example.autodata.car.datasets.composition;

import android.content.Context;
import android.example.autodata.R;
import android.example.autodata.car.CarDataModel;
import android.example.autodata.car.CarDataPresenterInt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CompositionPresenter extends RecyclerView.Adapter<CompositionPresenter.ViewHolder> implements CarDataPresenterInt {

    private CarDataModel dataModel = null;
    private DataSetCompositionActivity view;
    private LayoutInflater inflater;

    public CompositionPresenter(Context context) {
        dataModel = CarDataModel.getModel();
        this.view = (DataSetCompositionActivity) view;
        this.inflater = LayoutInflater.from(context);
        dataModel.SetPresenter(this);
    }

    @Override
    public void DataSetChange() {

    }

    @Override
    public CompositionPresenter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.composition_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mComposition.setText(dataModel.getDataSetComposition(position));
    }


    @Override
    public int getItemCount() {
        return 0;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mComposition;

        public ViewHolder(View view) {
            super(view);
            mComposition = view.findViewById(R.id.textViewComposData);
        }
    }
}
