package application;

import model.entities.Client;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Product;
import model.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String []args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Entrando com os dados do cliente e instanciando o objeto

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        Client client = new Client(name, email, birthDate);

        //Iniciando uma ordem

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(),status, client);

        //Iniciando os produtos
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++ ){
            sc.nextLine();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String nameProduct = sc.nextLine();
            System.out.print("Price: ");
            Double priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantityProduct = sc.nextInt();

            Product product = new Product(nameProduct, priceProduct);

            //Incluindo os produtos na ordem

            OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}
