package com.jrram.application.views.myclasses;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.jrram.application.views.myclasses.MyClassesView.MyClassesViewModel;
import com.jrram.application.views.main.MainView;

@Route(value = "classes", layout = MainView.class)
@PageTitle("My Classes")
@JsModule("./src/views/myclasses/my-classes-view.js")
@Tag("my-classes-view")
public class MyClassesView extends PolymerTemplate<MyClassesViewModel> {

    // This is the Java companion file of a design
    // You can find the design file in /frontend/src/views/src/views/myclasses/my-classes-view.js
    // The design can be easily edited by using Vaadin Designer (vaadin.com/designer)

    public static interface MyClassesViewModel extends TemplateModel {
    }

    public MyClassesView() {
    }
}
