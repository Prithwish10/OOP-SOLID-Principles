# OOP-SOLID-Principles
The SOLID Principles are five principles of Object-Oriented class design. They are a set of rules and best practices to follow while designing a class structure.

* `S`- Single Responsibility Principle
* `O`- Open-Closed Principle
* `L`- Liskov Substitution Principle
* `I`- Interface Segregation Principle
* `D`- Dependency Inversion Principle

## Single Responsibility Principle (SRP)
Single Responsibility Principle states that a class should have only one reason to change, which means every class should have a single responsibility/functionality to perform. Implementation to multiple functionality in a single class will mash up the code.

Example: Suppose there is a class called `BankService`. The responsibility of the BankService class is to deposit and withdraw amounts from the bank. Now say, in this BankService class we have defined 4 methods: 
* `deposit`: To deposit an amount.
* `withdraw`: To withdraw an amount.
* `getLoanInterestInfo`: To get the loan interest info. Standing at todays date the bank supports homeLoan, personalLoan and carLoan.
* `sendOTP`: To send OTP. Standing at today's date, the bank supports email and mobile OTP.

### Issue
Here in this example the problem is with 2 methods:
* `getLoanInterestInfo`: In future the bank may want to support "goldLoad" and "studyLoan". In that case we have to modify the code of this class.
* `sendOTP`: In future the bank may also want to support the whatsapp OTP functionality. In that case also we have to modify the code of this class.

Therefore, we can see that the BankService class has too many responsibilities, and it has too many reasons to change. Hence, it violates the SRP.

### How to overcome this, such that our implementation follows SRP ?
* Remove the `getLoanInterestInfo` method from the BankService class, and create a separate class called `LoanService`, and place the method in there.
* Remove the `sendOTP` method from the BankService class, and create a separate class called `NotificationService`, and place the method in there.

After doing the above changes, our `BankService`, `LoanService` and `NotificationService` will have a single responsibility to perform. Hence, we can conclude that our implementation is now following the SRP.

## Open-Closed Principle (OCP)
This principle states that software entities like classes, models, functions should be open for extension, but closed for modification. 
We can also say that this principle states that according to new requirement the modules should be open for extension but closed for modification. 
This means we should be able to extend a class behavior without modifying it.

Example: Let's take the same example of the `NotificationService` class. So, the NotificationService class now has 2 features,i.e., to send otp using mobile and email. 

### Issue
In future say this NotificationService class wants to implement send notification using whatsapp. So in that case we need to modify the code of this class, which violates the open-closed principle, which states that the module should be open for extension but closed for modification.

### How to resolve this such that our implementation follows OCP ?
* Replace the NotificationService class with an Interface, which will have the method called `sendOTP`.
* Create separate implementation classes called `EmailNotificationService`, `MobileNotificationService`. And these classes will implement the NotificationService Interface.

Now say in future if the bank want to support whatsapp OTP functionality, then we just need to create a seperate class called `WhatsappNotificationService` and we'll make this class implement the NotificationService interface, and hence will override the sendOTP method and will give its implementation.

Hence, by doing this, the NotificationService is open for extension, but closed for modification. Therefore, now we can say that our implementation is following the OCP.

## Liskov Substitution Principle (LSP)
This principle states that **the derived classes must be completely substitutable for their base classes**. In other words, if class A
is a sub-type of class B, then we should be able to replace B with A without interrupting the behavior of the program.

Example: Let's say we have an Interface named `SocialMedia`, which  have 4 methods: 
* `chatWithFriend` 
* `sendPhotosAndVideos` 
* `publishPost` 
* `groupVideoCall`

Now, say we have 3 classes representing different social media platforms,
* `Instagram`
* `Facebook`
* `Whatsapp`

These 3 classes implement the Social media Interface, and hence override all the methods in SocialMedia Interface.

### Issue
* Instagram doesn't support group video call, but still it had to override the `groupVideoCall` method. Instagram only allows publishing posts (`publishPost`), chatting with friends (`chatWithFriend`) and sending photos and videos (`sendPhotosAndVideos`).
* Whatsapp doesn't support group publish posts, but still it had to override the `publishPost` method. Whatsapp only allows group video calls(`groupVideoCall`), chat with friends (`chatWithFriend`) and send photos and videos (`sendPhotosAndVideos`).

This violates the LSP, which states that the derived classes must be completely substitutable for their base classes.

### How to resolve the issue?
* The `SocialMedia` Interface should contain only the common functionalities (methods) that are supported in all the social media platforms. The common functionalities are to chat with friends and send photos and videos. So remove the `publishPost` and `groupVideoCall` methods from the SocialMedia Interface.
* Create separate Interfaces called `PostMediaManager` and `SocialVideoCallManager`, which contain `publishPost` and `groupVideoCall` functionalities(method) respectively.
* Now the `Facebook`, `Instagram`, `Whatsapp` classes will implement the Interfaces according to what functionality these social media platforms support.

## Interface Segregation Principle (ISP):
The principle states that the larger interfaces split into smaller ones. Because the implementation classes use only the methods that are required. We
should not force the client to use the methods that they do not want to use.

Example: Let's say we have an Interface with 5 methods, and we have a class called A that implements that interface. But the class A don't want 
to override all the methods. Then we can not force my client(class A) to implement all the 5 methods.

## Dependency Inversion Principle (DIP):
The principle states that we must use abstraction(abstract classes or interfaces) instead of concrete implementations. High level modules should not
depend on low level modules, but both should depend on abstraction.
