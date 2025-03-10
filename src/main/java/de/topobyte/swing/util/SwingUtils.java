// Copyright 2023 Sebastian Kuerten
//
// This file is part of swing-utils.
//
// swing-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// swing-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with swing-utils. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.swing.util;

public class SwingUtils
{

	/**
	 * Sets a - not really well documented, but apparently relatively reliable -
	 * internal property to make scaling up the entire UI work. While Windows
	 * and macOS seem to be doing better at setting up scaling for Swing UIs,
	 * Linux fails miserably to do so for high density displays. Everything can
	 * be very tiny on such display and setting this to a value such as 2.0
	 * helps a lot. Only integral doubles are supported, i.e. 1.0, 2.0, 3.0 etc.
	 * <p>
	 * See this source file
	 * https://github.com/openjdk/jdk/blob/master/src/java.desktop/share/classes/sun/java2d/SunGraphicsEnvironment.java
	 * <p>
	 * Calling this method only works on JDK9+. See the relevant changes to
	 * SunGraphicsEnvironment.java in commit
	 * a00e011325156ae93660cb2ebbaba543fa545c33 that were commit 13 Nov 2015, in
	 * between the releases of JDK 8 in March 2014 and JDK 9 in September 2017.
	 * The changes can be browsed online here:
	 * https://github.com/openjdk/jdk/commit/a00e011325156ae93660cb2ebbaba543fa545c33
	 */
	public static void setUiScale(double uiScale)
	{
		System.setProperty("sun.java2d.uiScale", Double.toString(uiScale));
	}

}
