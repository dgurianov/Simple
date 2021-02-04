import pyPdf
import sys 
input_file = pyPdf.PdfFileReader(file(sys.argv[1], 'rb'))
output_file = pyPdf.PdfFileWriter()
 
for page in range(1, input1.getNumPages() ):
	page1 =  input1.getPage(page)
	page1.mediaBox.upperRight = ( 510 , 	725  )
	page1.mediaBox.lowerLeft = ( 100 , 68   )
	output.addPage(page1)
	print "Processed page : " , page
	
outputStream = file(''.join(['Cropped_',sys.argv[1]]), 'wb')
output.write(outputStream)
outputStream.close()
