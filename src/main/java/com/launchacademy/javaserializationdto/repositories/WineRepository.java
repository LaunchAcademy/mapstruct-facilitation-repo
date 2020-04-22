package com.launchacademy.javaserializationdto.repositories;

import com.launchacademy.javaserializationdto.models.Wine;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WineRepository extends PagingAndSortingRepository<Wine, Integer> {

}
