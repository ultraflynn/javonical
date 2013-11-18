Javonical
=========
As a professional freelance programmer I have sat through (and conducted) my fair share of Java technical tests. They are usually the first step when applying for a role so you have make sure that you are familiar with what answers are expected. Usually this means digging out some books and doing some revision. What I have found is that the topics covered are almost always the same. I've also found that it's really to forget all the areas that can come up.

Javonical is here help. It is the canonical collection of Java technical questions to save you hunting around lots of sources before that important first interview.

The approach I have settled on is to group the questions under some broad headings and to express the questions as if they were being asked. I will annotate each question to make it clear what is being asked and then provide what should go into your answer. I will not be trying to give the answers verbatum because that needs to be in your words.

I have also included some code examples because often that is the best way to understand things.

Enough explanation lets begin.


*"Hi, thanks for coming today. Lets start with a few technical questions..."*   

Multithreading
--------------
(Lets not mess about, multithreading is the single most common subject that will come up. Nevermind that in 90% of cases the role itself wont include any multithreading at all)

*"How do you start a new thread?"*  
*"What is the difference between a Runnable and a Callable?"*  
*"Could you tell me what a Future is?"*  
*"How do you make a class thread-safe?"*  
*"What are the benefits of a class being immutable?"*  
An immutable class means that it cannot change.

*"Explain what steps you can take to make a class immutable"*  
You need to ensure that it cannot be changed either by enforcement (Make the fields final, values set in the constructor and if they are not primitive then the object being referred to cannot change either) or by convention (Simply agree that objects will never be changed).

*"Explain what a monitor is and how they are used?"*  

*"What is the different between StringBuffer and StringBuilder?"*  
This here because the difference is that StringBuffer is synchronized and StringBuilder is not.

*"Explain what a CountDownLatch is"*   

*"What does the 'volatile' keyword do when found on a field and how would you use it?"*  

*"Without using the classes in the java.util.concurrency package implement a blocking queue"*  
First step is to head on over to Github and learn [this](https://gist.github.com/dougnukem/1241317). The critical things to be able to able to answer are:
* Why are both methods synchronized?
* Why is the wait() surrounded by a while loop?
* Why is notifyAll() used rather than notify()?

*"How would you go about determining what is causing a deadlock?"

*"What do you understand by the term 'happens before'?"*  
Java Memory Model, [JSR-133](http://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html)

hashcode() and equals()
-----------------------
(This is *the* standard Java interview question so you need to be able to get it right. You need to be able to answer this without any waffle)

*"What is the contract between hashcode and equals?"*  
*"Explain how hashcode and equals are used when doing a "*put" into a hash map?"     
*"What property must the class have to be used as the key in a Map?"*  
It must be immutable otherwise the wrong bucket will be searched during a lookup in the Map.

Garbage Collection
------------------
(Another interview classic and it helps to have a picture in mind to help)

*"How does an object become eligible for garbage collection?"*  
*"There are several different garbage collection implementations, describe the one that you are most familiar with."*  

*"Describe how the memory organised within the JVM and how objects are moved around it"*  
*"How can you ensure that an object is garbage collected immediately?"*  
Trick question, you can't. System.gc() will suggest to the JVM that it should run the garbage collection but it is under no obligation to actually do it.

Generics
--------
*"Could you tell me what is type erasure is?"*   

*"Would a class compile if it had 2 methods on which both had the same return value and both took a single parameter, one being `List<String>` and the other being `List<Date>`."*  
No. Type erasure would removed the type of the List in both methods leaving both methods with the same signature.
   TODO List<String> and List<Date> are not printing

*"What is the difference between 'super' and 'extends'?"*   
PECS. Producer Extends, Consumer Super.

Basics
------
*"What visibility modifiers can be added to a field and what is the order of their visibility?"*  
Most visible first: public, protected, package private, private.

*"What does the transient keyword do?"*  
*"What is an enum and how do you use one?"*  

Collections and Data Structures
-------------------------------
*"Name the 4 base collection interfaces and some of the implementations."*  
Map, Set, List, Queue...   
ArrayList, HashMap, HashSet, CopyOnWriteArrayList, CopyOnWriteArraySet, ConcurrentHashMap, Vector, Hashtable, LinkedList, Stack, TreeMap, TreeSet, LinkedHashMap, LinkedHashSet, EnumMap...   

*"What do you understand Big O notation to be?"*  
A way of denoting how well an algorithm performs. A measure of complexity or performance.  
[Beginners Guide](http://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/)

*"How is a HashMap implemented?"*  
Buckets, LinkedList, hashcode, equals

Algorithms
----------
*"Write a method that implements a factorial (The product of all the positive integers from 1 to a given number. Factorial 0 is 1."*  
   public static int factorial(int f) {
      return ((f == 0) ? 1 : f * factorial(f - 1));
   }

Error Handling
--------------
*"What is the different between a checked and an unchecked exception?"*  
*"Explain what the 'finally' block does"*  

Patterns
--------
(You just know that you are going to be asked to implement a Singleton eventually so best you know how to do it. It's worth being able to describe a few more as well)  

*"Could you explain what a design pattern is?"*  
*"What are some of the most well known patterns?"*  
*"How do you implement a Singleton?"*  
You talk to Mr Josh Bloch:  

    public enum Singleton {  
        INSTANCE;  
    }  

*"How would you lazy load the instance in a singleton?"*  
   private static class LazySomethingHolder {
      public static Something something = new Something();
   }
   
   public static Something getInstance() {
      return LazySomethingHolder.something;
   }

Testing
-------
*"Could you name some mocking frameworks?"*  
EasyMock, JMock, Mockito.

*"Describe the benefits of using mocking framework?"*  
*"Explain why dependency injection is important when mocking"*   

Further reading
===============
If I had to pick up just one book to revise from it would be Java Concurrency in Practice by xxxxxxx et al. If you can nail the multithreading part of the test then it goes a hell of a long way.

Another book you really should have read is Effective Java by Josh Bloch. Reading that book totally changes the way in which you code Java.
