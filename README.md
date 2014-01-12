loafers
=======

A framework for simple, easy to learn programming with Android.

## The Gist Of It

```java
class MyApp extends App {
  public void open() {
    new Button("Click Me!") {
      void click() {
        new Popup("Hello! Thanks for clicking!").show();
      }
    }
  }
}
```

## Ideas

Here are the planned features and ideas for loafers:

* Simple UI creation and event handling for Android loosely based on [shoes](http://shoesrb.com/).
* Nice generalised abstractions around Android system and services.
* Stripped down and easy to use Java collection library.
* Build system that allows single App file (possible `*.loafers`) to be deployed to phone.
* Cloud based messaging system allowing apps written with loafers to send data to each other.
