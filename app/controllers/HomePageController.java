package controllers;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.Controller;
import javax.inject.Inject;

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
}














