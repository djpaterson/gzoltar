/**
 * Copyright (C) 2018 GZoltar contributors.
 * 
 * This file is part of GZoltar.
 * 
 * GZoltar is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * GZoltar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with GZoltar. If
 * not, see <https://www.gnu.org/licenses/>.
 */
package com.gzoltar.core.instr.granularity;

import javassist.CtClass;
import javassist.bytecode.MethodInfo;

public class LineGranularity extends AbstractGranularity {

  private int currentLine = -1;

  public LineGranularity(final CtClass ctClass, final MethodInfo methodInfo) {
    super(ctClass, methodInfo);
  }

  @Override
  public boolean instrumentAtIndex(final int index, final int instrumentationSize) {
    int previousLine = this.currentLine;
    this.currentLine = this.methodInfo.getLineNumber(index);
    return this.currentLine != previousLine;
  }

  @Override
  public boolean stopInstrumenting() {
    return false;
  }

}
