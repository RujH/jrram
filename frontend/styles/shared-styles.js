// eagerly import theme styles so as we can override them
import '@vaadin/vaadin-lumo-styles/all-imports';

const $_documentContainer = document.createElement('template');

$_documentContainer.innerHTML = `
<custom-style>
  <style>
    html {
      --lumo-body-text-color: hsla(214, 0%, 14%, 0.94);
    }
  </style>
</custom-style>


`;

document.head.appendChild($_documentContainer.content);
