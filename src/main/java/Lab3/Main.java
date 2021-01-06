package Lab3;

import java.nio.file.Paths;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        TransferQueue<Product> products = new LinkedTransferQueue<>();

        new Thread(new Producer(products)).start();
        new Thread(new Consumer(products, Paths.get("products.txt"))).start();
    }
}