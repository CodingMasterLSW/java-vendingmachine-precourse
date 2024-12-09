package vendingmachine.controller;

import vendingmachine.domain.Products;
import vendingmachine.domain.Insert;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private final VendingMachineService vendingMachineService;

    public VendingMachineController(InputView inputView, OutputView outputView,
            VendingMachineService vendingMachineService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.vendingMachineService = vendingMachineService;
    }

    public void start() {
        inputView.printCoinInputMessage();
        int coinAmount = inputView.coinInput();
        VendingMachine vendingMachine = vendingMachineService.createVendingMachine(coinAmount);

        inputView.printProductInputMessage();
        String userInput = inputView.userInput();

        Products products = vendingMachineService.createProducts(userInput);

        inputView.printInputPriceMessage();
        int inputPrice = inputView.inputPrice();
        Insert insert = vendingMachineService.createPurchase(inputPrice);
    }

}
