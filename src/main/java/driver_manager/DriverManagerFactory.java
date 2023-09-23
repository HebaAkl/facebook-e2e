package driver_manager;

import driver_manager.browsers.ChromeDriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager = null;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                // creating firefox driver
                break;
            default:
                // creating default driver
                break;
        }
        return driverManager;

    }


    public enum DriverType {
        CHROME,
        FIREFOX,
    }
}