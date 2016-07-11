package epicodus.com.discussit.models;

import org.parceler.Parcel;

@Parcel
public class Post {
    String content;
    String timeStamp;
    int score;

    public Post(){
        //FIREBASE
    }

    public Post(String content, String timeStamp, int score){
        this.content = content;
        this.timeStamp = timeStamp;
        this.score = score;
    }

    public String getContent(){return content;}
    public String getTimeStamp(){return timeStamp;}
    public int getScrore(){return score;}

    public void setContent(String content){
        this.content = content;
    }
    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }
    public void setScore(int score){
        this.score = score;
    }

}
