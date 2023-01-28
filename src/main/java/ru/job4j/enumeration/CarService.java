package ru.job4j.enumeration;

public class CarService {

    public static void main(String[] args) {
        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Status Toyota: " + toyota);
        System.out.println("Status Volvo: " + volvo);
        Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);
        System.out.println("Order #" + order.getNumber() + " for auto " + order.getCar()
                + ", repair status: " + order.getStatus());
        //Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);
        System.out.println("Order #" + order.getNumber() + " for auto " + order.getCar()
                + ", repair status: " + order.getStatus().getInfo());
        System.out.println("Order #" + order.getNumber() + " for auto " + order.getCar()
                + ", repair status: " + order.getStatus().getInfo() + ", more info: " + order.getStatus().getMessage());
        Status[] statuses = Status.values();
        for (Status s : statuses) {
            System.out.println("Status name: " + s.name() + ", with number: " + s.ordinal());
        }
        String accepted = "ACCEPTED";
        Status status = Status.valueOf(accepted);
        System.out.println(status);
        switch (status) {
            case ACCEPTED:
                System.out.println("Status: Auto accepted");
                break;
            case IN_WORK:
                System.out.println("Status: Auto in work");
                break;
            case WAITING:
                System.out.println("Status: Auto waiting");
                break;
            case FINISHED:
                System.out.println("Status: Work is finished");
                break;
            default:
        }
    }
}