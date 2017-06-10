import { QPage } from './app.po';

describe('q App', () => {
  let page: QPage;

  beforeEach(() => {
    page = new QPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
