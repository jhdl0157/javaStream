package Chapter10;

import Chapter10.model.Price;
import Chapter10.service.BasicPriceProcess;
import Chapter10.service.DiscountPriceProcess;
import Chapter10.service.PriceProcessor;
import Chapter10.service.TaxPriceProcess;

public class Chapter10Section3 {
    public static void main(String[] args) {
        Price unprocessPrice=new Price("Origin Price");

        PriceProcessor basicPriceProcessor=new BasicPriceProcess();
        PriceProcessor discountPriceProcessor=new DiscountPriceProcess();
        PriceProcessor taxPriceProcessor =new TaxPriceProcess();

        PriceProcessor decoratePriceProcessor=basicPriceProcessor
                .andThen(discountPriceProcessor)
                .andThen(taxPriceProcessor);

        Price processedPrice =decoratePriceProcessor.process(unprocessPrice);
        System.out.println(processedPrice.getPrice());

        PriceProcessor decoratedPriceProcessor2= basicPriceProcessor
                .andThen(taxPriceProcessor)
                .andThen(price -> new Price(price.getPrice()+" , then apply another procedure"));
        Price processedPrice2=decoratedPriceProcessor2.process(unprocessPrice);
        System.out.println(processedPrice2.getPrice());
    }
}
