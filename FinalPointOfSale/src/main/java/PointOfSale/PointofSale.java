package PointOfSale;

import Exceptions.InvalidInputException;
import Product.PaymentRepository;
import Product.ProductRepository;

import java.io.IOException;


import static Login.Login.sc;

public class PointofSale {
    private ProductRepository productRepository;
    private PaymentRepository paymentRepository;

    public PointofSale() throws IOException {
        productRepository = new ProductRepository();
        paymentRepository = new PaymentRepository();
    }


    public void run() {
        while (true) {
            try {
                System.out.println("------------------------------");
                System.out.println("[1] - Add Product");
                System.out.println("[2] - Buy Product");
                System.out.println("[3] - Generate Sales");
                System.out.println("[4] - Sign-out");
                System.out.print("Choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> new AddProduct(productRepository).runService();
                    case 2 -> new BuyProduct(productRepository, paymentRepository).runService();
                    case 3 -> new Sales();
                    case 4 -> {
                        return;
                    }
                    default -> throw new InvalidInputException("Invalid Choice");
                }

            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Choice");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
