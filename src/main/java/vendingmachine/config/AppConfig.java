package vendingmachine.config;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static VendingMachineController createController() {
        return new VendingMachineController(InputView.create(), OutputView.create(), createService());
    }

    public static VendingMachineService createService() {
        return new VendingMachineService();
    }

}
