package vendingmachine.controller;

import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final VendingMachineService vendingMachineService;

    public VendingMachineController(InputView inputView, OutputView outputView, VendingMachineService vendingMachineService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.vendingMachineService = vendingMachineService;
    }

    public void start() {
        inputView.printCoinInputMessage();
        inputView.userInput();
    }

}
