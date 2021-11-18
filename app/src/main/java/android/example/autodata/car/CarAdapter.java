package android.example.autodata.car;

import android.content.Context;
import android.example.autodata.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private CarDataModel dataModel = null;

    CarAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        dataModel = new CarDataModel(this);
    }


    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.car_package_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        CarDataPackage carPackage = dataModel.getDataItem(position);
        holder.packageImg.setImageResource(carPackage.getPackageImg());
        holder.dataPackageName.setText(carPackage.getParamName());
        holder.params.setText(carPackage.getNumberOfParam());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        dataModel.onLoadCarData();
    }

    @Override
    public int getItemCount() {

        return dataModel.getSize();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView packageImg;
        final TextView dataPackageName;
        final TextView params;

        public ViewHolder(View view) {
            super(view);
            packageImg = view.findViewById(R.id.ivPackageImg);
            dataPackageName = view.findViewById(R.id.tvDataPackage);
            params = view.findViewById(R.id.tvParams);
        }

    }
}
