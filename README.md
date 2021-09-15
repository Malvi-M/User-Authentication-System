# User-Authentication-System

### Validation form of mail system using JAVA Swing

<p>Email program system is to simulate the existing email system. Its purpose is to send and receive electronic mails (e-mails). This project is developed using JAVA and few APIs of Java. The proposed system uses JAVA coding to send the mails. It securely transmits the mail between sender and receiver. Over all, Email program system is cost effective and doesn’t compromise on security. </p>

Following functionalities are incorporated in the project:
* The Project runs and first window (frame) that appears is Login Window.
    * Login Window frame consists of two labels, two textboxes and two buttons (LOGIN and CREATE NEW WINDOW). Textboxes are used to take username and password as input from user.
    * The system also ensures that the entered E-mail/Username and password is valid and is not empty.
* Create New Account button leads to Sign Up frame and Login button leads to Create Mail frame.
    * First user needs to create new account through sign up frame. It consists of five labels and 5 textboxes i.e. First Name, Last Name, Phone Number, E-mail ID and Password.
    * The system checks if all the fields are correctly filled and valid Phone number and E-mail ID is entered.
    * Once the valid data is entered, it is stored and user can login through username and password thereafter.
* Login button leads to Main Page frame with welcome message to user. Apart from these there are three buttons provided (COMPOSE MAIL, ADD USER and LOGOUT). 
* Compose Mail button directs user to new fame i.e. Create Mail frame, whereas Add User button directs to add user frame. 
    * In Create Mail frame, there are four labels and four text fields to take input of sender’s email address, Cc, Subject of Mail and E-mail body. 
        * The system ensures the ‘to’ and ‘cc’ text fields are filled correctly without any error.
        * User can either add subject or can send E-mail without subject, both options are provided, but before sending mail without subject, it will warn the user once.
    * With Add User button, user will be able to add other users, this right solely provided to admin user and not to others. 
* Apart from these, the Main Page will display the message if message is correctly sent or not. 
* Two other options are provided that are to view full message that is sent and to delete the message. 
    * System will confirm once before deleting the message. 

* This application can be used as an internal medium of communication in corporate sectors, offices, schools & colleges.

* Logout button leads back to Login Page frame.
    * Logout button will confirm if user really wants to logout and gets user back to login page.

The Readme file is provided with view to understand the project effortlessly. 
