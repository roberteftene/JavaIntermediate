package pluralsight.javacourse.collections.classes;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk {

    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        @Override
        public int compare(Enquiry o1, Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };

    private Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public void enquire(final Customer customer, final Category type) {
        enquiries.offer(new Enquiry(customer,type));
    }

    public void processAllEnquires()  {

        Enquiry enquiry;
        while((enquiry = enquiries.poll()) != null) {
                enquiry.getCustomer().reply("have you tried turning it off and on again?");
        }

    }

    public static void main(String[] args) {
        PriorityHelpDesk helpDesk = new PriorityHelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);
        helpDesk.enquire(Customer.MARY, Category.COMPUTER);

        helpDesk.processAllEnquires();

    }


}
