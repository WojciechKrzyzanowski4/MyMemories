package com.krzyz.mymemories.repository;

import com.krzyz.mymemories.model.Memory;
import org.springframework.data.repository.CrudRepository;

public interface MemoryRepository extends CrudRepository<Memory, Long> {


}
