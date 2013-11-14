Javonical
=========
As a professional freelance programmer I have sat through (and conducted) my fair share of Java technical tests. They are usually the first step when applying for a role so you have make sure that you are familiar with what answers are expected. Usually this means digging out some books and doing some revision. What I have found is that the topics covered are almost always the same. I've also found that it's really to forget all the areas that can come up.

Javonical is here help. It is the canonical collection of Java technical questions to save you hunting around lots of sources before that important first interview.

I originally thought I would group together the questions under topics but decided quickly to drop that in favour of structuring this as if it were an actual interview. I will annotate the questions to make it clear what is being asked and then provide what should go into your answer. I will not be trying to give the answers verbatum because that needs to be in your words.

Enough explanation lets begin.


Hi, thanks for coming today...

Multithreading
--------------
(Lets not mess about, multithreading is the single most common subject that will come up. Nevermind that in 90% of cases the role itself wont include any multithreading at all)

"How do you start a new thread?"  
"What is the difference between a Runnable and a Callable?"  
"Could you tell me what a Future is?"  
"What are the benefits of a class being immutable?"  
"Explain what steps you can take to make a class immutable"  

"What is the different between StringBuffer and StringBuilder?"  
This here because the difference is that StringBuffer is synchronized and StringBuilder is not.

"What does the 'volatile' keyword do when found on a field?"

"Without using the classes in the java.util.concurrency package implement a blocking queue"  
First step is to head on over to Github and learn [this](https://gist.github.com/dougnukem/1241317). The critical things to be able to able to answer are:
* Why are both methods synchronized?
* Why is the wait() surrounded by a while loop?
* Why is notifyAll() used rather than notify()?

hashcode() and equals()
-----------------------
(This is *the* standard Java interview question so you need to be able to get it right. You need to be able to answer this without any waffle)  
"What is the contract between hashcode and equals?"

"Explain how hashcode and equals are used when doing a "put" into a hash map?"

"What property must the class have to be used as the key in a Map?"  
It must be immutable otherwise the wrong bucket will be searched during a lookup in the Map.

Garbage Collection
------------------
(Another interview classic and it helps to have a picture in mind to help)

"How does an object become eligible for garbage collection?"  
"There are several different garbage collection implementations, describe the one that you are most familiar with."  
"Describe how the memory organised within the JVM and how objects are moved around it"  
"How can you ensure that an object is garbage collected immediately?"  
Trick question, you can't. System.gc() will suggest to the JVM that it should run the garbage collection but it is under no obligation to actually do it.

Generics
--------
"Could you tell me what is type erasure is?"

"Would a class compile if it had 2 methods on which both had the same return value and both took a single parameter, one being List<String> and the other being List<Date>."  
No. Type erasure would removed the type of the List in both methods leaving both methods with the same signature.

Basics
------
"What visibility modifiers can be added to a field and what is the order of their visibility?"  
Most visible first: public, protected, package private, private.

Collections and Data Structures 
-------------------------------
"What are the different kinds of collection and name some of the implementations?"  
Map, Set, List...

"What do you understand Big O notation to be?"

Error Handling
--------------
"What is the different between a checked and an unchecked exception?"  
"Explain what the 'finally' block does"

Patterns
--------
(You just know that you are going to be asked to implement a Singleton eventually so best you know how to do it. It's worth being able to describe a few more as well)  

    public enum Singleton {  
        INSTANCE;  
    }  

Further reading
===============
If I had to pick up just one book to revise from it would be Java Concurrency in Practice by xxxxxxx et al. If you can nail the multithreading part of the test then it goes a hell of a long way.