package com.kishan.model;

import java.util.List;

public record JobPost(int postId,
                      String postProfile,
                      String postDesc,
                      int reqExperience,
                      List<String> postTechStack) {
}
