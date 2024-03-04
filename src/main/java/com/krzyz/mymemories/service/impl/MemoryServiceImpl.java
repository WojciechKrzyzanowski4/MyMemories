package com.krzyz.mymemories.service.impl;

import com.krzyz.mymemories.dto.MemoryDto;
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
    public void saveMemory(MemoryDto memory) {

        memoryRepository.save(mapToMemory(memory));
    }

    @Override
    public Memory findMemoryById(Long id) {
       return memoryRepository.findById(id)
               .orElseThrow(() -> new MemoryNotFoundException("fucking idiota"));
    }

    @Override
    public Memory mapToMemory(MemoryDto memoryDto){
        Memory memory = new Memory();
        memory.setId(memoryDto.getId());
        memory.setText(memoryDto.getText());
        memory.setImagePath(memoryDto.getImagePath());
        return memory;
    }
}
