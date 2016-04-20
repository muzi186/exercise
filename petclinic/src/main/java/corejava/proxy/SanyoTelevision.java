package corejava.proxy;

/**
 * Created by ibm on 2016/2/26.
 */
public class SanyoTelevision implements Television, DigitalMachine {
    private String brand = "Sanyo";

    private int currentChannel = 0;

    @Override
    public void connect() {
        System.out.println(brand + " is going to connect.");
    }

    @Override
    public void start() {
        System.out.println(brand + " is going to start.");
    }

    @Override
    public void stop() {
        System.out.println(brand + " is going to stop.");
    }

    @Override
    public void play() {
        System.out.println(brand + " is going to play.");
    }

    @Override
    public void switchChannel(int channel) {
        currentChannel = channel;
        System.out.println(brand + "'s channel is " + currentChannel);
    }
}