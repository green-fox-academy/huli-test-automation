'use strict';


const webdriver = require('selenium-webdriver'),
  By = webdriver.By,
  until = webdriver.until;

var chromeCapabilities = webdriver.Capabilities.chrome();
//setting chrome options to start the browser fully maximized
var chromeOptions = {
    'args': ['--no-sandbox', '--headless']
};
chromeCapabilities.set('chromeOptions', chromeOptions);

var driver = new webdriver.Builder().withCapabilities(chromeCapabilities).build();


driver.get('http://google.com');

driver.wait(check_title);
function check_title() {
  let promise = driver.getTitle().then( function(title) {
    if(title === 'Google') {
      console.log('success');
      return true;
    } else {
      console.log('fail --' + title);
    }
  });

  return promise;
};
