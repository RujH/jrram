import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';

class MyClassesView extends PolymerElement {
  static get template() {
    return html`
      <style include="shared-styles">
        :host {
          display: block;
        };

        h2 {
        font-size: 20px;
        };

        ul {
          list-style-type: none;

          li {
            padding-bottom: 13px;
          }
        };

        .section-heading {
          display: flex;
          justify-content: center;
          align-items: center;
        };

        .section-title {
          margin-right: 70px;
        };
      </style>
      <vaadin-split-layout>

        <vaadin-split-layout orientation="vertical" style="max-width: 35%;">
            <div style="height: 40vh;">
                <vaadin-vertical-layout style="margin: 70px 70px;">
                    <vaadin-horizontal-layout class="section-heading">
                        <div class="section-title"><h2>Class List</h2></div>
                        <vaadin-button theme="icon" on-click="onAddCourse"><iron-icon icon="vaadin:plus" ></iron-icon></vaadin-button>
                    </vaadin-horizontal-layout>

                    <vaadin-tabs orientation="vertical" theme="minimal" selected="{{selectedCourse}}">
                        <dom-repeat items="[[classes]]">
                            <template>
                                <vaadin-tab>
                                    [[item.name]]
                                </vaadin-tab>
                            </template>
                        </dom-repeat>
                    </vaadin-tabs>
                    <template is="dom-if" if="[[addCoursePressed]]">
                        <vaadin-horizontal-layout>
                            <vaadin-text-field style="margin-left: 6px;" value="{{newCourseInput}}"></vaadin-text-field>
                            <vaadin-button theme="icon" style="margin-left: 5px;" on-click="confirmAddCourse"><iron-icon icon="vaadin:check"></iron-icon>
                        </vaadin-horizontal-layout>
                    </template>

                </vaadin-vertical-layout>
            </div>

            <div style="height: 60vh;">
                <vaadin-vertical-layout style="margin: 70px 70px;">
                    <vaadin-horizontal-layout class="section-heading">
                        <div class="section-title"><h2>Student List</h2></div>
                        <vaadin-button theme="icon" on-click="onAddStudent"><iron-icon icon="vaadin:plus" ></iron-icon></vaadin-button>
                    </vaadin-horizontal-layout>

                    <vaadin-tabs orientation="vertical" theme="minimal" selected="{{selectedStudent}}">
                        <dom-repeat items="[[students]]">
                            <template>
                                <vaadin-tab>
                                    [[item.name]]
                                </vaadin-tab>
                            </template>
                        </dom-repeat>
                    </vaadin-tabs>
                    <template is="dom-if" if="[[addStudentPressed]]">
                        <vaadin-horizontal-layout>
                            <vaadin-text-field style="margin-left: 6px;" value="{{newStudentInput}}"></vaadin-text-field>
                            <vaadin-button theme="icon" style="margin-left: 5px;" on-click="confirmAddStudent"><iron-icon icon="vaadin:check"></iron-icon>
                        </vaadin-horizontal-layout>
                    </template>

                </vaadin-vertical-layout>
            </div>
        </vaadin-split-layout>

        <vaadin-split-layout orientation="vertical" style="max-width: 70%;">
            <div style="height: 40vh;">
                <vaadin-horizontal-layout style="margin: 70px 70px;">
                    <vaadin-vertical-layout class="section-heading">
                        <vaadin-horizontal-layout style="display: flex; justify-content: center; align-items: center;">
                            <div class="section-title"><h2>Assignment List</h2></div>
                            <vaadin-button theme="icon" on-click="onAddAssgn"><iron-icon icon="vaadin:plus"></iron-icon></vaadin-button>
                        </vaadin-horizontal-layout>

                        <dom-repeat items="[[assignments]]">
                            <template>
                                <vaadin-item>
                                    [[item.assgnName]]
                                </vaadin-item>
                            </template>
                        </dom-repeat>

                        <template is="dom-if" if="[[addAssgnPressed]]">
                            <vaadin-horizontal-layout>
                                <vaadin-text-field style="margin-left: 6px;" value="{{newAssgnInput}}"></vaadin-text-field>
                            </vaadin-horizontal-layout>
                        </template>
                    </vaadin-vertical-layout>

                    <vaadin-vertical-layout class="section-heading">
                        <div class="section-title" style="margin-left: 100px;"><h2>Type</h2></div>
                        <dom-repeat items="[[assignments]]">
                            <template>
                                <vaadin-item>
                                    [[item.type]]
                                </vaadin-item>
                            </template>
                        </dom-repeat>

                        <template is="dom-if" if="[[addAssgnPressed]]">
                            <vaadin-horizontal-layout>
                                <vaadin-text-field style="margin-left: 6px;" value="{{newTypeInput}}"></vaadin-text-field>
                            </vaadin-horizontal-layout>
                        </template>
                    </vaadin-vertical-layout>

                    <vaadin-vertical-layout class="section-heading">
                        <div class="section-title"><h2>Weight</h2></div>
                        <dom-repeat items="[[assignments]]">
                            <template>
                                <vaadin-item>
                                    [[item.weight]]
                                </vaadin-item>
                            </template>
                        </dom-repeat>

                        <template is="dom-if" if="[[addAssgnPressed]]">
                            <vaadin-horizontal-layout>
                                <vaadin-text-field style="margin-left: 6px;" value="{{newWeightInput}}"></vaadin-text-field>
                                <vaadin-button theme="icon" style="margin-left: 5px;" on-click="confirmAddAssgn"><iron-icon icon="vaadin:check"></iron-icon>
                            </vaadin-horizontal-layout>
                        </template>
                    </vaadin-vertical-layout>


                </vaadin-horizontal-layout>
            </div>

            <div style="height: 60vh;">
                <vaadin-horizontal-layout style="margin: 70px 70px;">
                    <vaadin-vertical-layout class="section-heading">
                        <vaadin-horizontal-layout style="display: flex; justify-content: center; align-items: center;">
                            <div class="section-title"><h2>Student Stats</h2></div>
                        </vaadin-horizontal-layout>

                        <dom-repeat items="[[studentStats]]">
                            <template>
                                <vaadin-item>
                                    [[item.assgnName]]
                                </vaadin-item>
                            </template>
                        </dom-repeat>
                    </vaadin-vertical-layout>

                    <vaadin-vertical-layout class="section-heading">
                        <div class="section-title" style="margin-left: 100px;"><h2>Grade</h2></div>
                        <dom-repeat items="[[studentStats]]">
                            <template>
                                <vaadin-item>
                                    [[item.grade]]
                                </vaadin-item>
                            </template>
                        </dom-repeat>
                    </vaadin-vertical-layout>

                </vaadin-horizontal-layout>
            </div>
        </vaadin-split-layout>

      </vaadin-split-layout>
    `;
  }

  static get is() {
    return 'my-classes-view';
  }

  static get properties() {
    return {
      // Declare your properties here.
    };
  }
}

customElements.define(MyClassesView.is, MyClassesView);
