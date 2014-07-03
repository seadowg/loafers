# loafers
![https://api.travis-ci.org/seadowg/loafers.svg](https://api.travis-ci.org/seadowg/loafers.svg)

A framework for simple, easy to learn programming with Android.

## The Gist Of It

```java
class MyApp extends App {
  public void open() {
    new Button("Click Me!") {
      void press() {
        new Popup("Hello! Thanks for clicking!").show();
      }
    };
  }
}
```

## Getting Started

To start your own project simply download and unzip [this](http://github.com/seadowg/loafers-template/archive/master.zip).
Then, plug your phone into your computer and from the unzipped project run:

```bash
./loafers MyApp.java
```

This will push your app to the phone. You can then edit the code in `MyApp.java` to
build your dream app!

## Ideas

Here are the planned features and ideas for loafers:

* Simple UI creation and event handling for Android loosely based on [shoes](http://shoesrb.com/).
* Nice generalised abstractions around Android system and services.
* Stripped down and easy to use Java collection library.
* Build system that allows single App file (possible `*.loafers`) to be deployed to phone.
* Cloud based messaging system allowing apps written with loafers to send data to each other.
