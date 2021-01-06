package Lab3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {

    private final TransferQueue<Product> products;
    private final BufferedWriter writer;

    Consumer(TransferQueue<Product> products, Path file) throws IOException {
        this.products = products;
        this.writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Product product = products.take();
                System.out.println("Received a product: " + product);

                writer.write(product.toString());
                writer.newLine();
                writer.flush();

                Thread.sleep(1000);

                System.out.println("Processed a product: " + product);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}