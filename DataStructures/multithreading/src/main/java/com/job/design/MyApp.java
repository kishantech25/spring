package com.job.design;

import java.time.Instant;
import java.util.UUID;

public class MyApp extends Object{

    private final UUID id;
    private final Instant createdAt;

    protected MyApp() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
    }

}
