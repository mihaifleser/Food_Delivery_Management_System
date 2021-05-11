import Business.BaseProduct;
import Business.CompositeProduct;
import Business.MenuItem;
import Presentation.Controller;
import java.util.ArrayList;

public class App {
    public static void main(String[] argv)
    {
        Controller controller = new Controller();
        controller.start();


        CompositeProduct a = new CompositeProduct("Salut");
        BaseProduct b = new BaseProduct("BBB",12f,23,43,54,32,43);
        BaseProduct c = new BaseProduct("CCC",12f,23,43,54,32,12);
        a.addBaseProduct(b);
        a.addBaseProduct(c);
        MenuItem menuItem = a;

        System.out.println((menuItem).computePrice());
        ArrayList<MenuItem> products = ((CompositeProduct)menuItem).getProducts();
        System.out.println(products.get(0).getTitle());

    }
}
