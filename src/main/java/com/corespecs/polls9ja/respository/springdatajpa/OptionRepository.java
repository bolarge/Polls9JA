package com.corespecs.polls9ja.respository.springdatajpa;

import com.corespecs.polls9ja.domain.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {

}
