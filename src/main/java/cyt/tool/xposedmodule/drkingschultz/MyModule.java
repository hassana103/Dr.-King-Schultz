package cyt.tool.xposedmodule.drkingschultz;

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MyModule implements IXposedHookLoadPackage {

    public static int a;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if (android.os.Build.VERSION.SDK_INT > 27){

            ///########################
            /// hooking start of trace log
            XposedHelpers.findAndHookMethod("com.android.org.conscrypt.ConscryptFileDescriptorSocket",
                    lpparam.classLoader, "verifyCertificateChain",
                    "[[B", "java.lang.String",
                    new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                            return null;
                        }
                    }) ;

        } else{
            ///########################
            /// hooking start of trace log
            XposedHelpers.findAndHookMethod("com.android.org.conscrypt.ConscryptFileDescriptorSocket",
                    lpparam.classLoader, "verifyCertificateChain",
                    "[J", "java.lang.String",
                    new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                            return null;
                        }
                    }) ;
        }
        /*
        ///########################
        /// hooking end of trace log
        XposedHelpers.findAndHookMethod("com.android.org.conscrypt.TrustManagerImpl",
                lpparam.classLoader, "verifyChain",
                "java.util.List", "java.util.List", "java.lang.String", "boolean", "[B", "[B",
                new XC_MethodReplacement() {
                    @Override
                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                        return null;
                    }
                }) ;
         */








    }
}
/* new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        //XposedBridge.log(">> before hook " + param.args.length);
                        return;
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        //XposedBridge.log(">> after hook " + param.args.length);
                    }
                });

 */