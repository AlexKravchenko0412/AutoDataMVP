package android.example.autodata.car.datasets.composition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.example.autodata.R;
import android.os.Bundle;

public class DataSetCompositionActivity extends AppCompatActivity {

    private CompositionPresenter presenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_set_composition);

        recyclerView = findViewById(R.id.recViewCar);
        presenter = new CompositionPresenter(this);
        recyclerView.setAdapter(presenter);
    }
}