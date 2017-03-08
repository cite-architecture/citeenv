# citeenv

A cross-platform library for working with all citable resources in a unified environment.

A CITE environment brings together the following citable resources and relations:

- citable texts (via the `ohco2` library)
- citable objects (via the `citeobj` library)
- citable readings of texts (via the `orca`  library)
- citable relations
- citable images


It applies URN twiddling across these structures according to the following logic.

### Single CTS URN

- applies to text collection, text component of ORCA Collection, and citable relations

### Single Cite2Urn

- applies to object collection, image collection, analysis component of ORCA collection and citable relations


## Possible algorithm

- at initialization, harvest URNs from all sources and group in two large lists:
    -  text URNs and where they came from (texts, ORCA, relations)
    - object URNs and where they came from (objects, images, ORCA or relations)
