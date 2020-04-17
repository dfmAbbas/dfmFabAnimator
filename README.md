## Animator
[![](https://jitpack.io/v/dfmabbas/animator.svg)](https://jitpack.io/#dfmabbas/animator)
[![License](http://img.shields.io/badge/license-MIT-green.svg?style=flat)](https://github.com/dfmabbas/animator)
[![API](https://img.shields.io/badge/API-15%2B-blue.svg?style=flat)](https://github.com/dfmabbas/animator)

###### This library is for adding smooth animation and coloring to the FloatingActionButton library android.



[![Donate](https://img.shields.io/badge/Donate-IRAN-green)](https://idpay.ir/oky2abbas)
<br>**Funding for faster development**  (`only works with IRAN bank cards`)
<br>**Payment gateway**: https://idpay.ir/oky2abbas


###### This library is for adding smooth animation and coloring to the FloatingActionButton library android.

<img src="assets/kotlin.gif"> <img src="assets/java.gif">



## Getting Started :

Add to your root build.gradle :
```Groovy
allprojects {
  repositories {
      maven { url 'https://jitpack.io' }
    }
  }
```

Add the dependency : 
```Groovy
dependencies {
    implementation 'com.github.dfmabbas:animator:v1.1.2'
}
```

## Simple API (default) :

##### In `Kotlin`:
```kotlin
val animator1 = Animator().playOn(fab_1)
        .setColoring()              	//adjust the animation for color (optional)
        .setAnimation()             	//adjust animation for movement (optional)

animator1.start()
animator1.stop()

//So easy :) I love Kotlin :)
```

##### In `Java` :
```java
AnimatorObject animator1 = new AnimatorObject().playOn(fab_1)
        .setColoring(ColorModel.BG, 1500, new int[]{Color.BLACK, Color.LTGRAY, Color.MAGENTA})
        .setAnimation(AnimModel.SHAKE, 800);

animator1.start()
animator1.stop()
```

## Advanced API :

##### In `Kotlin`:
###### [Sample code written with Kotlin](sample/src/main/java/com/github/dfmabbas/sample/KotlinView.kt) .

##### In `Java`:
###### [Sample code written with Java](sample/src/main/java/com/github/dfmabbas/sample/JavaView.java) .

## License
    MIT License
    
    Copyright (c) 2018 Abbas Naghdi (@dfmabbas)
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
