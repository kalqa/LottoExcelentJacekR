package pl.lotto.numberreceiver;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DrawDateSelector {


    public Clock clock;

    private static final int DRAW_HOUR = 12;
    private static final DayOfWeek DRAW_DAY = DayOfWeek.SATURDAY;
    LocalDateTime todayDraw;
    LocalDateTime nextDrawDate;

    public DrawDateSelector(Clock clock) {
        this.clock = clock;
        this.todayDraw = LocalDateTime.now(clock).truncatedTo(ChronoUnit.HOURS);
        this.nextDrawDate = todayDraw.with(TemporalAdjusters.next(DRAW_DAY)).withHour(DRAW_HOUR);
    }

    public LocalDateTime specifyExactDateNextDraw() {
        if (isAbleToDrawToday()) {
            return todayDraw.withHour(DRAW_HOUR);
        } else {
            return nextDrawDate;
        }
    }

    private boolean isAbleToDrawToday() {
        if (todayDraw.getDayOfWeek() != DRAW_DAY) {
            return false;
        } else {
            return todayDraw.getHour() < DRAW_HOUR;
        }
    }
}


