# citeenv

##What it is

`citeenv` is a cross-platform library for working with all citable resources in a unified environment.

A CITE environment should bring together the following citable resources and relations:

- citable texts (via the `ohco2` library)
- citable objects (via the `citeobj` library)
- citable readings of texts (via the `orca`  library)
- citable relations
- citable images



##Current version: 1.0

Status:  **active development**. [Release notes](releases.md)

## License

[GPL 3.0](https://opensource.org/licenses/gpl-3.0.html)

## Using, building, testing

`citeenv` compiled for both the JVM and ScalaJS using scala versions 2.10 and 2.11.  Binaries for all platforms are available from jcenter.  If you are using sbt, include `Resolver.jcenterRepo`in your list of resolvers

    resolvers += Resolver.jcenterRepo

and  add this to your library dependencies:

    "edu.holycross.shot.cite" %% "citeenv" % VERSION

For maven, ivy or gradle equivalents, refer to <https://bintray.com/neelsmith/maven/ohco2>.



To build from source and test, use normal sbt commands (`compile`, `test` ...).
