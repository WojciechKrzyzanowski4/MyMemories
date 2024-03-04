package com.krzyz.mymemories.service;

import com.krzyz.mymemories.model.Memory;

public interface MemoryService {

    void saveMemory(Memory memory);

    Memory findMemoryById(Long id);

}
