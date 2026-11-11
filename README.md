MasteringTables
=====================

Mastering Tables is a simple game used to test children knowledge of their Math Tables (+-x/)

It uses JRebirth Application Framework as core engine.

Mastering Tables is accessible here : [Mastering Tables Demo](http://www.jrebirth.org/apps/MasteringTables.html)

Current Build Status
[![Build Status](http://ci.jrebirth.org/buildStatus/icon?job=MasteringTables-master)](http://ci.jrebirth.org/job/MasteringTables-master/)

Download Binaries
-----------

All binaries are stored on our binaries server : http://apps.jrebirth.org/masteringtables

Latest one are here : http://apps.jrebirth.org/masteringtables/4.0.0/


Build it
-----------

Requires [Git](http://git-scm.com/), [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and [Maven](http://maven.apache.org/).

    git clone https://github.com/JRebirth/MasteringTables.git
    cd MasteringTables/org.jrebirth.demo.masteringtables
    mvn clean install -P WebStart,AutoJar,WinExe


How to Build Snaphot Versions
---------------------

You can build __RELEASE__ versions by simply using [Maven Central](http://search.maven.org) or [JCenter](jcenter.bintray.com) repositories to grab all dependencies.

As this project may depend on snapshot versions of JRebirth, if you want to build a __SNAPSHOT__ line-up you can:

* Use [Maven Central](https://repo1.maven.org/maven2) for releases and add [repo.jrebirth.org](https://repo.jrebirth.org/) snapshot repositories in your Maven settings when needed, or  
* Build yourself [JRebirth-RIA-POM](https://github.com/JRebirth/JRebirth-RIA-POM) and [JRebirth](https://github.com/JRebirth/JRebirth) from source.

__Example: extra repositories in `settings.xml` (snapshots on repo.jrebirth.org)__

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.1.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <profiles>
    <profile>
      <id>jrebirth-snapshots</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
          <releases><enabled>true</enabled></releases>
          <snapshots><enabled>false</enabled></snapshots>
        </repository>
        <repository>
          <id>jrebirth-snapshot</id>
          <url>https://repo.jrebirth.org/libs-snapshot</url>
          <releases><enabled>false</enabled></releases>
          <snapshots><enabled>true</enabled></snapshots>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
          <releases><enabled>true</enabled></releases>
          <snapshots><enabled>false</enabled></snapshots>
        </pluginRepository>
        <pluginRepository>
          <id>jrebirth-plugin-snapshot</id>
          <url>https://repo.jrebirth.org/plugins-snapshot</url>
          <releases><enabled>false</enabled></releases>
          <snapshots><enabled>true</enabled></snapshots>
        </pluginRepository>
      </pluginRepositories>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>jrebirth-snapshots</activeProfile>
  </activeProfiles>
</settings>
```

