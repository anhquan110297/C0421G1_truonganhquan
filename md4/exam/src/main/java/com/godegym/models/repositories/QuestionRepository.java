package com.godegym.models.repositories;

import com.godegym.models.entity.Question;
import com.godegym.models.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
//    Page<Question> findAllByNameContaining (String name, Pageable page);
    Page<Question> findAllByTitleAndQuestionTypeContaining(String title, QuestionType questionType, Pageable pageable);
    Page<Question> findAllByTitleContaining (String title,Pageable page);
}
