package com.example.swipevideoapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * The VideoAdapter class is a RecyclerView Adapter that binds video data to each ViewPager2 item.
 * It is responsible for creating and binding video items, as well as handling video playback logic.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<VideoItem> videoItems;

    /**
     * Constructor for the VideoAdapter.
     *
     * @param videoItems A list of VideoItem objects that contain the data for each video.
     */
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    /**
     * Inflates the layout for each video item in the ViewPager2.
     *
     * @param parent The ViewGroup into which the new View will be added.
     * @param viewType The view type of the new View.
     * @return A new instance of VideoViewHolder.
     */
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false);
        return new VideoViewHolder(view);
    }

    /**
     * Binds the video data to the ViewHolder.
     *
     * @param holder The VideoViewHolder that should be updated.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    /**
     * Returns the total number of video items in the list.
     *
     * @return The number of video items.
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    /**
     * The VideoViewHolder class holds the views for each video item.
     */
    class VideoViewHolder extends RecyclerView.ViewHolder {

        private VideoView videoView;
        private TextView videoTitle, videoDescription;

        /**
         * Constructor for the VideoViewHolder.
         *
         * @param itemView The view that holds the video item components.
         */
        VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            videoTitle = itemView.findViewById(R.id.videoTitle);
            videoDescription = itemView.findViewById(R.id.videoDescription);
        }

        /**
         * Binds the data from a VideoItem object to the views (title, description, and video).
         *
         * @param videoItem The VideoItem object that contains the video details.
         */
        void setVideoData(VideoItem videoItem) {
            videoTitle.setText(videoItem.getTitle());
            videoDescription.setText(videoItem.getDescription());

            // Set up VideoView with the video URL
            Uri videoUri = Uri.parse(videoItem.getVideoUrl());
            videoView.setVideoURI(videoUri);

            // Auto-start video when prepared
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    videoView.start();  // Auto-start the video
                }
            });

            // Toggle play/pause on video click
            videoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (videoView.isPlaying()) {
                        videoView.pause();  // Pause video if playing
                    } else {
                        videoView.start();  // Start video if paused
                    }
                }
            });
        }
    }
}
