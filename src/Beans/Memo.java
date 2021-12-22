package Beans;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;

public class Memo implements Comparable<Memo> {
    private String description;
    private boolean important;
    private boolean shown;
    private Date memoDate;

    @Override
    public String toString() {
        return "Memo{" +
                "description='" + description + '\'' +
                ", important=" + important +
                ", shown=" + shown +
                ", memoDate=" + memoDate.getTime() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Memo)) return false;
        Memo memo = (Memo) o;
        return important == memo.important && shown == memo.shown && Objects.equals(description, memo.description) && Objects.equals(memoDate, memo.memoDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, important, shown, memoDate);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }

    public Date getMemoDate() {
        return memoDate;
    }

    public void setMemoDate(int year,int month,int day,int hour,int minute) {
        memoDate=Date.valueOf(LocalDate.of(year,month,day));
        this.memoDate = memoDate;
    }

    public Memo(String description, boolean important, int year,int month,int day,int hour,int minute) {
        this.description = description;
        this.important = important;
        setMemoDate(year, month, day, hour, minute);
    }

    @Override
    public int compareTo(Memo o) {
        return 0;
    }

}
