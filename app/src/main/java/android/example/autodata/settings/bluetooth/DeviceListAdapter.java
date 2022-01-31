package android.example.autodata.settings.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.example.autodata.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class DeviceListAdapter extends ArrayAdapter<BluetoothDevice> {

    private LayoutInflater layoutInflater;
    private ArrayList<BluetoothDevice> devices;
    private int viewResourceId;


    public DeviceListAdapter(Context context, int resource, ArrayList<BluetoothDevice> devices) {
        super(context, resource, devices);
        this.devices = devices;
        this.viewResourceId = resource;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(viewResourceId, null);
        BluetoothDevice bluetoothDevice = devices.get(position);

        if (bluetoothDevice != null) {
            TextView deviceName = (TextView) convertView.findViewById(R.id.tvDeviceName);
            TextView deviceAdress = (TextView) convertView.findViewById(R.id.tvDeviceAddress);

            if (deviceName != null) {
                deviceName.setText(bluetoothDevice.getName());
            }
            if (deviceAdress != null) {
                deviceAdress.setText(bluetoothDevice.getAddress());
            }
        }

        return convertView;
    }
}
