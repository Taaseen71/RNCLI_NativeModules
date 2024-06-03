## Step 1: Start the Metro Server

NativeModule Files available in android/app/src/main/java/com/nativemoduleapp/ --> GetDeviceID and GetDeviceIDPackage

```bash
# using npm
npm start

# OR using Yarn
yarn start
```

### For Android

```bash
# using npm
npm run android

# OR using Yarn
yarn android
```

### For iOS

```bash
# using npm
npm run ios

# OR using Yarn
yarn ios
```

## Step 2: Create Native Modules

`bash https://www.youtube.com/watch?v=sLzwjpOcSvc&t=197s `

### Open Android Studio:

```bash
open -a "Android Studio" ./android
```

app>java>com.appnameapp ---> right click and create new class
give nativemodulename

```bash
package com.nativemoduleapp;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class GetDeviceID extends ReactContextBaseJavaModule{

    private static ReactApplicationContext reactContext;

    public GetDeviceID(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @ReactMethod
    public void show(){
        Toast.makeText(reactContext, "Hi from Android", Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void getDeviceID(Promise promise) {
        try {
            String android_ID = Settings.Secure.getString(reactContext.getContentResolver(), Settings.Secure.ANDROID_ID);
            promise.resolve(android_ID);
        } catch (Exception e) {
            promise.reject("error", e.getMessage()); // Reject with error message
        }
    }

    @NonNull
    @Override
    public String getName() {
        return "ABC";
    }
}

```

to make Class Available, use in RN APP. Check src/NativeModules/GetDeviceID.tsx

```bash
@NonNull
  @Override
  public String getName() {
      return "ABC";
  }
```

## Step 3: Export Native Modules Package

Create new class GetDeviceIDPackage. add contexts

```bash
package com.nativemoduleapp;

import androidx.annotation.NonNull;

//import com.anonymous.bareworkflowexample.GetDeviceID;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetDeviceIDPackage implements ReactPackage {

    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new GetDeviceID(reactContext));
        return modules;
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}

```

## Step 4: Open MainApplication.java and Import Package

```bash
         @Override
        protected List<ReactPackage> getPackages() {
            packages.add(new GetDeviceIDPackage());
            return packages;
         }
```

## Step 5: Import from src/NativeModules/GetDeviceID

## Step 6: Expose functions using the export from NativeModules
