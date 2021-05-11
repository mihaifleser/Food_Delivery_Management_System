package Business;

public abstract class MenuItem {

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

    public abstract Integer computePrice();
}
