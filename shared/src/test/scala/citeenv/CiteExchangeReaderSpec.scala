package edu.holycross.shot.citeenv
import org.scalatest.FlatSpec
import edu.holycross.shot.cite._


/**
*/
class CiteExchangeReaderSpec extends FlatSpec {

  "A CEX reader" should "be able to create a text repository" in {

    val tinyTexts = """#!ctsdata
urn:cts:greekLit:tlg5026.msA.hmt:1.4.lemma#<div xmlns="http://www.tei-c.org/ns/1.0" n="lemma"> <p> θεά</p></div>
urn:cts:greekLit:tlg5026.msA.hmt:1.4.comment#<div xmlns="http://www.tei-c.org/ns/1.0" n="comment"> <p> οὕτως εἴωθε τὴν <persName n="urn:cite:hmt:pers.pers6"> Μοῦσαν</persName> καλεῖν· ἀμέλει καὶ ἐν <title> Ὀδυσσεία</title> · <cit> <q> ἄνδρα μοι ἔννεπε <persName n="urn:cite:hmt:pers.pers6"> Μοῦσα</persName> <ref type="urn">
#!ctscatalog
urn#citationScheme#groupName#workTitle#versionLabel#exemplarLabel#online
urn:cts:greekLit:tlg5026.msA.hmt:#book/scholion/part#Scholia to the Iliad#Main scholia of the Venetus A#HMT project edition##true
"""

    val reader = CiteExchangeReader(tinyTexts,"#")
    val textRepo = reader.textRepository
    assert (textRepo.catalog.texts.size == 1)
    assert(textRepo.corpus.size == 2)

  }

  it should "be able to create a cite collection archive" in pending
  it should "be able to create a cite image archive" in pending
  it should "be able to create a an ORCA collection" in pending
  it should "be able to create a collection of CITE relations" in pending


}
