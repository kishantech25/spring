package com.kishan.questionservice.repository;

import com.kishan.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
   List<Question> findByCategory(String category);

    @Query(
            value = """
                SELECT q.id
                FROM question q
                WHERE q.category = :category
                ORDER BY RAND()
                LIMIT :numQ
                """,
            nativeQuery = true
    )
    List<Integer> findRandomQuestionByCategory(
            @Param("category") String category,
            @Param("numQ") int numQ
    );

}
