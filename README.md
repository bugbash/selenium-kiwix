TODO
----

* Run kiwix-serve from project itself using ProcessBuilder as on option
* Integrate with Travis 
* Currently using open source library Omelet(https://github.com/springer-opensource/omelet) which is not published to maven central , need to build from source
* Offcourse better naming to test cases and files

selenium-kiwix
==============

Selenium Conference 2014 Kiwix Bug Bash
---------------------------------------
The Selenium Conference 2014 is hosting a Bug Bash http://bugbash.in/kiwix-at-seconf This github repository is the home for people who are participating in the Bug Bash; the project may live on after the conference and/or be combined with the master project at http://sourceforge.net/projects/kiwix/

The aims of the Bug Bash extend beyond 'finding bugs', we are keen to encourage and foster collaborative work where we experiment with creating automated test suites for one or more of the kiwix applications. The conference has attracted several hundred passionate individuals; many have significant experience with the Selenium test automation framework. We also have several software testing gurus who are particpating in the Bug Bash and available to collaborate with the test automation to enhance the potency of the automated tests.

Participants can work individually and in groups. 

Suggested approaches include: 
   * Implementing automated tests for one or more of the kiwix applications, incluing the kiwix web server (called kiwix-serve). These tests can be written using the framework of your choice. For instance here are some possible frameworks for the Android app: Appium, Selendroid, Calabash, Robotium, etc. For the web app, how about Selenium (given the title of the conference :) )
   * Reviewing and enhancing current open bugs from the sourceforge project http://sourceforge.net/p/kiwix/bugs/ so they are easier to understand and fix
   * Providing translations, especially for incompletely translated locales http://sourceforge.net/p/kiwix/kiwix/ci/master/tree/android/res/

What do you need?
At least one of the kiwix applications. The homepage of the kiwix project http://kiwix.org includes several links on the right side of the page. The first includes the enormous wikipedia zim file in English, so skip that unless you have lots of fast internet bandwidth. Instead find the Download Kiwix 'button', the web page attempts to detect your operating system in order to recommend the appropriate download for your computer.   

At least one zim file. Here's one source, http://download.kiwix.org/zim/wikipedia/ people at the conference can also get them in the E Square room.

What would we like you to do?
-----------------------------
   * If you want to work on automating tests: Fork this repository, work on your copy of the respository, and send us pull requests when you've got something to share. Here's a useful guide on this topic https://guides.github.com/activities/forking/
   * Bonus points: online CI, for instance travis-ci.org integrates well with github projects.
   * If you want to report bugs, feature requests, quirks, etc. file them here https://github.com/Bug-Bash/selenium-kiwix/issues *Before you file* please check for known (reported) [bugs](http://sourceforge.net/p/kiwix/bugs/ "List of Kiwix bugs on SourceForge"), read the [discussions](http://sourceforge.net/p/kiwix/discussion/ "Discussions on SourceForge for Kiwix"), etc.

Test Automation
===============
Yes please, particularly for the Android app and the kiwix-serve web server. Your choice of test automation framework, however it'll need to be freely available and able to be used free of charge. Bonus points for well structured, maintainable automated tests that others can read and comprehend.  

