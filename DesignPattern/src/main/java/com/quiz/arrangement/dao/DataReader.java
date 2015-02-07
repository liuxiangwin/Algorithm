package com.quiz.arrangement.dao;

import com.quiz.arrangement.exception.DataReaderException;
import com.quiz.arrangement.exception.ResourceNotFoundException;

import java.util.List;

import org.springframework.core.io.Resource;

public interface DataReader {
	public List<String> read(Resource resoure)  throws DataReaderException, ResourceNotFoundException;
}
