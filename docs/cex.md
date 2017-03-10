# Cite data exchange format (CEX format)

The CEX format defines conventions for including citable material of all categories recognized in the CITE architecture in a simple plain-text file with the suggested file extension `.cex`.

CEX files are line-oriented.  They are divided into sections by a line beginning with `!#` followed by the type of data found in the following lines.  The recognized values for these section markers are:

- `!#ctsdata`
- `!#ctscatalog`
- `!#citedata`
- `!#citecatalog`
- `!#imagedata`
- `!#relations`
- `!#orca`

The formats of contents of each are:



- `ctsdata`: two-column delimited text as imported by `Corpus` object
- `ctscatalog`: delimited text as imported by `CtsCatalog`

The others will be added subsequently
