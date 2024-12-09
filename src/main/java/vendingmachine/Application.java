package vendingmachine;

import vendingmachine.config.AppConfig;
import vendingmachine.controller.VendingMachineController;

public class Application {

    public static void main(String[] args) {
        VendingMachineController vendingMachineController = AppConfig.createController();
        vendingMachineController.start();
    }
}
