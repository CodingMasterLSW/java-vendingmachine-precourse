package vendingmachine.service;

import vendingmachine.domain.VendingMachine;

public class VendingMachineService {

    public VendingMachine createVendingMachine(int coinAmount) {
        return VendingMachine.from(coinAmount);
    }

}
