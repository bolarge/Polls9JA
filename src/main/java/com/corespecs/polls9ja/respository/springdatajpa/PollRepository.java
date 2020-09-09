package com.corespecs.polls9ja.respository.springdatajpa;

import com.corespecs.polls9ja.domain.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PollRepository extends PagingAndSortingRepository<Poll, Long> {

}

