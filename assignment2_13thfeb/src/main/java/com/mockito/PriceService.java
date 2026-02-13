package com.mockito;

public class PriceService {
	private DiscountRepository repository;
	public PriceService(DiscountRepository repository) {
        this.repository = repository;
    }
	public double calculateFinalPrice(double price, String productCode) {

        double discount = repository.getDiscountPercentage(productCode);

        double finalPrice = price - (price * discount / 100);

        return finalPrice;
    }
}


