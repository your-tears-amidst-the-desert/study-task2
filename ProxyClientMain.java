package main.java;

public class ProxyClientMain {
    public static void main(String[] args) throws Exception {
        MultiplyService service = new MultiplyProxy("localhost", 5000);
        double a = 6.5;
        double b = 2.0;
        double result = service.multiply(a, b);

        System.out.println("Клиент отправил: " + a + " и " + b);
        System.out.println("Ответ сервера: " + result);
    }
}
