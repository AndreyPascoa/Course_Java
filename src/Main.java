import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");        

        System.out.print("Room number:");
        int number = sc.nextInt();
        System.out.print("Check-In date:");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out date:");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.print("Error");
        }else{
            Resevation resevation = new Resevation(number, checkIn, checkOut);
            System.out.println("Resevation: " + resevation);

            System.out.println();
            System.out.print("Check-In date:");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date:");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if(checkIn.before(now) && checkOut.before(now)){
                System.out.print("Error");
            }else if(!checkOut.after(checkIn)){
                System.out.print("Error");
            }else{
                resevation.updateDates(checkIn, checkOut);
                System.out.println("Resevation: " + resevation);
            }

            resevation.updateDates(checkIn, checkOut);
            System.out.println("Resevation: " + resevation);
        }
    }
}
