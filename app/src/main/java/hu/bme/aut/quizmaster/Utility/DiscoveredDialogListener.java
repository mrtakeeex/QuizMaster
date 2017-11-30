package hu.bme.aut.quizmaster.Utility;

public interface DiscoveredDialogListener {
    public void onDeviceSelectedForConnection(String addressMac);
    public void onScanClicked();
}
