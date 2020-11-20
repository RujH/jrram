import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';

class DashboardView extends PolymerElement {
  static get template() {
    return html`
      <style include="shared-styles">
        :host {
          display: block;
        }
      </style>

      <br />
      Content placeholder
    `;
  }

  static get is() {
    return 'dashboard-view';
  }

  static get properties() {
    return {
      // Declare your properties here.
    };
  }
}

customElements.define(DashboardView.is, DashboardView);
