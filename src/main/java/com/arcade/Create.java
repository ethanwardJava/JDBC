package com.arcade;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // available at runtime
@Target(ElementType.METHOD)         // can only annotate methods
public @interface Create {
}
