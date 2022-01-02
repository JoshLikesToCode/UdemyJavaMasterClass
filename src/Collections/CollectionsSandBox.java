package Collections;

import java.sql.SQLOutput;
import java.util.*;

class Theatre {
    private final String theatreName;
    // this is extra generic, because of Collection<Seat> as opposed to List<Seat>
    private static final List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat s1, Seat s2)
        {
            if(s1.getPrice() < s2.getPrice())
                return -1;
            else if(s1.getPrice() > s2.getPrice())
                return 1;
            else
                return 0;
        }
    };

    Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                /* base price */
                double price = 12.00;
                if((row < 'D') && (seatNum >= 4) && seatNum <= 9)
                {
                    /* first three rows cost more, premium seat */
                    price = 14.00;
                }
                else if((row > 'F') || (seatNum < 4 || seatNum > 9))
                {
                    /* these seats are cheaper */
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if(foundSeat >= 0)
        {
            return seats.get(foundSeat).reserve();
        }
        else
        {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    // for testing
    public static Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price)
        {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserve() {
            if(!this.reserved)
            {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved.");
                return true;
            }
            else
                return false;
        }

        public boolean cancel() {
            if(this.reserved)
            {
                this.reserved = false;
                System.out.println("Reservations of seat " + seatNumber + " cancelled.");
                return true;
            }
            else
            {
                return false; // cannot cancel because seat reserved
            }
        }

        public String getSeatNumber()
        {
            return seatNumber;
        }

        public double getPrice()
        {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            // returns 0 if equal, number greater than zero if greater than, number less than zero if less than
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }

}

public class CollectionsSandBox {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Sleep Train Pavilion", 8, 12);
        if(theatre.reserveSeat("D12"))
        {
            System.out.println("Please pay for D12");
        }
        else {
            System.out.println("Seat already reserved");
        }

        if(theatre.reserveSeat("B13"))
        {
            System.out.println("Please pay for B13");
        }
        else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(Theatre.getSeats());
        Collections.reverse(reverseSeats);
        printSeats(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printSeats(priceSeats);
    }

    public static void printSeats(List<Theatre.Seat> list)
    {
        for(Theatre.Seat seat : list)
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        System.out.println();
        System.out.println("=======================================");
    }
}
