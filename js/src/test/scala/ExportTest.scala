package edu.holycross.shot.citeenv

import edu.holycross.shot.cite._
import org.scalatest._

class ExportTest extends FlatSpec {

  "The citeenv library"  should "expose methods the citable universe" in pending
  it should "expose the CiteExchangeReader class to javascript" in {
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

}
