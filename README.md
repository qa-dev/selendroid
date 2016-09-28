Avito patched Selendroid
========================

Based on Selendroid 0.17.0. (`d4f5cf1`)

Changes
-------

- Add scroll to element (`/wd/hub/session/:sessionId/element/:id/scrollTo`)

Build
-----

```
$ export MAVEN_OPTS="-Xms1024m -Xmx2048m -Xss2048k"
$ mvn clean compile package
```


Selendroid
==========

[![Build Status](https://travis-ci.org/selendroid/selendroid.png?branch=master)](https://travis-ci.org/selendroid/selendroid)

Selendroid is a test automation framework which drives of the UI of Android native and hybrid applications (apps) and the mobile web with Selendroid. Tests are written using the Selenium 2 client API and for testing the application under test must not be modified. 

Selendroid can be used on emulators and real devices and can be integrated as a node into the Selenium Grid for scaling and parallel testing.


You want more details?
----------------------

Check out our [documentation](http://selendroid.io).

Contributing
------------
We have [documented Selendroid's Architecture](http://selendroid.io/architecture.html) and all the small tricks you need to know when contributing to selendroid you find in our [wiki](https://github.com/selendroid/selendroid/wiki).
 Also confirm you have signed the [CLA](http://goo.gl/pAvxEI) when making a Pull Request.

Maven Artifacts
---------------

You can find the current version in Maven central and the latest snapshot version here: [https://oss.sonatype.org/content/repositories/snapshots/](https://oss.sonatype.org/content/repositories/snapshots/)

Building
--------
1. Install third party artifacts to local .m2 repo by executing:
```
$ third-party/mvnInstall.sh
```
2. Run ```mvn clean compile package```

License
-----------
[The Apache Software License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)
