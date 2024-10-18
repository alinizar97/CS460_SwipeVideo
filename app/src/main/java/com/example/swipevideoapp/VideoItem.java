package com.example.swipevideoapp;

/**
 * The VideoItem class represents a single video item with a title, description, and video URL.
 * This class is used to store and retrieve information about each video in the Swipe Video App.
 */
public class VideoItem {

    private String title, description, videoUrl;

    /**
     * Constructor to create a new VideoItem object.
     *
     * @param title The title of the video.
     * @param description A brief description of the video.
     * @param videoUrl The URL of the video file.
     */
    public VideoItem(String title, String description, String videoUrl) {
        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
    }

    /**
     * Gets the title of the video.
     *
     * @return The title of the video.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the description of the video.
     *
     * @return The description of the video.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the URL of the video file.
     *
     * @return The URL of the video file.
     */
    public String getVideoUrl() {
        return videoUrl;
    }
}
