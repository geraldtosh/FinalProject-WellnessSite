package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PrepId;
    private byte[] picture;

    private String PrepName;
    private String PrepDesc;
    private String PrepBody;

    public int getPrepId()
    {
        return PrepId;
    }

    public String getDietName()
    {
        return PrepName;
    }

    public String getDietDesc()
    {
        return PrepDesc;
    }

    public String getDietBody()
    {
        return PrepBody;
    }

    public byte[] getPicture()
    {
        return picture;
    }

    public void setDietName(String PrepName)
    {
       this.PrepName = PrepName;
    }

    public void setDietDesc(String PrepDesc)
    {
        this.PrepDesc = PrepDesc;
    }

    public void setDietBody(String PrepBody)
    {
        this.PrepBody = PrepBody;
    }

    public void setPicture(byte[] picture)
    {
        this.picture = picture;
    }
}
