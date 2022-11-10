package pl.lotto.numberreceiver;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DrawDateSelector {

    //    private final LocalDateTime DATE_AND_TIME_OF_TICKET_PURCHASE = LocalDateTime.now();
    private static final LocalDate DATE_OF_TICKET_PURCHASE = LocalDate.now();
    private static final int DRAW_HOUR = 12;
//    private static final DayOfWeek DRAW_DAY = ;

    public static LocalDateTime specifyExactDateNextDraw() {
        LocalDateTime today = LocalDateTime.now();
        return today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

//        if (isAfterDrawDate()) {
////            LocalDateTime of = LocalDateTime.of(DATE_OF_TICKET_PURCHASE.plusWeeks(1), LocalTime.of(DRAW_HOUR, 0));
//            LocalDateTime with = DATE_AND_TIME_OF_TICKET_PURCHASE.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
//            return with;
//        } else {
//            LocalDateTime of = LocalDateTime.of(DATE_OF_TICKET_PURCHASE, LocalTime.of(DRAW_HOUR, 0));
//            LocalDateTime with = of.with(TemporalAdjusters.nextOrSame(DRAW_DAY));
//            return with;
//        }
    }

//    private static boolean isAfterDrawDate() {
//        return DATE_OF_TICKET_PURCHASE.getDayOfWeek() == DRAW_DAY && DATE_AND_TIME_OF_TICKET_PURCHASE.getHour() >= DRAW_HOUR;
//    }
}

