package hu.bme.aut.quizmaster.UserInterface;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothDevice;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.ramimartin.multibluetooth.activity.BluetoothFragmentActivity;
import com.ramimartin.multibluetooth.bluetooth.manager.BluetoothManager;

import hu.bme.aut.quizmaster.R;
import hu.bme.aut.quizmaster.UserInterface.QuizMaster.QuizMasterGameFragment;
import hu.bme.aut.quizmaster.UserInterface.QuizMaster.QuizMasterMainFragment;
import hu.bme.aut.quizmaster.Utility.DiscoveredDialogListener;
import hu.bme.aut.quizmaster.Utility.KeyStore;

public class QuizMasterActivity extends BluetoothFragmentActivity implements DiscoveredDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master);

        switchView(new QuizMasterMainFragment());

        if (Build.VERSION.SDK_INT >= 23) {
            int permissionCheck = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            permissionCheck += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, KeyStore.PERMISSION_REQUEST_COARSE_LOCATION);
            } else {
                // TODO stuff if u need
            }
        } else {
            // TODO stuff if u need
        }

        setMessageMode(BluetoothManager.MessageMode.String);

        // QuizMaster is server by default
        setTimeDiscoverable(BluetoothManager.BLUETOOTH_TIME_DICOVERY_3600_SEC);
        selectServerMode();
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

    public void startGame() {
        switchView(new QuizMasterGameFragment());
    }

    @Override
    public void onBackPressed() {
        switchView(new QuizMasterMainFragment());
    }

    private void switchView(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.quizMasterActivity, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onDeviceSelectedForConnection(String addressMac) {

    }

    @Override
    public void onScanClicked() {
        scanAllBluetoothDevice();
    }
}
