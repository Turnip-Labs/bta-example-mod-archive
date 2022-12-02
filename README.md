# BTA Babric Example Mod

A babric mod for BTA with examples of: 
- items, tools, food items, custom items and armor
- blocks, portals and dimensions
- trees (giant mushrooms), entities
- recipes, mixins, invokers and accessors

Future plans include custom worldgen.

## Prerequisites
- JDK for Java 17 ([Eclipse Temurin](https://adoptium.net/temurin/releases/) recommended)
- IntelliJ IDEA
- Minecraft Development plugin (Optional, but highly recommended)

## Setup instructions

1. Download or clone this repository and put it somewhere.
```
git clone https://github.com/Turnip-Labs/bta-example-mod.git
```

2. Import the project in IntelliJ IDEA, close it and open it again.


3. Create a new run configuration by going in `Run > Edit Configurations`  
   Then click on the plus icon and select Gradle. In the `Tasks and Arguments` field enter `build`  
   Running it will build your finished jar files and put them in `build/libs/`


4. Open `File > Settings` and head to `Build, Execution, Development > Build Tools > Gradle`  
   Change `Build and run using` and `Run tests using` to `IntelliJ IDEA`


5. Open `File > Project Structure`, select `Project` and set `Compiler output` to your project's path.


6. Done! Now all that's left is to change every mention of `examplemod` to your own mod id. Happy modding!

## Screenshots
Small sneakpeak of what the mod has in store.
![sneakpeak](github/sneakpeak.png)
Hm, I wonder where did this fire come from?
![fire](github/fire.png)
![recipe1](github/recipe1.png)
![recipe2](github/recipe2.png)
