package com.jrram.application.views.dashboard;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.jrram.application.views.dashboard.DashboardView.DashboardViewModel;
import com.jrram.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "dashboard", layout = MainView.class)
@PageTitle("Dashboard")
@JsModule("./src/views/dashboard/dashboard-view.js")
@Tag("dashboard-view")
@RouteAlias(value = "", layout = MainView.class)
public class DashboardView extends PolymerTemplate<DashboardViewModel> {

    // This is the Java companion file of a design
    // You can find the design file in /frontend/src/views/src/views/dashboard/dashboard-view.js
    // The design can be easily edited by using Vaadin Designer (vaadin.com/designer)

    public static interface DashboardViewModel extends TemplateModel {
    }

    public DashboardView() {
    }
}
