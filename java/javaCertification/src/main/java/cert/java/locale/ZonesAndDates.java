package cert.java.locale;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ZonesAndDates {
    public static void main(String[] args) {
        ZoneId cr = ZoneId.of("America/Costa_Rica");
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");
        ZoneId swiss = ZoneId.of("Europe/Zurich");
//        for(String zoneId : ZoneId.getAvailableZoneIds()){
//            System.out.println(zoneId);
//        }
        Locale locale = new Locale("es","cr");
        LocalDateTime currTime = LocalDateTime.now();
        ZonedDateTime crDateTime = ZonedDateTime.of(currTime, cr);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        System.out.println(crDateTime.format(formatter));

        //Just modifies the timezone and keeps the time
        ZonedDateTime tokyoSameTime = crDateTime.withZoneSameLocal(tokyo);
        System.out.println(tokyoSameTime.format(formatter));

        //Gets the time for the same instant, in a different timezone
        ZonedDateTime tokyoSameInstant = crDateTime.withZoneSameInstant(tokyo);
        System.out.println(tokyoSameInstant.format(formatter));

        //Gets the time for the same instant, in a different timezone
        ZonedDateTime swissSameInstant = crDateTime.withZoneSameInstant(swiss);
        System.out.println(swissSameInstant.format(formatter));
    }
}
