package edu.holycross.shot.citeenv

import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
//import edu.holycross.shot.citeobj._



/** Reader for creating citable data sets from simple text
* representation in CEX format.
*
* @param cexString Data in CEX format.
* @param columnDelimiter String value used to separate columns in simple text tables throughout the file.
*/
case class CiteExchangeReader(cexString: String, columnDelimiter: String = "\t") {
  def raw = cexString.split("#!").toVector.filter(_.nonEmpty)
  def sections = raw.map(_.split("\n")).map(v => (v.head,v.drop(1).toVector))


  /** Create a text repository.
  */
  def textRepository: TextRepository = {
    val ctsCatalogLines = sections.filter(_._1 == "ctscatalog").flatMap(_._2)

    println("CAT: " + ctsCatalogLines.mkString("\n"))
    val catalog = Catalog(ctsCatalogLines.mkString("\n"),columnDelimiter)
    val ctsDataLines = sections.filter(_._1 == "ctsdata").flatMap(_._2)
    val corpus = Corpus(ctsDataLines.mkString("\n"),columnDelimiter)
    TextRepository(corpus, catalog)
  }



}
