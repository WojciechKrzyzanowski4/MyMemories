package com.krzyz.mymemories.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private String imagePath;

    public Memory(Long id, String text, String imageUrl) {
        this.id = id;
        this.text = text;
        this.imagePath = imageUrl;
    }

    public Memory() {

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
