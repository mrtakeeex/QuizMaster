package hu.bme.aut.quizmaster.UserInterface;

import android.Manifest;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothDevice;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.ramimartin.multibluetooth.activity.BluetoothFragmentActivity;
import com.ramimartin.multibluetooth.bluetooth.manager.BluetoothManager;

import hu.bme.aut.quizmaster.R;
import hu.bme.aut.quizmaster.UserInterface.Player.PlayerMainFragment;
import hu.bme.aut.quizmaster.Utility.DiscoveredDialogListener;
import hu.bme.aut.quizmaster.Utility.KeyStore;

public class PlayerActivity extends BluetoothFragmentActivity implements DiscoveredDialogListener {

    private LinearLayout linearLayout;
    private DiscoveredDialogListener mDiscoveredDialogListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        linearLayout = (LinearLayout) findViewById(R.id.playerActivity);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.playerActivity, new PlayerMainFragment());
        fragmentTransaction.commit();

        if (Build.VERSION.SDK_INT >= 23) {
            int permissionCheck = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            permissionCheck += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, KeyStore.PERMISSION_REQUEST_COARSE_LOCATION);
            } else {
                // TODO
            }
        } else {
            // TODO
        }

        setMessageMode(BluetoothManager.MessageMode.String);

        // Player is client by default
        setTimeDiscoverable(BluetoothManager.BLUETOOTH_TIME_DICOVERY_120_SEC);
        selectClientMode();

        scanAllBluetoothDevice();
        onScanClicked();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case KeyStore.PERMISSION_REQUEST_COARSE_LOCATION: {
                // TODO
            }
        }
    }

    @Override
    public String setUUIDappIdentifier() {
        return KeyStore.UUID_STRING;
    }

    @Override
    public int myNbrClientMax() {
        return 5;
    }

    @Override
    public void onBluetoothDeviceFound(BluetoothDevice bluetoothDevice) {

    }

    @Override
    public void onClientConnectionSuccess() {

    }

    @Override
    public void onClientConnectionFail() {

    }

    @Override
    public void onServeurConnectionSuccess() {

    }

    @Override
    public void onServeurConnectionFail() {

    }

    @Override
    public void onBluetoothStartDiscovery() {

    }

    @Override
    public void onBluetoothMsgStringReceived(String s) {

    }

    @Override
    public void onBluetoothMsgObjectReceived(Object o) {

    }

    @Override
    public void onBluetoothMsgBytesReceived(byte[] bytes) {

    }

    @Override
    public void onBluetoothNotAviable() {
    }

    @Override
    public void onDeviceSelectedForConnection(String addressMac) {
        createClient(addressMac);
    }

    @Override
    public void onScanClicked() {
        scanAllBluetoothDevice();
    }
}
