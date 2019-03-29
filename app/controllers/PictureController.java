package controllers;

import models.Blog;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.sql.Blob;

public class PictureController extends Controller
{
    private JPAApi db;
    private FormFactory formFactory;

    Blob PictureId;



}