package practice.solution;

import java.time.LocalDateTime;

/**
 * дописать джавадок
 */
public class CSVCookie implements Cookie {
    private String cookieId;
    private LocalDateTime timestamp;

    public CSVCookie(String cookieId, LocalDateTime timestamp) {
        this.cookieId = cookieId;
        this.timestamp = timestamp;
    }

    @Override
    public String getCookieId() {
        return this.cookieId;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CSVCookie csvCookie)) return false;

        if (getCookieId() != null ? !getCookieId().equals(csvCookie.getCookieId()) : csvCookie.getCookieId() != null)
            return false;
        return this.cookieId.equals(((CSVCookie) o).getCookieId());
    }

    @Override
    public int hashCode() {
        int result = getCookieId() != null ? getCookieId().hashCode() : 0;
        result = 31 * result + (getTimestamp() != null ? getTimestamp().hashCode() : 0);
        return result;
    }
}
