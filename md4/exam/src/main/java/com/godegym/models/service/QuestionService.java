package com.godegym.models.service;

import com.godegym.models.entity.Question;
import com.godegym.models.entity.QuestionType;
import com.godegym.models.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public void save(Question question) {
        this.questionRepository.save(question);
    }

    @Override
    public void delete(Question question) {
        this.questionRepository.delete(question);
    }

    @Override
    public Question findById(Integer id) {
        return this.questionRepository.findById(id).get();
    }

    @Override
    public Page<Question> findAllByTitleAndQuestionTypeContaining(String title, QuestionType questionType, Pageable pageable) {
        return this.questionRepository.findAllByTitleAndQuestionTypeContaining(title,questionType,pageable);
    }

    @Override
    public Page<Question> findAllByTitleContaining(String title, Pageable page) {
        return this.findAllByTitleContaining(title,page);
    }
}
