package Chapter10.service;

import Chapter10.model.Price;

public class TaxPriceProcess implements  PriceProcessor{
    @Override
    public Price process(Price price) {
        return new Price(price.getPrice()+" , then applied tax");
    }
}
