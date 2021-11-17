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
    private final List<CarDataPackage> carPackages;

    CarAdapter(Context context, List<CarDataPackage> carPackages) {
        this.carPackages = carPackages;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.car_package_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarAdapter.ViewHolder holder, int position) {
        CarDataPackage carPackage = carPackages.get(position);
        holder.packageImg.setImageResource(carPackage.getPackageImg());
        holder.dataPackageName.setText(carPackage.getParamName());
        holder.params.setText(carPackage.getNumberOfParam());
    }

    @Override
    public int getItemCount() {
        return carPackages.size();
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
