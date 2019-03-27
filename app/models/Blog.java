package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BlogId;

    private String BlogName;
    private String BlogDesc;
    private String BlogBody;

    public int getBlogId()
    {
        return BlogId;
    }

    public String getBlogName()
    {
        return BlogName;
    }

    public String getBlogDesc()
    {
        return BlogDesc;
    }

    public String getBlogBody()
    {
        return BlogBody;
    }

    public void setBlogName(String blogName)
    {
        BlogName = blogName;
    }

    public void setBlogDesc(String blogDesc)
    {
        BlogDesc = blogDesc;
    }

    public void setBlogBody(String blogBody)
    {
        BlogBody = blogBody;
    }
}
