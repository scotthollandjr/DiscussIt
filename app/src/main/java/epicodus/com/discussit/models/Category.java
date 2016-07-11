package epicodus.com.discussit.models;

import org.parceler.Parcel;

@Parcel
public class Category {

    String name;

    public Category(){
        //FOR FIREBASE
    }

    public Category(String name){
        this.name = name;
    }

    //GET
    public String getName(){return name;}


    //SET
    public void setName(String name){this.name =name;}
}
