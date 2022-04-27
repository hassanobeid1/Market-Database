package gui;

import application.Appli;

public abstract class Controller
{
    private Appli appli;
    public Controller(Appli appli){
        this.appli = appli;
    }

    public Appli getAppli(){
        return appli;
    }
}
