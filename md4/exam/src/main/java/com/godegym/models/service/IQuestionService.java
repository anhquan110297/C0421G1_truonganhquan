package com.godegym.models.service;

import com.godegym.models.entity.Question;
import com.godegym.models.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService {
    Page<Question> findAll (Pageable pageable);
    void save (Question question);
    void delete (Question question);
    public Question findById(Integer id);
    Page<Question> findAllByTitleAndQuestionTypeContaining (String title, QuestionType questionType,Pageable pageable);
    Page<Question> findAllByTitleContaining (String title,Pageable page);
}
