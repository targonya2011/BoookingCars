package booking;

import java.time.LocalDateTime;
import java.util.Objects;
import user.User;

public class Booking {
    private String bookingId;
    private User user;
    private LocalDateTime bookingTime;
    private boolean isCancelled = false;

    public Booking() {
    }

    public Booking(String bookingId, User user, LocalDateTime bookingTime, boolean isCancelled) {
        this.bookingId = bookingId;
        this.user = user;
        this.bookingTime = bookingTime;
        this.isCancelled = isCancelled;
    }

    public String getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getBookingTime() {
        return this.bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.isCancelled = cancelled;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Booking booking = (Booking)o;
            return this.isCancelled == booking.isCancelled && Objects.equals(this.bookingId, booking.bookingId) && Objects.equals(this.user, booking.user) && Objects.equals(this.bookingTime, booking.bookingTime);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.bookingId, this.user, this.bookingTime, this.isCancelled});
    }

    public String toString() {
        return "Booking{bookingId=" + this.bookingId + ", user=" + this.user + ", bookingTime=" + this.bookingTime + ", isCancelled=" + this.isCancelled + "}";
    }
}
