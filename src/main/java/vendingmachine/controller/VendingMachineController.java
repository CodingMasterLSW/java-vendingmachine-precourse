package vendingmachine.controller;

import java.util.Map;
import java.util.function.Supplier;
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
        int coinAmount = handleCoinInput();
        VendingMachine vendingMachine = vendingMachineService.createVendingMachine(coinAmount);
        Map<Integer, Integer> coinInfo = handlePossessedCoin(coinAmount, vendingMachine);
        String userInput = handleProductInput();
        Products products = vendingMachineService.createProducts(userInput);
        Insert insert = handleInsertPrice();
        handlePurchaseProduct(insert, products);
        handleChange(insert, coinInfo);
    }

    private int handleCoinInput() {
        inputView.printCoinInputMessage();
        return retryOnInvalidInput(() -> {
            return inputView.coinInput();
        });
    }

    private Map<Integer, Integer> handlePossessedCoin(int coinAmount,
            VendingMachine vendingMachine) {
        Map<Integer, Integer> coinInfo = vendingMachineService.generateCoin(
                vendingMachine);
        outputView.printVendingMachineCoinMessage();
        outputView.printGenerateCoin(coinInfo);
        return coinInfo;
    }

    private String handleProductInput() {
        inputView.printProductInputMessage();
        return retryOnInvalidInput(() -> {
            return inputView.userInput();
        });
    }

    private Insert handleInsertPrice() {
        inputView.printInputPriceMessage();
        return retryOnInvalidInput(() -> {
            int inputPrice = inputView.inputPrice();
            Insert insert = vendingMachineService.createPurchase(inputPrice);
            return insert;
        });
    }

    private void handlePurchaseProduct(Insert insert, Products products) {
        while (insert.getInputAmount() >= products.productsMinPrice() && products.canPurchase()) {
            outputView.printInsertAmount(insert.getInputAmount());
            String purchaseProduct = inputView.purchaseProduct();
            vendingMachineService.purchaseProduct(purchaseProduct, products,
                    insert);
        }
    }

    private void handleChange(Insert insert, Map<Integer, Integer> coinInfo) {
        outputView.printInsertAmount(insert.getInputAmount());
        Map<Integer, Integer> changeResult = vendingMachineService.calculateChange(coinInfo,
                insert.getInputAmount());
        outputView.printChange(changeResult);
    }


    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
