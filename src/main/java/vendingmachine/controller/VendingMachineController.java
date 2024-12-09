package vendingmachine.controller;

import java.util.Map;
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

        Map<Integer, Integer> coinInfo = vendingMachineService.generateCoin(
                vendingMachine);

        outputView.printVendingMachineCoinMessage();
        outputView.printGenerateCoin(coinInfo);

        inputView.printProductInputMessage();
        String userInput = inputView.userInput();

        Products products = vendingMachineService.createProducts(userInput);

        inputView.printInputPriceMessage();
        int inputPrice = inputView.inputPrice();
        Insert insert = vendingMachineService.createPurchase(inputPrice);

        while(true) {
            if (insert.getInputAmount() < products.productsMinPrice() || !products.canPurchase()) {
                break;
            }
            outputView.printInsertAmount(insert.getInputAmount());
            String purchaseProduct = inputView.purchaseProduct();
            vendingMachineService.purchaseProduct(purchaseProduct, products,
                    insert);
        }
        outputView.printInsertAmount(insert.getInputAmount());
        Map<Integer, Integer> integerIntegerMap = vendingMachineService.calculateChange(coinInfo,
                insert.getInputAmount());
        outputView.printChange();
        for (Integer integer : integerIntegerMap.keySet()) {
            System.out.println(integer+"원 - " + integerIntegerMap.get(integer)+"개");
        }
    }

}
