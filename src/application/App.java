package application;

import entities.Sale;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        Sale sale;

        Locale.setDefault( Locale.US );

        Scanner sc = new Scanner( System.in );

        System.out.print( "Enter the file path: " );
        String path = sc.nextLine();

        File file = new File( path );

        List<Sale> sales = new ArrayList<>();

        try ( BufferedReader bf = new BufferedReader( new FileReader( file ) ) ) {

            String line = bf.readLine();
            while ( line != null ) {
                String[] fields = line.split( "," );

                int month = Integer.parseInt( fields[ 0 ] );
                int year  = Integer.parseInt( fields[ 1 ] );
                int items = Integer.parseInt( fields[ 3 ] );

                String seller = fields[ 2 ];

                double total = Double.parseDouble( fields [ 4 ] );

                sale = new Sale( month, year, seller, items, total );

                sales.add( sale );
                
                line = bf.readLine();
            }
            
            List<Sale> pm = sales.stream()
                .filter( s -> s.getYear() == 2016 )
                .sorted( Comparator.reverseOrder() )
                .limit( 5 )
                .collect( Collectors.toList() );

            System.out.println( "\nFive highest average price sales of 2016: " );
            pm.forEach( System.out::println );

            Double logan = sales.stream()
                .filter( l -> l.getSeller().equals( "Logan" ) )
                .filter( m -> m.getMonth() == 1 || m.getMonth() == 7 )
                .mapToDouble( Sale::getTotal )
                .sum();

            System.out.println( "\nTotal value sold by seller Logan in months 1 and 7 = " + logan );

        } catch (Exception e) {
            sc.close();
            System.out.println( "ERROR READING FILE: " + e.getMessage() );
        }

        sc.close();
    }
}
