package com.google;

import java.util.*;
import java.util.stream.Collectors;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private List<Video> list;
  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  private String getVideoStrings(Video video){
    String tag = String.join(" ", video.getTags());  //separate the tags;
    return video.getTitle() + " (" + video.getVideoId() + ") [" + tag + "]"; //return the title, id and the tags of the video
  }

  public void showAllVideos() {
    List<Video> list = videoLibrary.getVideos();
    System.out.println("Here's a list of all available videos:");

    list.sort(Comparator.comparing(Video::getTitle)); //sort the videos lexicographical

    for (Video video : list){
      System.out.println("\t" + getVideoStrings(video));
    }//print the list with the videos
  }

  private String currentvideo = null; //keeping the current video

  public ArrayList<String> array;

  public void playVideo(String videoId) {
    ArrayList<String> array = new ArrayList<String>(); //array of videos
    if(videoLibrary.getVideo(videoId) != null) //check if the video exists
    {
      if (array.size() > 0) {
        System.out.println("Stopping video: " + array.get(0)); //stopping the video
        array.remove(0);
        array.add(videoLibrary.getVideo(videoId).getTitle());
      } else {
        array.add(videoLibrary.getVideo(videoId).getTitle());
        System.out.println("Playing video: " + videoLibrary.getVideo(videoId).getTitle()); //playing the video
      }
      currentvideo = videoLibrary.getVideo(videoId).getVideoId(); //variable for keeping the current video
    }
    else {
        System.out.println("Cannot play video: Video does not exist"); //video doesn't exist.
    }
  }

  public void stopVideo() {
    if(currentvideo != null){ //check if the currentvideo is playing.
      System.out.println("Stopping video: " + videoLibrary.getVideo(currentvideo).getTitle()); //if it's playing, stop the video
      currentvideo = null; //no video is playing.
    } else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    var vids = videoLibrary.getVideos(); //list of the all videos
    ArrayList <String> id = new ArrayList<String>(); //list of the videos id

    for (Video vid : vids){
      id.add(((Video)vid).getVideoId()); //adding all the videos id to the list
    }

    Random random = new Random();
    String randomElement = id.get((random.nextInt(id.size()))); //get a random video from the list
    playVideo(randomElement); //play the random video
  }

boolean ok = false; //variable to check if the video is already on pause.
  public void pauseVideo() {
    if(currentvideo != null){//check if the currentvideo is playing.
      if(!ok){ //check if the video wasn't paused.
        ok = true;
        System.out.println("Pausing video: " + videoLibrary.getVideo(currentvideo).getTitle()); //paused the video.
      } else if (ok){//chek if the video is already paused.
        System.out.println("Video already paused: " + videoLibrary.getVideo(currentvideo).getTitle());
      }
    }else{//check if no current video is playing
      System.out.println("Cannot pause video: No video is currently playing");
    }
  }

  public void continueVideo() {
    if(currentvideo != null){//check if the currentvideo is playing.
      if(ok){//check if the currentvideo is playing.
        System.out.println("Continuing video: " + videoLibrary.getVideo(currentvideo).getTitle()); //continue the video
        ok = false;
      } else if(!ok){ //Check if the video is paused
        System.out.println("Cannot continue video: Video is not paused");
      }

    } else{//check if no current video is playing
      System.out.println("Cannot continue video: No video is currently playing");
    }
  }

  public void showPlaying() {
    if(currentvideo != null){//check if the currentvideo is playing.
      String okStatus; //ststus of the video
      if(ok){ //check if the video is paused
        okStatus = " - PAUSED";
      } else{
        okStatus = "";
      }
      System.out.println("Currently playing: " + videoLibrary.getVideo(currentvideo).getTitle() + " (" + videoLibrary.getVideo(currentvideo).getVideoId() + ") [" + videoLibrary.getVideo(currentvideo).getTags().stream().collect(Collectors.joining(" ")) + "]"+ okStatus);
      //displays the current video with the title, id, tags, and current status.
    } else{ //check if no video is playing
      System.out.print("No video is currently playing");
    }
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}