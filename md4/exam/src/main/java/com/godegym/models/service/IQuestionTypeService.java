package com.godegym.models.service;

import com.godegym.models.entity.QuestionType;

import java.util.List;

public interface IQuestionTypeService {
    List<QuestionType> findAll();
}
