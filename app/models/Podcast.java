package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Podcast
{
    @Id
    private int podcastId;
    private byte[] podcastFile;

    public int getPodcastId()
    {
        return podcastId;
    }

    public byte[] getPodcast()
    {
        return podcastFile;
    }
}