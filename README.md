# Dr. King Schultz
#### an exposed module to liberate you from OS implemented SSL pinning mechanisms

## Description
i think there is two types of SSL pinning mechanisms in Android:
1. implemented by OS
1. implemented in code

we are here to **just** talk about the first one (by OS)

by OS mechanisms work by Authenticating server certificate using available CAs or configs
by configs i mean *NETWORK_SECURITY_CONFIG* file added in API 24 (Android 7) or Nougat that we will talk about more

back to good old days in API 23 (Android 6) there was no *NETWORK_SECURITY_CONFIG* file to config, in this case the only other way was available CAs
but anybody can add their proxy certificate to the list of CAs and Android would trust it by **default**

but in Android 7 and later the story changes, OS wont trust user added certificates by default, in other hand there is a *NETWORK_SECURITY_CONFIG* file and the default config is 
```xml
    <base-config>
        <trust-anchors>
            <certificates src="system" />
        </trust-anchors>
    </base-config>
```
and if we just imagine there was a *NETWORK_SECURITY_CONFIG* file in Android 6, the default config would be
```xml
    <base-config>
        <trust-anchors>
            <certificates src="system" />
            <certificates src="user" />
        </trust-anchors>
    </base-config>
```
can you see the difference!?
---

until here we realized that just adding your proxy certificate to the device wont help you bypass SSL pinning in Android 7 and higher

by the way this was just the default config. you can have different harder configs in *NETWORK_SECURITY_CONFIG* file
for example:
```xml
    <?xml version="1.0" encoding="utf-8"?>
    <network-security-config>
        
        <!-- no config for example1.com so it uses default-->
    
        <domain-config >
            <domain>example2.com</domain>
            <pin-set >
                <pin digest="SHA-256">PvgYd/Ji7p6Cd2IdJneElSHJE0YAgc40KwDvFqRW/Pw=</pin>
                <pin digest="SHA-256">S4AbJNGvyS57nzJwv8sPMUML8VHSqH1vbiBftdPcErI=</pin>
                <pin digest="SHA-256">qiYwp7YXsE0KKUureoyqpQFubb5gSDeoOoVxn6tmfrU=</pin>
            </pin-set>
        </domain-config>
    
        <domain-config >
            <domain>example3.com</domain>
            <trust-anchors>
                <certificates src="@raw/msn"/>
            </trust-anchors>
        </domain-config>
        
        <domain-config>
            <domain>example4.com</domain>
            <trust-anchors>
                <certificates src="user"/>
                <certificates src="system"/>
            </trust-anchors>
        </domain-config>
    
    </network-security-config>
```
but don't worry, you can bypass all this configs or any other OS implemented configs just using this module
wait!
there is more...
### >>>  you don't need to even add your proxy certificate to the device  <<<

isn't that exiting!!!?

---

#### here is what you need to do
1. root your device using magisk
1. install LSPosed framework
1. download last version of this module APK from [releases]() section
1. install the APK on you device
   ```bash
      adb install DrKingSchults.apk 
   ```
1. enable it in the list of modules in LSPosed
1. select your app
1. set your Proxy properly
1. Done!!

enjoy having your apps traffic in your proxy...