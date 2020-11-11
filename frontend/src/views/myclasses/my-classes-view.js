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

        .section-title {
          margin-right: 70px;
        };
      </style>
      <vaadin-split-layout>

        <vaadin-split-layout orientation="vertical" style="max-width: 35%;">
            <div style="height: 40vh;">
                <vaadin-vertical-layout style="margin: 70px 70px;">
                    <vaadin-horizontal-layout>
                        <div class="section-title"><h2>Class List</h2></div>
                        <div><h2>+</h2></div>
                    </vaadin-horizontal-layout>
                    <vaadin-item>
                        Intro to Java
                    </vaadin-item>
                    <vaadin-item>
                        Web-Apps in React
                    </vaadin-item>
                    <vaadin-item>
                        React Native
                    </vaadin-item>
                    <vaadin-item>
                        Python Web-Apps
                    </vaadin-item>
                </vaadin-vertical-layout>
            </div>

            <div style="height: 60vh;">
                <vaadin-vertical-layout style="margin: 70px 70px;">
                    <vaadin-horizontal-layout>
                        <div class="section-title"><h2>Student List</h2></div>
                        <div><h2>+</h2></div>
                    </vaadin-horizontal-layout>
                    <vaadin-item>
                        Intro to Java
                    </vaadin-item>
                    <vaadin-item>
                        Web-Apps in React
                    </vaadin-item>
                    <vaadin-item>
                        React Native
                    </vaadin-item>
                    <vaadin-item>
                        Python Web-Apps
                    </vaadin-item>
                </vaadin-vertical-layout>
            </div>
        </vaadin-split-layout>

        <vaadin-split-layout orientation="vertical" style="max-width: 70%;">
            <div style="height: 40vh;">
                <vaadin-vertical-layout style="margin: 70px 70px;">
                    <vaadin-horizontal-layout>
                        <div class="section-title"><h2>Assignment List</h2></div>
                        <div><h2>+</h2></div>
                    </vaadin-horizontal-layout>
                    <vaadin-item>
                        Intro to Java
                    </vaadin-item>
                    <vaadin-item>
                        Web-Apps in React
                    </vaadin-item>
                    <vaadin-item>
                        React Native
                    </vaadin-item>
                    <vaadin-item>
                        Python Web-Apps
                    </vaadin-item>
                </vaadin-vertical-layout>
            </div>

            <div style="height: 60vh;">
                <vaadin-vertical-layout style="margin: 70px 70px;">
                    <vaadin-horizontal-layout>
                        <div class="section-title"><h2>Student Stats</h2></div>
                        <div><h2>Grade</h2></div>
                    </vaadin-horizontal-layout>
                    <vaadin-item>
                        Intro to Java
                    </vaadin-item>
                    <vaadin-item>
                        Web-Apps in React
                    </vaadin-item>
                    <vaadin-item>
                        React Native
                    </vaadin-item>
                    <vaadin-item>
                        Python Web-Apps
                    </vaadin-item>
                </vaadin-vertical-layout>
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
