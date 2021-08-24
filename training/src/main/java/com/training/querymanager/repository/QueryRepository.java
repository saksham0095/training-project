package com.training.querymanager.repository;

import com.training.querymanager.pojo.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends CrudRepository<Query,Long> {
}
