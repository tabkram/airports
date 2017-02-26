'use strict';

/* https://github.com/angular/protractor/blob/master/docs/toc.md */

describe('my app', function() {


  it('should automatically redirect to /query when location hash/fragment is empty', function() {
    browser.get('index.html');
    expect(browser.getLocationAbsUrl()).toMatch("/query");
  });


  describe('query', function() {

    beforeEach(function() {
      browser.get('index.html#!/query');
    });


    it('should render query when user navigates to /query', function() {
      expect(element.all(by.css('[ng-view] p')).first().getText()).
        toMatch(/partial for view 1/);
    });

  });


  describe('reports', function() {

    beforeEach(function() {
      browser.get('index.html#!/reports');
    });


    it('should render reports when user navigates to /reports', function() {
      expect(element.all(by.css('[ng-view] p')).first().getText()).
        toMatch(/partial for view 2/);
    });

  });
});
