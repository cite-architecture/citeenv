package edu.holycross.shot.citeenv

import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.citeobj._


sealed abstract trait SourceType

case object TextType extends SourceType
case object ObjectType extends SourceType
case object ReadingType extends SourceType
case object RelationType extends SourceType
case object ImageType extends SourceType


case class Reference(urn: Urn, src: SourceType)

case class ReferenceList(references: Vector[Reference]) {

  def ++(list2: ReferenceList) = {
    val newList = references ++ list2.references
    ReferenceList(newList.distinct)
  }
  def ~~(filterUrn: Urn): ReferenceList = {
    ReferenceList(references.filter(_.urn ~~ filterUrn))
  }
  def byType(srcType: SourceType) = {
    val newList = references.filter(_.src == srcType)
    ReferenceList(newList)
  }
}

case class CiteEnvironment(label: String,
textUrns : ReferenceList, objectUrns: ReferenceList
) {

  def ~~ (urn: Urn) : CiteEnvironment = {
    urn match {
      case txt: CtsUrn => CiteEnvironment(label + " filtered by ${urn.toString()}",textUrns ~~ urn,objectUrns)
      case obj: Cite2Urn => CiteEnvironment(label + " filtered by ${urn.toString()}",textUrns,objectUrns ~~ urn)
    }
  }

  def fromSource(srcType: SourceType) = {

    srcType match {

      case txt: TextType.type => txt /*CiteEnvironment("text sources from " + label, textUrns.byType(txt.type), Vector.empty)
      case obj: ObjectType => CiteEnviroment("object sources from " + label, Vector.empty, objectUrns.byType( obj.type))

      case rdg: ObjectType.type => CiteEnvironment("readings from " + label, textUrns.byType(rdg), objectUrns.byType(rdg.type))

      case rel: RelationType.type => CiteEnvironment("relations from " + label, textUrns.byType(rel), objectUrns.byType(rel.type))

      case img: ImageType.type => CiteEnvironment("images sources from " + label, Vector.empty, objectUrns.byType(img.type))*/
      case _ => this
    }
  }
}
