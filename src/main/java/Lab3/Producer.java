package Lab3;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {

    private final TransferQueue<Product> products;

    Producer(TransferQueue<Product> products) {
        this.products = products;
    }

    @Override
    public void run() {
        int i = 0;
        Random r = new Random();
        while (true) {
            Product product = new Product("Product #" + (i++), new Date(), r.nextInt(100));
            try {
                products.transfer(product);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

}