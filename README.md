<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

### Part C:
- mainscreen.html: fixed the header, title
### Part D:
- about.html: added title 'About' and with some paragraphs in detail, added 'Back to the main page' button that able to direct to mainscreen.html
- mainscreen.html: added 'About' button that able to direct to about.html
### Part E:
- BootStrapData.java: added an if statement to check count of parts and products to check if there is inventory already there, and update the products and parts
### Part F:
- mainscreen.html: added 'Buy Now' button and it decreases the inventory of that product by one, able to display a message that indicates the success or failure of the purchase
- BuyNowProductController: able to map to the button from mainscreen.html
- purchaseSuccess.html: display a success purchase message
- purchaseError.html: display a failure purchase message
### Part G:
- Part.java: initialized max and min value, added a new constructor that allows max and min value, check if it meets the requirements, added setter and getter for both
- BootStrapData: added max and min values to parts
- InhousePartForm: display the message
- OutsourcedPartForm: display the message
- Renamed the spring-boot-h2-db to spring_d287 in application.properties
- Part.java: created a new method to check if an inventory is valid
- AddInhousePartController and AddOutsourcedController: used the method from Part.java to generate a message if the inventory has errors
### Part H:
### Part I:
### Part J:
