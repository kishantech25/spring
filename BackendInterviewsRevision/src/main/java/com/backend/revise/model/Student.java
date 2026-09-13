package com.backend.revise.model;

import java.util.List;

public record Student(
        int studentId,
        String name,
        List<String> subjects
) {

  }
