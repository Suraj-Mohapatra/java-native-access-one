
package com.ugleagle;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 *
 * @author SURAJ
 */
public class JavaNativeAccessOne {

    // Define an interface that maps to the native C math library
    public interface CMath extends Library {
        CMath INSTANCE = Native.load(Platform.isWindows() ? "msvcrt" : "c", CMath.class);

        double cosh(double value);  // Example: hyperbolic cosine function
        double sin(double value);   // Additional function (optional)
        double sqrt(double value);  // Additional function (optional)
    }

    public static void main(String[] args) {
        CMath lib = CMath.INSTANCE;

        double value = 0.0;
        double coshResult = lib.cosh(value);
        double sinResult = lib.sin(Math.PI / 2); // Optional usage
        double sqrtResult = lib.sqrt(16); // Optional usage

        System.out.println("cosh(" + value + ") = " + coshResult);
        System.out.println("sin(π/2) = " + sinResult);
        System.out.println("sqrt(16) = " + sqrtResult);
    }
}

