package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Video
{
    @Id
    private int videoId;
    private byte[] videoFile;
    private String videoName;
    private String videoDesc;


    public int getVideoId()
    {
        return videoId;
    }

    public String getVideoName()
    {
        return videoName;
    }

    public String getVideoDesc()
    {
        return videoDesc;
    }

    public byte[] getVideoFile()
    {
        return videoFile;
    }

    public byte[] getVideo()
    {
        return videoFile;
    }
}
