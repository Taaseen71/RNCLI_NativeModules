import {NativeModules} from 'react-native';

const {ABC} = NativeModules;

const showToast = () => ABC.show();

export {showToast};
export default ABC;

// export default NativeModules.ABC;
/*
This will be the name defined in 
com.nativemoduleapp.GetDeviceID -> 
public String getName () {
    return "GetDeviceIDName"
}

IF code doesnt work, restart server

*/
