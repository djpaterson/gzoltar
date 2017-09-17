package com.gzoltar.core.instr.matchers;

import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtField;

public class FieldAttributeMatcher extends AbstractAttributeMatcher {

  public FieldAttributeMatcher(final String attribute) {
    super(attribute);
  }

  @Override
  public final boolean matches(final CtClass ctClass) {
    for (CtField ctField : ctClass.getDeclaredFields()) {
      if (this.matches(ctField)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public final boolean matches(final CtBehavior ctBehavior) {
    throw new RuntimeException(FieldAttributeMatcher.class.getSimpleName()
        + " should only be used to filter out fields or classes with fields");
  }

  @Override
  public final boolean matches(final CtField ctField) {
    return super.matches(ctField);
  }

}