package com.godegym.models.service;

import com.godegym.models.entity.QuestionType;
import com.godegym.models.repositories.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return this.questionTypeRepository.findAll();
    }
}
