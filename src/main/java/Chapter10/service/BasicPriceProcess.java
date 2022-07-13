package Chapter10.service;

import Chapter10.model.Price;

public class BasicPriceProcess implements  PriceProcessor{
    @Override
    public Price process(Price price) {
        return price;
    }
}
