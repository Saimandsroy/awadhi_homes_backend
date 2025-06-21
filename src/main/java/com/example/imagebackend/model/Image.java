package com.example.imagebackend.model;

import java.util.Date;

public class Image {
    private String id;
    private String title;
    private String description;
    private Date uploadDate;
    private String analysisType;
    private String data; // Base64 encoded string

    public Image() {}

    public Image(String title, String description, Date uploadDate, String analysisType, String data) {
        this.title = title;
        this.description = description;
        this.uploadDate = uploadDate;
        this.analysisType = analysisType;
        this.data = data;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getUploadDate() { return uploadDate; }
    public void setUploadDate(Date uploadDate) { this.uploadDate = uploadDate; }
    public String getAnalysisType() { return analysisType; }
    public void setAnalysisType(String analysisType) { this.analysisType = analysisType; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}