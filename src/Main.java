import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album>albums=new ArrayList<>();
        Album album1 = new Album("SMW","sidhu moosewala");
        album1.addSongtoAlbum("295",5.0);
        album1.addSongtoAlbum("SO High",4.20);
        album1.addSongtoAlbum("LastRise",4.50);

        Album album2 = new Album("sad songs","Arijit Singh");
        album2.addSongtoAlbum("kesariya",4.23);
        album2.addSongtoAlbum("Jeena Jeena",4.34);
        album2.addSongtoAlbum("Gerua",5.10);

        albums.add(album1);
        albums.add(album2);
//change
        System.out.println(album1.findSong("295"));

        LinkedList<Song> myPlaylist = new LinkedList<>();
        album1.addSongtoPlaylistFromAlbum("295",myPlaylist);
        album2.addSongtoPlaylistFromAlbum(2,myPlaylist);
        album2.addSongtoPlaylistFromAlbum("Gerua",myPlaylist);
        album2.addSongtoPlaylistFromAlbum(2,myPlaylist);

        play(myPlaylist);

    }
    public static void play(LinkedList<Song> playlist){

        ListIterator<Song> itr = playlist.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean isForward = false;
        if(playlist.size()>0){
            System.out.println("Currently playing : ");
            System.out.println(itr.next());
            isForward = true;
        }
        else{
            System.out.println("playlist is empty");
            return;
        }
        System.out.println("Enter your choice : ");

        boolean quit = false;
        while(!quit){
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                    System.out.println(itr.next());
                }else{
                    System.out.println("you have reached end of playlist");
                    isForward = false;
                }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                    System.out.println(itr.previous());
                }
                else{
                    System.out.println("you are at first song");
                    isForward = true;
                }
                    break;
                case 3:
                    if(isForward==true){
                        System.out.println(itr.previous());
                        isForward=false;
                    }
                    else{
                        System.out.println(itr.next());
                        isForward=true;
                    }
                    break;
                case 4: printmenu();
                    break;
                case 5:
                    break;
                case 6:printsongs(playlist);
                    break;
                case 7: quit =true;
                break;
                default:
                    System.out.println("invalid choice");
                    break;

            }
        }

    }
    public static void printsongs(LinkedList<Song> playlist){
        for(Song song: playlist){
            System.out.println(song);
        }
        return;
    }

    public static void printmenu(){
        System.out.println("1 - play next song");
        System.out.println("2 - play previous song");
        System.out.println("3 - repeat current song");
        System.out.println("4 - show menu again");
        System.out.println("5 - delete current song");
        System.out.println("6 - print all songs in playlist");
        System.out.println("7 - EXIT");

        return;
    }

}