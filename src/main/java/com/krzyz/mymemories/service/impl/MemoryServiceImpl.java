package com.krzyz.mymemories.service.impl;

import com.krzyz.mymemories.exception.MemoryNotFoundException;
import com.krzyz.mymemories.model.Memory;
import com.krzyz.mymemories.repository.MemoryRepository;
import com.krzyz.mymemories.service.MemoryService;
import org.springframework.stereotype.Service;

@Service
public class MemoryServiceImpl implements MemoryService {

    private MemoryRepository memoryRepository;


    public MemoryServiceImpl(MemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    @Override
    public void saveMemory(Memory memory) {
        memoryRepository.save(memory);
    }

    @Override
    public Memory findMemoryById(Long id) {
       return memoryRepository.findById(id)
               .orElseThrow(() -> new MemoryNotFoundException("fucking idiota"));
    }
}
