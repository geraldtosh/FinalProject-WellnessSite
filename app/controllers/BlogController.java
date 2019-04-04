package controllers;

import models.Blog;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogController extends Controller

{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    BlogController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional
    public Result getBlog(int blogId)
    {
        TypedQuery<Blog> query = db.em().createQuery("SELECT b FROM Blog b WHERE blogId = :blogId", Blog.class);
        query.setParameter("blogId", blogId);
        Blog blog = query.getSingleResult();

        return ok(views.html.blogdisplay.render(blog));
    }

    @Transactional(readOnly = true)
    public Result getBlogAdd()
    {
        return ok(views.html.blogadd.render());
    }

    @Transactional
    public Result postBlogAdd()
    {
        Blog blog = new Blog();

        DynamicForm form = formFactory.form().bindFromRequest();

        String blogname = form.get("blogname");
        String blogdesc = form.get("blogdesc");
        String blogbody = form.get("blogbody");


        blog.setBlogName(blogname);
        blog.setBlogDesc(blogdesc);
        blog.setBlogBody(blogbody);

        db.em().persist(blog);

        return ok(views.html.blogadd.render());
    }

    @Transactional(readOnly = true)
    public Result getBlogList()
    {
        TypedQuery<Blog> query = db.em().createQuery("SELECT b FROM Blog b ORDER BY blogId", Blog.class);
        List<Blog> blogs = query.getResultList();

        return ok(views.html.bloglist.render(blogs));
    }

    @Transactional
    public Result getBlogEdit(int blogId)
    {
        TypedQuery<Blog> query = db.em().createQuery("SELECT b FROM Blog b WHERE blogId = :blogId", Blog.class);
        query.setParameter("blogId", blogId);
        Blog blog = query.getSingleResult();

        return ok(views.html.blogedit.render(blog));
    }

    @Transactional
    public Result postBlogEdit(int blogId)
    {
        TypedQuery<Blog> editQuery = db.em().createQuery("SELECT b FROM Blog b WHERE blogId = :blogId", Blog.class);
        editQuery.setParameter("blogId", blogId);
        Blog blog = editQuery.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();

        String blogName = form.get("blogname");
        String blogDesc = form.get("blogdesc");
        String blogBody = form.get("blogbody");

        blog.setBlogName(blogName);
        blog.setBlogDesc(blogDesc);
        blog.setBlogBody(blogBody);

        return ok(views.html.blogdisplay.render(blog));
    }

    @Transactional
    public Result postBlogDelete(int blogId)
    {
        TypedQuery<Blog> editQuery = db.em().createQuery("SELECT b FROM Blog b WHERE blogId = :blogId", Blog.class);
        editQuery.setParameter("blogId", blogId);
        Blog blog = editQuery.getSingleResult();
        db.em().remove(blog);

        return ok("DELETED");
    }

    @Transactional
    public Result getBlogPicture(int blogId)
    {
        TypedQuery<Blog> query = db.em().createQuery("SELECT b FROM Blog b WHERE blogId = :blogId", Blog.class);
        query.setParameter("blogId", blogId);
        Blog blog = query.getSingleResult();

        return ok(blog.getPicture());
    }
}




