package pluralsight.javacourse.collections.Main;

import pluralsight.javacourse.collections.Classes.Ports;
import pluralsight.javacourse.collections.Classes.Product;

import java.util.*;

public class Main {

    public static void Info(List<Product> products, Product p) {
        //NOT SO USE
        final Iterator<Product> productIterator = products.iterator();
        while(productIterator.hasNext()) {
            Product product = productIterator.next();
            if(product.getWeight() > 20) {
                System.out.println(product);
            } else {
                productIterator.remove();
            }
        }

        System.out.println(products);
        System.out.println();

        //EQUIVALENT BUT USED MORE BUT IT YOU LOOP WITH THIS METHOD DON'T MODIFY THE COLLECTION, USE AN ITERATOR INSTEAD
        for(Product product:products) {
            System.out.println(product);
        }



        //ANOTHER METHODS
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(p));
        System.out.println(products.contains(p));

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(p);
        otherProducts.add(p);

        products.removeAll(otherProducts);
        System.out.println(products);
    }

    public static void main(String[] args) {
        Product door = new Product("Wooden Door",35);
        Product floorPanel = new Product("Floor Panel",25);
        Product window = new Product("Window",10);

        Ports CT = new Ports("Constanta",19,true);
        Ports TL = new Ports("Tulcea",10,true);
        Ports MM = new Ports("MareaMediteraneana",30,false);
        Ports MN = new Ports("MareaNeagra",10,false);

        Collection<Ports> ports = new ArrayList<>();
        ports.add(CT);
        ports.add(TL);
        ports.add(MM);



        //Printing ports with free space

        System.out.println("Ports with free space:");
        for(Ports port:ports) {
            if(port.isFree == true) {
                System.out.println(port.toString());
            }
        }

        System.out.println();
        System.out.println("Ports Full:");

        //Removing ports from the list with free space and printing without free
        final Iterator<Ports> portsIterator = ports.iterator();

        while(portsIterator.hasNext()) {
                Ports port = portsIterator.next();
                if(port.isFree == true) {
                    portsIterator.remove();
                } else {
                    System.out.println(port);
                }
        }

        System.out.println();
        System.out.println("Ports:");
        //Printing all the ports
        for(Ports port:ports) {
                System.out.println(port.toString());
        }


        Collection<Ports> anotherPorts = new ArrayList<>();
        anotherPorts.add(CT);
        anotherPorts.add(TL);
        anotherPorts.add(MM);


        List<Ports> anotherListPorts = new ArrayList<>();
        anotherListPorts.add(CT);
        anotherListPorts.add(TL);
        anotherListPorts.add(MM);
        anotherListPorts.add(MN);
//        Collections.sort(anotherListPorts);

        anotherListPorts.sort(new Comparator<Ports>() {
            @Override
            public int compare(Ports o1, Ports o2) {
                int nameCompare = o1.getName().compareTo(o2.getName());
                int noShipsCOmpare = Integer.compare(o1.getNoShips(), o2.getNoShips());

                if (noShipsCOmpare == 0) {
                    return nameCompare;
                } else {
                    return noShipsCOmpare;
                }
            }
        });

        Collections.sort(anotherListPorts);

        System.out.println();
        System.out.println("Ports sorted by numbers of ships:");
        for(Ports port : anotherListPorts) {
            System.out.println(port.toString());
        }

        Collection<Product> products = new ArrayList<Product>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);


    }
}
