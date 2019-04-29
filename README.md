
# Payment Pintro

[![](https://jitpack.io/v/BambangHeriSetiawan/Pintro-Payment.svg)](https://jitpack.io/#BambangHeriSetiawan/Pintro-Payment)

```json
implementation 'com.github.BambangHeriSetiawan:Pintro-Payment:$last_version'
```

# gradle app


```
compileOptions {
        sourceCompatibility = '1.8'
        targetCompatibility = '1.8'
    }
    dataBinding {
        enabled = true
    }
    compileOptions {
        sourceCompatibility = '1.8'
        targetCompatibility = '1.8'
    }
    androidExtensions {
        experimental = true
    }

```

## gradle module

 ```
 allprojects {
     repositories {
         ...
         ...
         maven { url 'https://jitpack.io' }

     }
 }
 ```