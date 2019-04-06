package controllers;

import models.Blog;
import models.Diet;
import models.Podcast;
import models.Video;
import play.Logger;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class HomePageController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    HomePageController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }


    @Transactional(readOnly = true)
    public Result getHomePage()
    {
        TypedQuery<Blog> query = db.em().createQuery("SELECT b FROM Blog b ORDER BY blogId DESC", Blog.class).setMaxResults(1);
        List<Blog> blogs = query.getResultList();

        Blog blog = blogs.get(0);


        TypedQuery<Diet> dietquery = db.em().createQuery("SELECT d FROM Diet d ORDER BY prepId DESC", Diet.class).setMaxResults(1);
        List<Diet> diets = dietquery.getResultList();

        Diet diet = diets.get(0);


        TypedQuery<Video> videoquery = db.em().createQuery("SELECT v FROM Video v ORDER BY videoId DESC", Video.class).setMaxResults(1);
        List<Video> videos = videoquery.getResultList();

        Video video = videos.get(0);


        TypedQuery<Podcast> podcastquery = db.em().createQuery("SELECT p FROM Podcast p ORDER BY podCastId DESC", Podcast.class).setMaxResults(1);
        List<Podcast> podcasts = podcastquery.getResultList();

       Podcast podcast = podcasts.get(0);


        return ok(views.html.homepage.render(blog, diet, video, podcast));
    }

    //  Methods to return video
    @Transactional(readOnly = true)
    public Result getVideo(int videoId)
    {
        String sql = "SELECT v FROM Video v WHERE videoId = :videoId";

        TypedQuery<Video> query = db.em().createQuery(sql, Video.class);
        query.setParameter("videoId", videoId);

        Video video = query.getSingleResult();

        return ok(video.getVideo());
    }

    @Transactional(readOnly = true)
    public Result getVideoList()
    {
        TypedQuery<Video> query = db.em().createQuery("SELECT v FROM Video v ORDER BY videoId", Video.class);
        List<Video> videos = query.getResultList();

        return ok(views.html.videolist.render(videos));
    }

    //  Methods to return podcast
    @Transactional(readOnly = true)
    public Result getPodcast(int podCastId)
    {
        String sql = "SELECT p FROM Podcast p WHERE podCastId = :podCastId";

        TypedQuery<Podcast> query = db.em().createQuery(sql, Podcast.class);
        query.setParameter("podCastId", podCastId);

        Podcast podcast = query.getSingleResult();

        return ok(podcast.getPodcast());
    }

    @Transactional(readOnly = true)
    public Result getPodcastList()
    {
        TypedQuery<Podcast> query = db.em().createQuery("SELECT p FROM Podcast p ORDER BY podcastId", Podcast.class);
        List<Podcast> podcasts = query.getResultList();

        return ok(views.html.podcastlist.render(podcasts));
    }


}










