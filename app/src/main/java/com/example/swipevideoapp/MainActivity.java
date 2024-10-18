package com.example.swipevideoapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

/**
 * The MainActivity class is the entry point of the Swipe Video App.
 * It initializes the video list and sets up the ViewPager2 to allow users to swipe through videos.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is starting. This is where most initialization occurs.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewPager2 to enable swiping between video items
        ViewPager2 videosViewPager = findViewById(R.id.videosViewPager);

        // Create a list of VideoItem objects containing video details
        List<VideoItem> videoItems = new ArrayList<>();

        // Add video items to the list with title, description, and video URL
        videoItems.add(new VideoItem("Funny 1", "This is the first funny video",
                "https://firebasestorage.googleapis.com/v0/b/swipevideoapp-4cb86.appspot.com/o/videos%2Fssstik.io_@areyoukiddingtv_1729229842759.mp4?alt=media"));
        videoItems.add(new VideoItem("Funny 2", "This is the second funny video",
                "https://firebasestorage.googleapis.com/v0/b/swipevideoapp-4cb86.appspot.com/o/videos%2Fssstik.io_@joshnasar_1729232358961.mp4?alt=media"));
        videoItems.add(new VideoItem("Funny 3", "This is the third funny video",
                "https://firebasestorage.googleapis.com/v0/b/swipevideoapp-4cb86.appspot.com/o/videos%2Fssstik.io_@pokemyheart_1729234279893.mp4?alt=media"));

        // Set the adapter for ViewPager2 to display video items
        videosViewPager.setAdapter(new VideoAdapter(videoItems));
    }
}

