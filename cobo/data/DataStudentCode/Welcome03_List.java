// Team (P)BNJ :: Brian Li, Nakib Abedin, Jefford Shau
// APCS pd07
// LAB08 -- America's Next Top Data Scientist
// 2022-04-05
// time spent: 0.7 hrs + class time

/*
 * Arrays of objects
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Welcome03_List {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name",
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());

      // Total stations: 2876

      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            System.out.println("  " + ws.getId() + ": " + ws.getName());
         }
      }

      /*
      Stations in NY
        KALB: Albany International Airport
        KART: Watertown, Watertown International Airport
        KBGM: Binghamton, Binghamton Regional   Airport
        KBUF: Buffalo, Greater Buffalo International Airport
        KDKK: Dunkirk, Chautauqua County / Dunkirk Airport
        KDSV: Dansville, Dansville Municipal Airport
        KELM: Elmira, Elmira / Corning Regional Airport
        KELZ: Wellsville, Wellsville Municipal Airport
        KFOK: The Gabreski Airport
        KFRG: Farmingdale - Republic Airport
        KFZY: Fulton, Oswego County Airport
        KGFL: Glens Falls, Floyd Bennett Memorial Airport
        KGTB: Fort Drum / Wheeler-Sack U. S. Army Airfield
        KHPN: White Plains - Westchester County Airport
        KHTO: East Hampton, East Hampton Airport
        KHWV: Shirley, Brookhaven Airport
        KIAG: Niagara Falls, Niagara Falls International Airport
        KISP: Islip, Long Island Mac Arthur Airport
        KITH: Ithaca, Ithaca Tompkins Regional Airport
        KJFK: New York, Kennedy International Airport
        KJHW: Jamestown, Chautauqua County/Jamestown Airport
        KLGA: New York, La Guardia Airport
        KMGJ: Montgomery, Orange County Airport
        KMSS: Massena, Massena International-Richards Field
        KMSV: Monticello, Sullivan County International Airport
        KMTP: Montauk, Montauk Airport
        KNYC: New York City, Central Park
        KOGS: Ogdensburg International Airport
        KOLE: Cattaraugus County-Olean Airport
        KPBG: Plattsburgh International Airport
        KPOU: Poughkeepsie, Dutchess County Airport
        KRME: Griffiss Air Force Base / Rome
        KROC: Rochester, Greater Rochester International Airport
        KSCH: Schenectady Airport
        KSLK: Saranac Lake, Adirondack Regional Airport
        KSWF: Newburgh / Stewart
        KSYR: Syracuse, Syracuse Hancock International Airport
        KPEO: Penn Yan, Penn Yan Airport
        KOIC: NORWICH
        KVGC: Hamilton Municipal Airport
        KIUA: Canandaigua Airport
        KPTD: Potsdam Municipal Airport/Damon Field
        KSDC: Williamson-Sodus Airport
        KN03: Cortland County-Chase Field
        KNY0: Fulton County Airport
        KJRB: New York Downtown Manhattan
        K6B9: Skaneateles Aero Drome
        KGVQ: Genesee County Airport
      */

      WeatherStation currentLowest = allstns.get(0);

      for (WeatherStation station : allstns){
        if (station.getLat() < currentLowest.getLat()) {
          currentLowest = station;
        }
      }

      // Furthest station south is: Pago Pago, AS, Samoa

      System.out.println( "Furthest station south is: " + currentLowest.getName());

   }
}
