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
    private int prepId;
    private byte[] picture;

    private String prepName;
    private String prepDesc;
    private String prepBody;

    public int getPrepId()
    {
        return prepId;
    }

    public String getDietName()
    {
        return prepName;
    }

    public String getDietDesc()
    {
        return prepDesc;
    }

    public String getDietBody()
    {
        return prepBody;
    }

    public byte[] getPicture()
    {
        return picture;
    }

    public void setDietName(String prepName)
    {
       prepName = prepName;
    }

    public void setDietDesc(String prepDesc)
    {
        prepDesc = prepDesc;
    }

    public void setDietBody(String prepBody)
    {
        prepBody = prepBody;
    }

    public void setPicture(byte[] picture)
    {
        this.picture = picture;
    }
}
