package com.krzyz.mymemories.service;

import com.krzyz.mymemories.dto.MemoryDto;
import com.krzyz.mymemories.model.Memory;

public interface MemoryService {

    void saveMemory(MemoryDto memory);

    Memory findMemoryById(Long id);

    Memory mapToMemory(MemoryDto memoryDto);

}
