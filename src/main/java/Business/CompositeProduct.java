package Business;

import java.util.ArrayList;

/**
 * Class used to compose a new menu Item from other menu Items.
 */

public class CompositeProduct extends MenuItem {

    private ArrayList<MenuItem> products;
    private Float totalRating;

    public CompositeProduct(String title)
    {
        super(title,0f,0,0,0,0,0);
        products = new ArrayList<>();
        totalRating = 0f;
    }
    public void addMenuProduct(MenuItem baseProduct)
    {
        products.add(baseProduct);
        this.totalRating += baseProduct.getRating();
        this.rating = totalRating / products.size();
        this.calories += baseProduct.getCalories();
        this.proteins += baseProduct.getProteins();
        this.fat += baseProduct.getFat();
        this.sodium += baseProduct.getSodium();
        this.price += baseProduct.computePrice();
    }

    @Override
    public Integer computePrice() {
        Integer price = 0;
        for (MenuItem baseProduct: products) {
            price += baseProduct.computePrice();
        }
        return price;
    }

    public ArrayList<MenuItem> getProducts()
    {
        return products;
    }

}
