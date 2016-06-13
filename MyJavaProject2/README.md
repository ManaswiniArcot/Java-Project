An idea of implementing the generation of pdf file. A simple project, which generates the cover letter for your Job application. Why sit and edit all the required information in your cover letter for a similar job position. Create an application that does this job for you.
A Spring MVC architecture implementation using Apache Velocity engine to edit the template file and used IText API to generate the Pdf file.
A simple JSP page with the few input fields that are required which has the null check validation implemented and a just click on submit button that generates the Pdf file for you at your specified location.
How this works?
Once the user enters the details of the position name, Company name, Source URL on clicking the submit button the URL is mapped using annotations and a view is sent as a response to the user, simultaneously creating the pdf file at the specified location.
Created a Velocity Engine object and got the template file from the class path, and added all the data in to the velocity context. Using String Writer, the text is generated replacing all the required parameters into the text.
Now using IText API, the pdf file is generated. Opened a document first and then I used HTML Worker class, as my data contains few html tags to maintain the design of the document. With the parser function, passed the text that is obtained from the above step as a parameter and this also takes the input of the specified path. Finally, the file is created in the location.


