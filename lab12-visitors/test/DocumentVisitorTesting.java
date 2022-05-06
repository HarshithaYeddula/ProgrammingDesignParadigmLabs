import document.BasicStringVisitor;
import document.Document;
import document.HtmlStringVisitor;
import document.MarkdownStringVisitor;
import document.TextElementVisitor;
import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing DocumentVisitors with different type of elements in it.
 */
public class DocumentVisitorTesting {

  private BasicText basicText;
  private BoldText boldText;
  private ItalicText italicText;
  private HyperText hyperText;
  private Paragraph paragraph;
  private Heading heading1;
  private Heading heading2;
  private Document document;
  private Document testDocument;

  /**
   * Setup for Testing Document Visitors.
   */
  @Before
  public void setUp() {

    basicText = new BasicText("It is Basic Text.");
    boldText = new BoldText("It is Bold Text.");
    italicText = new ItalicText("It is Italic Text.");
    hyperText = new HyperText("It is a Hyperlink.", "hyperlink.com");
    heading1 = new Heading("Heading with Level 29.", 29);
    heading2 = new Heading("Heading with Level With Different Level 19.", 19);
    paragraph = new Paragraph();
    paragraph.add(heading1);
    paragraph.add(heading2);
    paragraph.add(boldText);
    paragraph.add(basicText);
    paragraph.add(hyperText);

    document = new Document();
  }

  @Test
  public void testWordCountVisitorsHeading1() {
    document.add(heading1);
    Assert.assertEquals(4, document.countWords());
  }

  @Test
  public void testWordCountVisitorsHeading2() {
    document.add(heading2);
    Assert.assertEquals(7, document.countWords());
  }

  @Test
  public void testWordCountVisitorBasicText() {
    document.add(basicText);
    Assert.assertEquals(4, document.countWords());
  }

  @Test
  public void testWordCountVisitorBoldText() {
    document.add(boldText);
    Assert.assertEquals(4, document.countWords());
  }

  @Test
  public void testWordCountVisitorItalicText() {
    document.add(italicText);
    Assert.assertEquals(4, document.countWords());
  }

  @Test
  public void testWordCountVisitorHyperText() {
    document.add(hyperText);
    Assert.assertEquals(4, document.countWords());
  }

  @Test
  public void testWordCountVisitorParagraphText() {
    document.add(paragraph);
    Assert.assertEquals(23, document.countWords());
  }

  @Test
  public void testBasicStringVisitorHeading1() {
    testDocument = new Document();
    testDocument.add(heading1);
    Assert.assertEquals("Heading with Level 29.", testDocument.toText(new BasicStringVisitor()));
  }

  @Test
  public void testBasicStringVisitorHeading2() {
    testDocument = new Document();
    testDocument.add(heading2);
    Assert.assertEquals("Heading with Level With Different Level 19.",
        testDocument.toText(new BasicStringVisitor()));
  }

  @Test
  public void testBasicStringVisitorBasicText() {
    testDocument = new Document();
    testDocument.add(basicText);
    Assert.assertEquals("It is Basic Text.", testDocument.toText(new BasicStringVisitor()));
  }

  @Test
  public void testBasicStringVisitorBoldText() {
    testDocument = new Document();
    testDocument.add(boldText);
    Assert.assertEquals("It is Bold Text.", testDocument.toText(new BasicStringVisitor()));
  }

  @Test
  public void testBasicStringVisitorItalicText() {
    testDocument = new Document();
    testDocument.add(italicText);
    Assert.assertEquals("It is Italic Text.", testDocument.toText(new BasicStringVisitor()));
  }

  @Test
  public void testBasicStringVisitorHyperText() {
    testDocument = new Document();
    testDocument.add(hyperText);
    Assert.assertEquals("It is a Hyperlink.", testDocument.toText(new BasicStringVisitor()));
  }

  @Test
  public void testBasicStringVisitorParagraphText() {
    testDocument = new Document();
    testDocument.add(paragraph);
    Assert.assertEquals(
        "Heading with Level 29. "
        + "Heading with Level With Different Level 19. It is Bold Text."
        + " It is Basic Text. It is a Hyperlink.",
        testDocument.toText(new BasicStringVisitor()));
  }

  @Test
  public void testHtmlStringVisitorHeading1() {
    testDocument = new Document();
    testDocument.add(heading1);
    Assert.assertEquals("<h29>Heading with Level 29.</h29>",
        testDocument.toText(new HtmlStringVisitor()));
  }

  @Test
  public void testHtmlStringVisitorHeading2() {
    testDocument = new Document();
    testDocument.add(heading2);
    Assert.assertEquals("<h19>Heading with Level With Different Level 19.</h19>",
        testDocument.toText(new HtmlStringVisitor()));
  }

  @Test
  public void testHtmlStringVisitorBasicText() {
    testDocument = new Document();
    testDocument.add(basicText);
    Assert.assertEquals("It is Basic Text.", testDocument.toText(new HtmlStringVisitor()));
  }

  @Test
  public void testHtmlStringVisitorBoldText() {
    testDocument = new Document();
    testDocument.add(boldText);
    Assert.assertEquals("<b>It is Bold Text.</b>", testDocument.toText(new HtmlStringVisitor()));
  }

