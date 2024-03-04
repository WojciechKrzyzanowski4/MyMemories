package com.krzyz.mymemories.dto;

public class MemoryDto {

    private Long id;
    private String text;
    private String imagePath;

    public MemoryDto(Long id, String text, String imageUrl) {
        this.id = id;
        this.text = text;
        this.imagePath = imageUrl;
    }

    public MemoryDto() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imageUrl) {
        this.imagePath = imageUrl;
    }
}

