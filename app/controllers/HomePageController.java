package controllers;

import models.Blog;
import models.Podcast;
import models.Video;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
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

    public Result getHomePage()
    {
        return ok(views.html.homepage.render());
    }

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

    //  Methods to return podcast list
    @Transactional(readOnly = true)
    public Result getPodcast(int podcastId)
    {
        String sql = "SELECT p FROM Podcast p WHERE podcastId = :podcastId";

        TypedQuery<Podcast> query = db.em().createQuery(sql, Podcast.class);
        query.setParameter("podcastId", podcastId);

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