  @Test
  public void testHtmlStringVisitorItalicText() {
    testDocument = new Document();
    testDocument.add(italicText);
    Assert.assertEquals("<i>It is Italic Text.</i>", testDocument.toText(new HtmlStringVisitor()));
  }

  @Test
  public void testHtmlStringVisitorHyperText() {
    testDocument = new Document();
    testDocument.add(hyperText);
    Assert.assertEquals("<a href=\"hyperlink.com\">It is a Hyperlink.</a>",
        testDocument.toText(new HtmlStringVisitor()));
  }

  @Test
  public void testHtmlStringVisitorParagraphText() {
    testDocument = new Document();
    testDocument.add(paragraph);
    Assert.assertEquals("<p><h29>Heading with Level 29.</h29>\n"
        + "<h19>Heading with Level With Different Level 19.</h19>\n" + "<b>It is Bold Text.</b>\n"
        + "It is Basic Text.\n" + "<a href=\"hyperlink.com\">It is a Hyperlink.</a>\n" + "</p>",
        testDocument.toText(new HtmlStringVisitor()));
  }

  @Test
  public void testMarkDownStringVisitorHeading1() {
    testDocument = new Document();
    testDocument.add(heading1);
    Assert.assertEquals("############################# Heading with Level 29.",
        testDocument.toText(new MarkdownStringVisitor()));
  }

  @Test
  public void testMarkDownStringVisitorHeading2() {
    testDocument = new Document();
    testDocument.add(heading2);
    Assert.assertEquals("################### Heading with Level With Different Level 19.",
        testDocument.toText(new MarkdownStringVisitor()));
  }

  @Test
  public void testMarkDownStringVisitorBasicText() {
    testDocument = new Document();
    testDocument.add(basicText);
    Assert.assertEquals("It is Basic Text.", testDocument.toText(new MarkdownStringVisitor()));
  }

  @Test
  public void testMarkDownStringVisitorBoldText() {
    testDocument = new Document();
    testDocument.add(boldText);
    Assert.assertEquals("**It is Bold Text.**", testDocument.toText(new MarkdownStringVisitor()));
  }

  @Test
  public void testMarkDownStringVisitorItalicText() {
    testDocument = new Document();
    testDocument.add(italicText);
    Assert.assertEquals("*It is Italic Text.*", testDocument.toText(new MarkdownStringVisitor()));
  }

  @Test
  public void testMarkDownStringVisitorHyperText() {
    testDocument = new Document();
    testDocument.add(hyperText);
    Assert.assertEquals("[It is a Hyperlink.](hyperlink.com)",
        testDocument.toText(new MarkdownStringVisitor()));
  }

  @Test
  public void testMarkDownStringVisitorParagraphText() {
    testDocument = new Document();
    testDocument.add(paragraph);
    Assert.assertEquals("\n" + "############################# Heading with Level 29.\n"
        + "################### Heading with Level With Different Level 19.\n"
        + "**It is Bold Text.**\n" + "It is Basic Text.\n" + "[It is a Hyperlink.](hyperlink.com)",
        testDocument.toText(new MarkdownStringVisitor()));
  }

  @Test
  public void testDocumentTextTextElement() {
    testDocument = new Document();
    testDocument.add(heading1);
    testDocument.add(heading2);
    testDocument.add(basicText);
    testDocument.add(boldText);
    testDocument.add(italicText);
    testDocument.add(hyperText);
    testDocument.add(paragraph);

    TextElementVisitor<Void> textVisitor = new BasicStringVisitor();
    Assert.assertEquals(
        "Heading with Level 29. "
        + "Heading with Level With Different Level 19. "
        + "It is Basic Text. It is Bold Text. It is Italic Text. "
        + "It is a Hyperlink. Heading with Level 29. "
        + "Heading with Level With Different Level 19. It is Bold Text. "
        + "It is Basic Text. It is a Hyperlink.",
        testDocument.toText(textVisitor));

    TextElementVisitor<Void> htmlVisitor = new HtmlStringVisitor();
    Assert.assertEquals("<h29>Heading with Level 29.</h29>\n"
        + "<h19>Heading with Level With Different Level 19.</h19>\n" + "It is Basic Text.\n"
        + "<b>It is Bold Text.</b>\n" + "<i>It is Italic Text.</i>\n"
        + "<a href=\"hyperlink.com\">It is a Hyperlink.</a>\n"
        + "<p><h29>Heading with Level 29.</h29>\n"
        + "<h19>Heading with Level With Different Level 19.</h19>\n" + "<b>It is Bold Text.</b>\n"
        + "It is Basic Text.\n" + "<a href=\"hyperlink.com\">It is a Hyperlink.</a>\n" + "</p>",
        testDocument.toText(htmlVisitor));

    TextElementVisitor<Void> markdownVisitor = new MarkdownStringVisitor();
    Assert.assertEquals("############################# Heading with Level 29.\n"
        + "################### Heading with Level With Different Level 19.\n"
        + "It is Basic Text.\n" + "**It is Bold Text.**\n" + "*It is Italic Text.*\n"
        + "[It is a Hyperlink.](hyperlink.com)\n" + "\n"
        + "############################# Heading with Level 29.\n"
        + "################### Heading with Level With Different Level 19.\n"
        + "**It is Bold Text.**\n" + "It is Basic Text.\n" + "[It is a Hyperlink.](hyperlink.com)",
        testDocument.toText(markdownVisitor));
  }
}
