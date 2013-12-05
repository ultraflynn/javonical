Javonical
=========
As a professional freelance programmer I have sat through (and conducted) my fair share of Java technical tests. They are usually the first step when applying for a role so you have make sure that you are familiar with what answers are expected. Usually this means digging out some books and doing some revision. What I have found is that the topics covered are almost always the same. I've also found that it's really easy to forget some of the areas that can come up.

Javonical is here help. It is the canonical collection of Java technical questions to save you hunting around lots of sources before that important first interview.

The approach I have settled on is to group the questions under some broad headings and to express the questions as if they were being asked. I will annotate each question to make it clear what is being asked and then provide what should go into your answer. I will not be trying to give the answers verbatum because that needs to be in your words.

I have also included some code examples because often that is the best way to understand things.

Enough explanation lets begin.


__"Hi, thanks for coming today. Lets start with a few technical questions..."__   

### Basics
__"What are the differences between instances, classes, abstract classes and interfaces?"__  
__"What visibility modifiers can be added to a field and what is the order of their visibility?"__  
Most visible first: public, protected, package private, private.

__"What does the transient keyword do?"__  
Stops that field from being serialized.

__"What does the static keyword mean, and where can it be used?"__
Variables, method, classes and blocks.

__"What is an enum and how do you use one?"__  

### Collections and Data Structures
__"Name the 4 base collection interfaces and some of the implementations."__  
Map, Set, List, Queue...   
ArrayList, HashMap, HashSet, CopyOnWriteArrayList, CopyOnWriteArraySet, ConcurrentHashMap, Vector, Hashtable, LinkedList, Stack, TreeMap, TreeSet, LinkedHashMap, LinkedHashSet, EnumMap...   

