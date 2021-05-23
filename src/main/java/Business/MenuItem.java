package Business;

import java.io.Serializable;

/**
 * Class used to store the information about the items from the menu
 */


public abstract class MenuItem implements Serializable {

    protected String title;
    protected Float rating;
    protected Integer calories;
    protected Integer proteins;
    protected Integer fat;
    protected Integer sodium;
    protected Integer price;

    public MenuItem(String title, Float rating, Integer calories, Integer proteins, Integer fat, Integer sodium, Integer price)
    {
        this.title = title;
        this.rating = rating;
        this.calories= calories;
        this.proteins = proteins;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getSodium() {
        return sodium;
    }

    public void setSodium(Integer sodium) {
        this.sodium = sodium;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object other){
        return title.equals(((MenuItem)other).getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }


    public abstract Integer computePrice();
}
