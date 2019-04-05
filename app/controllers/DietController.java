package controllers;
import models.Diet;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

public class DietController extends Controller

{
    private JPAApi db;
    private FormFactory formFactory;

    @Inject
    DietController(JPAApi db, FormFactory formFactory)
    {
        this.db = db;
        this.formFactory = formFactory;
    }

    @Transactional
    public Result getDiet(int prepId)
    {
        TypedQuery<Diet> query = db.em().createQuery("SELECT d FROM Diet d WHERE prepId = :prepId", Diet.class);
        query.setParameter("prepId",prepId);
        Diet diet = query.getSingleResult();

        return ok(views.html.dietdisplay.render(diet));
    }

    @Transactional(readOnly = true)
    public Result getDietAdd()
    {
        return ok(views.html.dietadd.render());
    }

    @Transactional
    public Result postDietAdd()
    {
        Diet diet = new Diet();

        DynamicForm form = formFactory.form().bindFromRequest();

        String prepname = form.get("prepname");
        String prepdesc = form.get("prepdesc");
        String prepbody = form.get("prepbody");

        diet.setDietName(prepname);
        diet.setDietDesc(prepdesc);
        diet.setDietBody(prepbody);

        db.em().persist(diet);

        return ok(views.html.dietadd.render());
    }

    @Transactional(readOnly = true)
    public Result getDietList()
    {
        TypedQuery<Diet> listQuery = db.em().createQuery("SELECT d FROM Diet d ORDER BY prepId", Diet.class);
        List<Diet> diet= listQuery.getResultList();

        return ok(views.html.dietlist.render(diet));
    }

    @Transactional
    public Result getDietEdit(int prepId)
    {
        TypedQuery<Diet> query = db.em().createQuery("SELECT d FROM Diet d WHERE prepId = :prepId", Diet.class);
        query.setParameter("prepId", prepId);
        Diet diet = query.getSingleResult();

        return ok(views.html.dietedit.render(diet));
    }

    @Transactional
    public Result postDietEdit(int prepId)
    {
        TypedQuery<Diet> editQuery = db.em().createQuery("SELECT d FROM Diet d WHERE prepId = :prepId",Diet.class);
        editQuery.setParameter("prepId", prepId);
        Diet diet = editQuery.getSingleResult();

        DynamicForm form = formFactory.form().bindFromRequest();

        String prepName = form.get("prepname");
        String prepDesc = form.get("prepdesc");
        String prepBody = form.get("prepbody");

        diet.setDietName(prepName);
        diet.setDietDesc(prepDesc);
        diet.setDietBody(prepBody);

        return ok(views.html.dietedit.render(diet));
    }

    @Transactional
    public Result postDietDelete(int prepId)
    {
        TypedQuery<Diet> editQuery = db.em().createQuery("SELECT d FROM Diet d WHERE prepId = :prepId", Diet.class);
        editQuery.setParameter("prepId", prepId);
        Diet diet = editQuery.getSingleResult();
        db.em().remove(diet);

        return ok("DELETED");
    }

    @Transactional
    public Result getPicture(int prepId)
    {
        TypedQuery<Diet> query = db.em().createQuery("SELECT d FROM Diet d WHERE prepId = :prepId", Diet.class);
        query.setParameter("prepId", prepId);
        Diet diet = query.getSingleResult();

        return ok(diet.getPicture());
    }
}