__"Compare and contrast the LinkedList and ArrayList?"__  
__"What do you understand Big O notation to be?"__  
A way of denoting how well an algorithm performs. A measure of complexity or performance.  
Check out my [guide](https://github.com/ultraflynn/javonical/wiki/Big-O-Notation)

__"How is a HashMap implemented?"__  
Buckets, LinkedList, hashcode, equals

### Error Handling
__"What is the different between a checked and an unchecked exception?"__  
__"Explain what the 'finally' block does"__  

### hashcode() and equals()
(This is *the* standard Java interview question so you need to be able to get it right. You need to be able to answer this without any waffle)

__"What is the contract between hashcode and equals?"__  
__"Explain how hashcode and equals are used when doing a "put" into a hash map?"__  
__"What property must the class have to be used as the key in a Map?"__  
It must be immutable otherwise the wrong bucket will be searched during a lookup in the Map.

### Multithreading
(Lets not mess about, multithreading is the single most common subject that will come up. Nevermind that in 90% of cases the role itself wont include any multithreading at all)

__"How do you start a new thread?"__  
__"What does the synchronized keyword do?"__  
__"What is the difference between a Runnable and a Callable?"__  
__"Could you tell me what a Future is?"__  
__"How do you make a class thread-safe?"__  
__"What are the benefits of a class being immutable?"__  
An immutable class means that it cannot change.

__"Explain what steps you can take to make a class immutable"__  
You need to ensure that it cannot be changed either by enforcement (Make the fields final, values set in the constructor and if they are not primitive then the object being referred to cannot change either) or by convention (Simply agree that objects will never be changed).

__"What are the options for handling InterruptedException?"__  
* Rethrow it. That may not be possible if it's in a Runnable though, for instance.  
* Handle it with some specific logic that makes sense.  
* Interrupt the thread and move on.  

```
Thread.currentThread().interrupt();
```

Do not just log and ignore the exception.

__"Explain what a monitor is and how they are used?"__  

__"What is the different between StringBuffer and StringBuilder?"__  
This here because the difference is that StringBuffer is synchronized and StringBuilder is not.

__"Explain what a CountDownLatch is and how it differs from a CyclicBarrier"__   

__"What does the 'volatile' keyword do when found on a field and how would you use it?"__  
[Interesting article](http://www.ibm.com/developerworks/java/library/j-jtp06197/)

__"Without using the classes in the java.util.concurrency package implement a blocking queue"__  
First step is to look at the implementation I've put together [here](https://github.com/ultraflynn/javonical/tree/master/src/com/ultraflynn/javonical/multithreading/blockqueue). Look at the Producer and Consumer and see how they use the blocking queue). The critical things to be able to able to answer are:
* Why are both methods synchronized?
* Why is the wait() surrounded by a while loop?
* Why is notifyAll() used rather than notify()?

A thread can also wake up without being notified, interrupted, or timing out, a so-called spurious wakeup. While this will rarely occur in practice, applications must guard against it by testing for the condition that should have caused the thread to be awakened, and continuing to wait if the condition is not satisfied. In other words, waits should always occur in loops, like this one:

     synchronized (obj) {
         while (<condition does not hold>)
             obj.wait(timeout);
         ... // Perform action appropriate to condition
     }

[notify() vs notifyAll()](http://stackoverflow.com/questions/37026/java-notify-vs-notifyall-all-over-again)   

__"How would you go about determining what is causing a deadlock?"__

__"What do you understand by the term 'happens before'?"__  
Java Memory Model, [JSR-133](http://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html)

### Garbage Collection
(Another interview classic and it helps to be able to draw a picture describing Eden Space, 2x Survivor Spaces, Old Gen, Perm Gen)

__"How does an object become eligible for garbage collection?"__  
__"There are several different garbage collection implementations, describe the one that you are most familiar with."__  
There are basically 3; Serial (for single core and no pause time requirements), Parallel (peak performance and no pause time requirements) and ConcurrentMarkSweep (overall throughput and GC pauses of under a second).  

__"Describe how the memory organised within the JVM and how objects are moved around inside it"__  
__"How can you ensure that an object is garbage collected immediately?"__  
Trick question, you can't. System.gc() will suggest to the JVM that it should run the garbage collection but it is under no obligation to actually do it.

### Generics
__"Could you tell me what is type erasure is?"__   

__"Would a class compile if it had 2 methods on which both had the same return value and both took a single parameter, one being `List<String>` and the other being `List<Date>`."__  
No. Type erasure would removed the type of the List in both methods leaving both methods with the same signature.

__"What is the difference between 'super' and 'extends'?"__  
PECS. Producer Extends, Consumer Super.  
The first says that it's "some type which is a subclass of E"; the second says that it's "some type which is an ancestor of E". (In both cases E itself is okay.)  
[StackOverflow Question](http://stackoverflow.com/questions/1368166/what-is-a-difference-between-super-e-and-extends-e)

### Algorithms
__"Write a method that implements a factorial (The product of all the positive integers from 1 to a given number. Factorial 0 is 1."__  

    public static int factorial(int f) {
        return ((f == 0) ? 1 : f * factorial(f - 1));
    }
    
__"Write some methods to traverse a tree or graph"__
This comes up quite a bit.  (MH - Several times for me now).  When it does its a killer if you have not got the principles nailed in advance.
Your answer will depend on what they are asking you to operate on to some extent but the principles are easy to learn.
Good starting places include:
* [DFS and BFS](http://www.codeproject.com/Articles/32212/Introduction-to-Graph-with-Breadth-First-Search-BF)
* [BFS](http://www.cs.bu.edu/teaching/c/tree/breadth-first/)
* [BFS](http://java.dzone.com/articles/algorithm-week-graph-breadth)

### Patterns
(You just know that you are going to be asked to implement a Singleton eventually so best you know how to do it. It's worth being able to describe a few more as well.)  

__"Could you explain what a design pattern is?"__  
__"What are some of the most well known patterns?"__  
__"When is it a good time to use a pattern discuss?"__  
This is designed to get you to talk about patterns in design.  Should you always use patterns?  They add complexity!  Sometimes overkill etc.  
__"How do you implement a Singleton?"__  
You talk to Mr Josh Bloch:  

    public enum Singleton {  
        INSTANCE;  
    }  

__"How would you lazy load the instance in a singleton?"__  

    private static class LazySomethingHolder {
        public static Something something = new Something();
    }
    
    public static Something getInstance() {
        return LazySomethingHolder.something;
    }

### Testing
__"How do you test your code?"__  
__"Could you name some mocking frameworks?"__  
[EasyMock](http://easymock.org/), [JMock](http://jmock.org/), [Mockito](https://code.google.com/p/mockito/), [JMockit](https://code.google.com/p/jmockit/)

__"Describe the benefits of using mocking framework?"__  
__"Explain why dependency injection is important when mocking"__   

## Further reading
If I had to pick up just one book to revise from it would be Java Concurrency in Practice by Brian Goetz et al. If you can nail the multithreading part of the test then it goes a hell of a long way.

Another book you really should have read is Effective Java by Josh Bloch. Reading that book totally changes the way in which you code Java.

[Top-15 Investment Bank Threading Questions](http://javarevisited.blogspot.sg/2011/07/java-multi-threading-interview.html)

## Contributors
* Matt Biggin (<matthew.biggin@gmail.com>)
* [Martin Harris](http://martinaharris.com) 
