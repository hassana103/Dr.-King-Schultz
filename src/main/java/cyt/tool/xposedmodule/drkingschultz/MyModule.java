package cyt.tool.xposedmodule.drkingschultz;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MyModule implements IXposedHookLoadPackage {

    public static int a;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        XposedBridge.log(">> load app "+lpparam.packageName);
        //XposedBridge.log("Loaded app: " + lpparam.packageName);

        ///########################
        XposedHelpers.findAndHookMethod("com.android.org.conscrypt.TrustManagerImpl", lpparam.classLoader, "verifyChain","java.util.List", "java.util.List", "java.lang.String", "boolean", "[B", "[B", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(">> before hook " + param.args.length);


            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);

                XposedBridge.log(">> after hook " + param.args.length);



            }
        });
        ///#####################################

        ///########################
        XposedHelpers.findAndHookMethod("okhttp3.CertificatePinner.Builder", lpparam.classLoader, "add","java.lang.String", "[Ljava.lang.String;", new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                XposedBridge.log(">> before hook " + param.args[0]);
                param.args[0]="havij.ir";


            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);

                XposedBridge.log(">> after hook " + param.args.length);



            }
        });
        ///#####################################
    }
}
