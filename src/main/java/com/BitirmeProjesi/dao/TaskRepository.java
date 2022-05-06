package com.BitirmeProjesi.dao;

import com.BitirmeProjesi.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Query(value = "SELECT T FROM Task T WHERE T.isDeleted = false")
    Iterable<Task> findNotDeleted();

}
