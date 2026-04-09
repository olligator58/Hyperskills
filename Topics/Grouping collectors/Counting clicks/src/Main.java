import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Scanner;

class Monitor {

    public static Map<String, Long> getUrlToNumberOfVisited(List<LogEntry> logs) {
        return logs.stream()
                .collect(
                        Collectors.groupingBy(LogEntry::getUrl, Collectors.counting())
                );
    }

    static class LogEntry {

        private Date created;
        private String login;
        private String url;

        public LogEntry(Date created, String login, String url) {
            this.created = created;
            this.login = login;
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LogEntry)) {
                return false;
            }

            LogEntry logEntry = (LogEntry) o;

            if (!login.equals(logEntry.login)) {
                return false;
            }
            return url.equals(logEntry.url);
        }

        @Override
        public int hashCode() {
            int result = login.hashCode();
            result = 31 * result + url.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    ", created=" + created +
                    ", login='" + login + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}

class Testus {
    public static void main(String[] args) {
        List<Monitor.LogEntry> logs = new ArrayList<>();
        logs.add(new Monitor.LogEntry(new Date(), "ben", "pornolab"));
        logs.add(new Monitor.LogEntry(new Date(), "mosya", "pornolab"));
        logs.add(new Monitor.LogEntry(new Date(), "klaus", "rutracker"));
        logs.add(new Monitor.LogEntry(new Date(), "shiva", "pornolab"));
        logs.add(new Monitor.LogEntry(new Date(), "shiva", "pornolab"));
        logs.add(new Monitor.LogEntry(new Date(), "jack", "championat"));
        logs.add(new Monitor.LogEntry(new Date(), "greta", "rutracker"));
        logs.add(new Monitor.LogEntry(new Date(), "klaus", "rutracker"));
        logs.add(new Monitor.LogEntry(new Date(), "alma", "championat"));
        System.out.println(Monitor.getUrlToNumberOfVisited(logs));
    }
}