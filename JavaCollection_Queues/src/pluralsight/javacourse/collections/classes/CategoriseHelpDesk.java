package pluralsight.javacourse.collections.classes;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class CategoriseHelpDesk {

    private Queue<Enquiry> enquiries = new ArrayDeque<>();

    public boolean enquire(final Customer customer, final Category type) {
        return enquiries.offer(new Enquiry(customer,type));
    }

    public void processPrinterEnquiry() {
        processEnquiry(enq -> enq.getCategory() == Category.PRINTER,
                "It is out of paper?");
    }

    public void processGeneralEnquiry() {
        processEnquiry(enq -> enq.getCategory() != Category.PRINTER, "Have you tried turning it off and on again?");
    }

    private void processEnquiry(Predicate<Enquiry> predicate, String message) {
        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && predicate.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            System.out.println("No work to do, let's have some coffe!");
        }
    }


    public static void main(String[] args) {
        CategoriseHelpDesk helpDesk = new CategoriseHelpDesk();


        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
    }
}
