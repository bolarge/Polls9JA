package com.corespecs.polls9ja.respository.springdatajpa;

import com.corespecs.polls9ja.domain.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long> {

}

