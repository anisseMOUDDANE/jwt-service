package com.example.usersmicroservice.security;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public interface SecParams {
    ZonedDateTime expirationDate = ZonedDateTime.of(2023, 12, 12, 0, 0, 0, 0, ZoneOffset.UTC);
    ZonedDateTime epochStart = ZonedDateTime.of(1970, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    long EXP_TIME = ChronoUnit.MILLIS.between(epochStart, expirationDate); // calculate milliseconds between epoch start and 12/12/2023
    String SECRET = "murphy@yahoo.com";
}
