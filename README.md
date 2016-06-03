# JatoHotkey
Cross platform subset of AutoHotKey's features.

This redesign consists of a few basic classes/interfaces:

* Input Interface
  * Represents a generic input (may be mouse, key, or other)
* Test Interface
  * Represents a generic test of inputs (may be using a single input or multiple tests put together)
  * Should include tests such as IsInputDownTest, OrTest and AndTest
* Event a generic class that when combined with a test of some sort and an Action (user-defined) will trigger that action when the Test becomes true

 
