package Business;

public class BaseProduct extends MenuItem{


    public BaseProduct(String title, Float rating, Integer calories, Integer proteins, Integer fat, Integer sodium, Integer price) {
        super(title, rating, calories, proteins, fat, sodium, price);
    }

    @Override
    public Integer computePrice() {
        return this.price;
    }


}
