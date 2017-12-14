import java.util.ArrayList;
import java.util.List;

public class VideoManager {

    private List<Video> videos = new ArrayList<Video>();

    public void addVideo(Video v) {
        videos.add(v);
    }

    public List<Video> getVideos() {
        return videos;
    }

    Video findVideo(String videoTitle) {
        Video foundVideo = null ;
        for ( Video video: getVideos() ) {
            // Introduce explaining variable
            boolean isVideoFound = video.getTitle().equals(videoTitle);
            boolean isVideoRented = video.isRented() == false;
            if ( isVideoFound && isVideoRented) {
                foundVideo = video ;
                break ;
            }
        }
        return foundVideo;
    }

    public void addVideo(String title, int videoType, int priceCode) {
        Video v = null;
        if (videoType == 1) {
            v  = new VHSFactory().createVideo(title, priceCode);
        } else if (videoType == 2) {
            v  = new CDFactory().createVideo(title, priceCode);
        } else if (videoType == 3) {
            v  = new DVDFactory().createVideo(title, priceCode);
        } else {
            return;
        }
        addVideo(v);
    }
}
