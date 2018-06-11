'use strict';

const webdriver = require('selenium-webdriver'),
  By = webdriver.By,
  until = webdriver.until;

const driver = new webdriver.Builder()
  .forBrowser('chrome')
  .setChromeOptions(driver.Options().headless())
  .build();
  

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
