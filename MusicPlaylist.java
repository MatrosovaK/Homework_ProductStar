package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MusicPlaylist {

    private List<String> playlist = new ArrayList<>();
    public static void main(String[] args){
        MusicPlaylist songs = new MusicPlaylist();

        songs.removeSong(2);
        songs.shuffle();

        songs.addSong("Song 1");
        songs.addSong("Song 2");
        songs.addSong("Song 3");
        songs.addSong("Song 4");
        songs.addSong("Song 5");
        songs.addSong("Song 6");
        System.out.println(songs.playlist);

        songs.removeSong(2);
        System.out.println(songs.playlist);

        songs.moveSong(0, 3);
        System.out.println(songs.playlist);

        songs.shuffle();
        System.out.println(songs.playlist);


    }

    public void addSong(String title){
        playlist.add(title);
    }

    public void removeSong(int index) {
        if (index >= 0 && index < playlist.size()) {
            playlist.remove(index);
        } else {
            System.out.println("нет песни с таким индексом");
        }
    }

    public void moveSong(int from, int to){
        if (from >= 0 && from < playlist.size() && to >= 0 && to < playlist.size()){
            String songFrom = playlist.remove(from);
            playlist.add(to, songFrom);

        }
    }
    public void shuffle(){

        if (playlist.size() > 0) {
            Random random = new Random();
            for (int i = playlist.size()-1; i > 0; i--){
                int indexRandom = random.nextInt(i+1);
                moveSong(i,indexRandom);
            }
        } else{
            System.out.println("список песен слишком мал");
        }

    }



}
