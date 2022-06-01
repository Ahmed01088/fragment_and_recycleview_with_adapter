package com.example.faceapp.Model;

public class ModelStory {
    private String name;
    private String pic;
    private String bgPic;
    private boolean online;

    public String getBgPic() {
        return bgPic;
    }

    public void setBgPic(String bgPic) {
        this.bgPic = bgPic;
    }

    public ModelStory(String name, String pic, boolean online, String bgPic) {
        this.name = name;
        this.pic = pic;
        this.online = online;
        this.bgPic=bgPic;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
