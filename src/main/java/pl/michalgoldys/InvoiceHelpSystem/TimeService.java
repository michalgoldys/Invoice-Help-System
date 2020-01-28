package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService implements TimeInterface {
    @Override
    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(formatter);
    }
}
