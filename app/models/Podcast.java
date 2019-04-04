package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Podcast
{
    @Id
    private int podcastId;

    private String podName;
    private String podDesc;
    private byte[] podFile;

    public int getPodcastId()
    {
        return podcastId;
    }

    public String getPodcastName()
    {
        return podName;
    }

    public String getPodcastDesc()
    {
        return podDesc;
    }

    public byte[] getPodFile()
    {
        return podFile;
    }

    public byte[] getPodcast()
    {
        return podFile;
    }









}